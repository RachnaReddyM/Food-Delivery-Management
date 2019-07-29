package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.forms.DeliveryReviewForm;
import edu.northeastern.cs5200.forms.LoginForm;
import edu.northeastern.cs5200.forms.OnlineUser;
import edu.northeastern.cs5200.forms.Search;
import edu.northeastern.cs5200.models.Admin;
import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.RestaurantManager;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.services.AdminService;
import edu.northeastern.cs5200.services.CustomerService;
import edu.northeastern.cs5200.services.DeliveryAgentService;
import edu.northeastern.cs5200.services.LoginService;
import edu.northeastern.cs5200.services.RestaurantManagerService;
import edu.northeastern.cs5200.services.RestaurantService;
import edu.northeastern.cs5200.services.UserService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RestaurantService restaurantService;
    
    @Autowired
    private DeliveryAgentService deliveryAgentService;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private RestaurantManagerService restaurantManagerService;

	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String register(@ModelAttribute("loginForm") LoginForm loginForm, Model model, HttpSession session) {
		String email = loginForm.getEmail();
		String password =loginForm.getPassword();
		
		OnlineUser user = new OnlineUser();
		
		String html = null;
		
        Customer customer = customerService.findByEmail(loginForm.getEmail());
        if (customer != null && loginForm.getEmail().equals(customer.getEmail()) && 
        		loginForm.getPassword().equals(customer.getPassword())) {
    		user.setEmail(loginForm.getEmail());
    		user.setUserType("Customer");
            session.setAttribute("user", user);
            
            model.addAttribute("customer", customer);
            
            model.addAttribute("search", new Search());
            model.addAttribute("loginForm", new LoginForm());
            model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
            html = "index";
        }
        
        DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(loginForm.getEmail());
        if (deliveryAgent != null && loginForm.getEmail().equals(deliveryAgent.getEmail()) && 
        		loginForm.getPassword().equals(deliveryAgent.getPassword())) {
    		user.setEmail(loginForm.getEmail());
    		user.setUserType("DeliveryAgent");
            session.setAttribute("user", user);
            
            model.addAttribute("deliveryAgent", deliveryAgent);
            
            html = "deliveryAgent";
        }
        
        RestaurantManager restaurantManager = restaurantManagerService.findByEmail(loginForm.getEmail());
        if (restaurantManager != null && loginForm.getEmail().equals(restaurantManager.getEmail()) && 
        		loginForm.getPassword().equals(restaurantManager.getPassword())) {
    		user.setEmail(loginForm.getEmail());
    		user.setUserType("RestaurantManager");
            session.setAttribute("user", user);
            
            model.addAttribute("restaurantManager", restaurantManager);
            
            List<FoodOrders> orders = restaurantService.findOrdersByRestaurant(restaurantManager.getRestaurantManager());
            model.addAttribute("orders", orders);
            
            html = "resManager";
        }

        Admin admin = adminService.findByEmail(loginForm.getEmail());
        if (admin != null && loginForm.getEmail().equals(admin.getEmail()) && 
        		loginForm.getPassword().equals(admin.getPassword())) {
            user.setEmail(loginForm.getEmail());
            user.setUserType("Admin");
            session.setAttribute("user", user);
            html = "adminIndex";
            model.addAttribute("search", new Search());
            model.addAttribute("loginForm", new LoginForm());
        }
        
        // Error Handling
        if (html == null) {
            model.addAttribute("search", new Search());
            model.addAttribute("loginForm", new LoginForm());
            model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
            model.addAttribute("error", "error");
            html = "index";
        }


		return html;
	}

}
