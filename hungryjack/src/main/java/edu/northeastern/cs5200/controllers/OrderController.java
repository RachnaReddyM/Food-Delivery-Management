package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.services.*;
import edu.northeastern.cs5200.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.cs5200.forms.*;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.*;

@Controller
public class OrderController {
	
    @Autowired
    private OrderStatusService orderStatusService;
    
    @Autowired
    private DeliveryAgentService deliveryAgentService;
    
    @Autowired
    private RestaurantManagerService restaurantManagerService;
    
    @Autowired
    private RestaurantService restaurantService;
    
    
    @PostMapping("/restaurantManager/prepared/{id}")
    public String restaurantManagerPrepared(@PathVariable int id, Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }
    	
    	OrderStatus status = orderStatusService.findOrderStatusById(id);
    	
    	orderStatusService.updateOrderStatus(status, "orderPrepared");
    	
        RestaurantManager restaurantManager = restaurantManagerService.findByEmail(email);
        model.addAttribute("restaurantManager", restaurantManager);
        
        List<FoodOrders> orders = restaurantService.findOrdersByRestaurant(restaurantManager.getRestaurantManager());
        model.addAttribute("orders", orders);
        
        return "resManager";
    }
    
	
    @PostMapping("/deliveryAgent/delivered/{id}")
    public String deliveryAgentDelivered(@PathVariable int id, Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }
    	
    	OrderStatus status = orderStatusService.findOrderStatusById(id);

    	orderStatusService.updateOrderStatus(status, "orderDelivered");
    	
        DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
        model.addAttribute("deliveryAgent", deliveryAgent);
        
        return "deliveryAgent";
    }
    
    @PostMapping("/deliveryAgent/enroute/{id}")
    public String deliveryAgentEnroute(@PathVariable int id, Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }
    	
    	OrderStatus status = orderStatusService.findOrderStatusById(id);
    	
    	orderStatusService.updateOrderStatus(status, "orderEnroute");
    	
        DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
        model.addAttribute("deliveryAgent", deliveryAgent);
        
        return "deliveryAgent";
    }

}
