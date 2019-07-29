package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.services.*;
import edu.northeastern.cs5200.forms.*;
import edu.northeastern.cs5200.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DeliveryAgentService deliveryAgentService;

    @Autowired
    private RestaurantManagerService restaurantManagerService;

    @RequestMapping(value = "/users/register", method=RequestMethod.POST)
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm, Model model, HttpSession session) {
        String name = registerForm.getName();
        String email = registerForm.getEmail();
        String password = registerForm.getPassword();
        String phone = registerForm.getAddress();
        String type = registerForm.getType();

        OnlineUser user = new OnlineUser();
        user.setEmail(email);
        user.setUserType(type);

        String html = null;

        if ((customerService.findByEmail(email) != null) || (deliveryAgentService.findByEmail(email) != null) ||
                (restaurantManagerService.findByEmail(email) != null)){

            model.addAttribute("registerForm", registerForm);
            model.addAttribute("error", "error");
            return "register";
        }

        if (type.equals("DeliveryAgent")) {
            int deliveryManagerId = registerForm.getDeliveryManagerId();

            DeliveryAgent deliveryManager = deliveryAgentService.findById(deliveryManagerId);
            DeliveryAgent deliveryAgent = new DeliveryAgent(true, 0, "foot", 0, name.toLowerCase(), password, name, name, email,phone);
            model.addAttribute("deliveryAgent", deliveryAgent);
            deliveryAgentService.saveUser(deliveryAgent, deliveryManager);
            session.setAttribute("user", user);
            html = "deliveryAgent";
            
        }
        if (type.equals("Customer")) {
            Customer customer = new Customer(name.toLowerCase(), password, name, name, email,phone);
            customer.setAbout(registerForm.getAbout());
            customerService.saveUser(customer);
            model.addAttribute("search", new Search());
            model.addAttribute("loginForm", new LoginForm());
            model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
            session.setAttribute("user", user);
            html = "index";
        }
        if (type.equals("RestaurantManager")) {
            RestaurantManager restaurantManager = new RestaurantManager(0, registerForm.getWorkStartTime(), registerForm.getWorkEndTime(), registerForm.getWeeklyOffDay(), name.toLowerCase(), password, name, name, email,phone);
            restaurantManagerService.saveUser(restaurantManager);
            session.setAttribute("user", user);
            
            List<FoodOrders> orders = restaurantService.findOrdersByRestaurant(restaurantManager.getRestaurantManager());
            model.addAttribute("orders", orders);
            
            html = "resManager";
        }
        
        return html;
    }

}