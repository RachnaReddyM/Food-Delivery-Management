package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.services.*;
import edu.northeastern.cs5200.forms.*;
import edu.northeastern.cs5200.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ReviewController {
	
    @Autowired
    private CustomerService customerService;

    @Autowired
    private DeliveryAgentService deliveryAgentService;
    
    @Autowired
    private DeliveryAgentReviewService deliveryAgentReviewService;
    
    @Autowired
    private FoodOrderService foodOrderService;
    
    @Autowired
    private OrderReviewsService orderReviewsService;
	
    @RequestMapping(value = "/customer/deliveryDriverReview/{id}", method=RequestMethod.POST)
    public String deliveryDriverReview(@PathVariable int id, @ModelAttribute("deliveryReviewForm") DeliveryReviewForm deliveryReviewForm, Model model, HttpSession session) {
    	
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = user.getEmail();
        String type = user.getUserType();
        
        FoodOrders foodOrder = foodOrderService.findFoodOrderById(id);
        Customer customer = customerService.findByEmail(email);
        DeliveryAgent deliveryAgent = foodOrder.getOrderAssigned();
        
        deliveryAgentReviewService.updateReview(deliveryReviewForm.getRatings(), deliveryReviewForm.getReview(), foodOrder);
    	
        model.addAttribute("customer", customer);
        model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
        
        return "customer";
        
    }
    
    @RequestMapping(value = "/customer/orderReview/{id}", method=RequestMethod.POST)
    public String ordersReview(@PathVariable int id, @ModelAttribute("deliveryReviewForm") DeliveryReviewForm deliveryReviewForm, Model model, HttpSession session) {
    	
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = user.getEmail();
        String type = user.getUserType();
        
        FoodOrders foodOrder = foodOrderService.findFoodOrderById(id);
        Customer customer = customerService.findByEmail(email);
        
        orderReviewsService.updateReview(deliveryReviewForm.getRatings(), deliveryReviewForm.getReview(), foodOrder);
    	
        model.addAttribute("customer", customer);
        model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
        
        return "customer";
        
    }
}
