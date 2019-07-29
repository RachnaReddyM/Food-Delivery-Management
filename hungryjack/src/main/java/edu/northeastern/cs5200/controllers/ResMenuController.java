package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.forms.DeliveryReviewForm;
import edu.northeastern.cs5200.forms.LoginForm;
import edu.northeastern.cs5200.forms.OnlineUser;
import edu.northeastern.cs5200.forms.Search;
import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ResMenuController {

    @Autowired
    private FoodOrderService foodOrderService;
    
    @Autowired
    private DeliveryAgentService deliveryAgentService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private OrderContentsService orderContentsService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private DeliveryDetailsService deliveryDetailsService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private DeliveryAgentReviewService deliveryAgentReviewService;
    
    @Autowired
    private OrderReviewsService orderReviewsService;

    @PostMapping("/order/")
    public String orderMade (@RequestParam("orderItems") List<String> menuItems, Model model, HttpSession session) {

        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }


        Customer customer = customerService.findByEmail(email);

        SelectedMenuItems selectedMenuItems = new SelectedMenuItems();

        List<Menu> menuList = new ArrayList<>();
        double totalPrice = 0;
        int orderId=0;
        if(menuItems!=null) {
            for(String s : menuItems) {
                String[] itemDetails = s.split(":");
                System.out.println("menu items==" + itemDetails[0] + " price==" + itemDetails[1]+"res id=="+itemDetails[2]+"quantity=="+itemDetails[3]);
                Menu menu = new Menu(itemDetails[0], Double.parseDouble(itemDetails[1]), Integer.parseInt(itemDetails[3]), Integer.parseInt(itemDetails[2]));
                menuList.add(menu);
                totalPrice+=menu.getPrice();
            }

            FoodOrders foodOrders = foodOrderService.createFoodOrder(totalPrice,"orderSuccessful");
            customerService.assignOrderToCustomer(foodOrders, customer);
            restaurantService.addOrder(menuList.get(0).getResId(), foodOrders);
            for(Menu menu: menuList){
                orderContentsService.createOrderContents(menu.getItemName(), menu.getPrice(), menu.getQuantity(), foodOrders);
            }

            Date date = new Date();
            orderStatusService.createOrderStatus(date.toString(), "ordered", foodOrders);
            
            DeliveryAgent deliveryAgent = deliveryAgentService.findRandom();
            deliveryAgentService.assignOrder(foodOrders, deliveryAgent);
            
            deliveryAgentReviewService.addReview(customer, deliveryAgent, foodOrders);
            orderReviewsService.assignOrderReview(customer, foodOrders);

            orderId = foodOrders.getId();
            selectedMenuItems.setId(orderId);
            selectedMenuItems.setMenuList(menuList);
            model.addAttribute("selectedMenuItems",selectedMenuItems);

            //TODO- should write function to get respective delivery agent and assign orders to them.
            //TODO- assigning orders to delivery agent is already written in service
        }
        else
        {
            System.out.println("no items");
        }

        model.addAttribute("search", new Search());

        model.addAttribute("loginForm", new LoginForm());

        model.addAttribute("user", new OnlineUser());
        DeliveryInstructions deliveryInstructions = new DeliveryInstructions(menuList);
        deliveryInstructions.setOrderId(orderId);
        model.addAttribute("instructions", deliveryInstructions);
        return "orderManage";
    }

    @PostMapping("/placeOrder/")
    public String selectedOrder (@ModelAttribute DeliveryInstructions instructions,Model model, HttpSession session) {

        FoodOrders foodOrders = foodOrderService.findFoodOrderById(instructions.getOrderId());

        DeliveryDetails deliveryDetails = new DeliveryDetails();
        deliveryDetails.setStreet(instructions.getStreet());
        deliveryDetails.setApartmentNumber(instructions.getApt());
        deliveryDetails.setCity(instructions.getCity());
        deliveryDetails.setState(instructions.getState());
        deliveryDetails.setCountry(instructions.getCountry());
        deliveryDetails.setDeliveryComments(instructions.getDeliveryInstructions());
        deliveryDetails.setZipCode(instructions.getDelzipcode());
        deliveryDetailsService.createDeliveryDetails(deliveryDetails, foodOrders);

        //TODO- should write function to get respective delivery agent and assign orders to them.
        //TODO- assigning orders to delivery agent is already written in service
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }

        if (type != null && type.equals("Customer")) {
            Customer customer = customerService.findByEmail(email);
            model.addAttribute("customer", customer);
        }
        
        model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());

        return "customer";
    }
}
