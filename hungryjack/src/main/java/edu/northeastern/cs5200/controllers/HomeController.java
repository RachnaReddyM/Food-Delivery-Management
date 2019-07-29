package edu.northeastern.cs5200.controllers;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.services.*;
import edu.northeastern.cs5200.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.cs5200.forms.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DeliveryAgentService deliveryAgentService;

    @Autowired
    private RestaurantManagerService restaurantManagerService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantService resService;

    @Autowired
    private MenuService mennuService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrderReviewsService orderReviewsService;

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = null;
        String type = null;

        if (user != null) {
            email = user.getEmail();
            type = user.getUserType();
        }

        String html = "index";

        if (type != null && type.equals("Customer")) {
            Customer customer = customerService.findByEmail(email);
            model.addAttribute("customer", customer);
            model.addAttribute("deliveryReviewForm", new DeliveryReviewForm());
        }

        if (type != null && type.equals("DeliveryAgent")) {
            DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
            model.addAttribute("deliveryAgent", deliveryAgent);
            html = "deliveryAgent";
        }

        if (type != null && type.equals("RestaurantManager")) {
            RestaurantManager restaurantManager = restaurantManagerService.findByEmail(email);
            model.addAttribute("restaurantManager", restaurantManager);

            List<FoodOrders> orders = restaurantService.findOrdersByRestaurant(restaurantManager.getRestaurantManager());
            model.addAttribute("orders", orders);

            html = "resManager";
        }

        model.addAttribute("search", new Search());
        model.addAttribute("loginForm", new LoginForm());
        return html;
    }

    @GetMapping("/getMenu/{id}")
    public String getMenu(@PathVariable int id, Model model, @ModelAttribute("loginForm") LoginForm loginForm) {
        String resApiKey = resService.findRestaurantKey(id);
        List<Menu> menuItems = mennuService.getMenuItems(resApiKey);
        for(Menu m: menuItems)
            m.setResId(id);
        model.addAttribute("menuItems", menuItems);
        return "resMenu";
    }
    @RequestMapping("/logout")
    public String test(Model model, HttpSession session) {
        session.removeAttribute("user");
        model.addAttribute("search", new Search());
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }
    @RequestMapping("/customer")
    public String customer(Model model, HttpSession session) {
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

    @RequestMapping("/resManager")
    public String resManager() {
        return "resManager";
    }

    @RequestMapping(value = "/register", method=RequestMethod.GET)
    public String register(Model model) {
        RegisterForm form = new RegisterForm();
        List<DeliveryManager> deliveryManagers = new ArrayList<>();
        List<DeliveryAgent> deliveryAgentList = deliveryAgentService.findAllDeliveryAgents();
        for(DeliveryAgent deliveryAgent: deliveryAgentList){
            DeliveryManager deliveryManager = new DeliveryManager();
            deliveryManager.setId(deliveryAgent.getId());
            deliveryManager.setDeliveryManagerName(deliveryAgent.getFirstName());
            deliveryManagers.add(deliveryManager);
        }

        model.addAttribute("deliveryManagers", deliveryManagers);
        model.addAttribute("registerForm", form);
        return "register";
    }

    @RequestMapping("/profile")
    public String profile(Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = user.getEmail();
        String type = user.getUserType();

        ProfileForm profileForm = new ProfileForm();

        if (type.equals("Customer")) {
            Customer customer = customerService.findByEmail(email);
            model.addAttribute("customer", customer);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("DeliveryAgent")) {
            DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
            model.addAttribute("deliveryAgent", deliveryAgent);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("RestaurantManager")) {
            RestaurantManager restaurantManager = restaurantManagerService.findByEmail(email);

            if (restaurantManager.getRestaurantManager() != null) {
                profileForm.setRestaurant(restaurantManager.getRestaurantManager().getRestaurantName());
            }

            model.addAttribute("restaurantManager", restaurantManager);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("Admin")) {
            Admin admin = adminService.findByEmail(email);
            model.addAttribute("admin", admin);
        }

        return "profile";
    }

    @RequestMapping(value = "/users/update", method=RequestMethod.POST)
    public String register(@ModelAttribute("profileForm") ProfileForm profileForm, Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = user.getEmail();
        String type = user.getUserType();
        
        if (type.equals("Customer")) {
            Customer customer = customerService.findByEmail(email);
            customer.setFirstName(profileForm.getName());
            customer.setLastName(profileForm.getName());
            customer.setPassword(profileForm.getPassword());
            customer.setPhone(profileForm.getPhoneNumber());
            customer.setAbout(profileForm.getAbout());
            customerService.saveUser(customer);
            model.addAttribute("customer", customer);
        }
        
        if (type.equals("DeliveryAgent")) {
            DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
            deliveryAgent.setFirstName(profileForm.getName());
            deliveryAgent.setLastName(profileForm.getName());
            deliveryAgent.setPassword(profileForm.getPassword());
            deliveryAgent.setPhone(profileForm.getPhoneNumber());
            deliveryAgent.setDeliveryMode(profileForm.getAbout());
            deliveryAgentService.saveUser(deliveryAgent);
            model.addAttribute("deliveryAgent", deliveryAgent);
        }

        if (type.equals("RestaurantManager")) {
            String restaurantName = profileForm.getRestaurant();
            RestaurantManager restaurantManager = restaurantManagerService.findByEmail(email);
            Restaurant restaurant = restaurantService.findRestaurantsByName(restaurantName).get(0);
            restaurantManagerService.setRestaurant(restaurantManager, restaurant);
            model.addAttribute("restaurantManager", restaurantManager);
        }

        if (type.equals("Admin")) {
            Admin admin = adminService.findByEmail(email);
            admin.setFirstName(profileForm.getName());
            admin.setLastName(profileForm.getName());
            admin.setPassword(profileForm.getPassword());
            admin.setPhone(profileForm.getPhoneNumber());
            adminService.saveUser(admin);
            model.addAttribute("admin", admin);
        }
        
        

        return "profile";
    }

    @RequestMapping("/profile/update")
    public String updateProfile(Model model, HttpSession session) {
        OnlineUser user = (OnlineUser) session.getAttribute("user");
        String email = user.getEmail();
        String type = user.getUserType();

        ProfileForm profileForm = new ProfileForm();

        if (type.equals("Customer")) {
            Customer customer = customerService.findByEmail(email);
            model.addAttribute("customer", customer);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("Admin")) {
            Admin admin = adminService.findByEmail(email);
            model.addAttribute("admin", admin);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("DeliveryAgent")) {
            DeliveryAgent deliveryAgent = deliveryAgentService.findByEmail(email);
            model.addAttribute("deliveryAgent", deliveryAgent);
            model.addAttribute("profileForm", profileForm);
        }

        if (type.equals("RestaurantManager")) {
            RestaurantManager restaurantManager = restaurantManagerService.findByEmail(email);

            if (restaurantManager.getRestaurantManager() != null) {
                profileForm.setRestaurant(restaurantManager.getRestaurantManager().getRestaurantName());
            }

            model.addAttribute("restaurantManager", restaurantManager);
            model.addAttribute("profileForm", profileForm);
        }

        model.addAttribute("update", "true");
        return "profile";
    }

    @RequestMapping("/users")
    public String adminUsers(Model model, HttpSession session) {

        List<User> allUsers = userService.findAllUsers();

        model.addAttribute("allUsers", allUsers);
        return "adminUsers";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUsers(@PathVariable int id, Model model, HttpSession session) {

        userService.deleteUserById(id);
        List<User> allUsers = userService.findAllUsers();

        model.addAttribute("allUsers", allUsers);

        return "adminUsers";
    }

    @GetMapping("/viewUser/{id}")
    public String viewUsers(@PathVariable int id, Model model, HttpSession session) {

        User thisUser = userService.findUserById(id);
        model.addAttribute("thisUser", thisUser);

        return "viewUser";
    }

    @GetMapping("/editUser/{id}")
    public String editUsers(@PathVariable int id, Model model, HttpSession session) {

        User thisUser = userService.findUserById(id);
        model.addAttribute("thisUser", thisUser);

        return "editUser";
    }

    @PostMapping("/edittedUser/{id}")
    public String addEdittedUser(@PathVariable int id, @ModelAttribute("thisUser") User thisUser, Model model, HttpSession session)
    {

        userService.updateUser(id, thisUser.getFirstName(),thisUser.getEmail(),thisUser.getPhone(), thisUser.getUsername());

        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "adminUsers";
    }

    @RequestMapping("/restaurants")
    public String adminRestaurants (Model model, HttpSession session) {

        List<Restaurant> allRestaurants = resService.findAllRestaurnts();

        model.addAttribute("allRestaurants", allRestaurants);

        return "adminRestaurants";
    }

    @PostMapping("/deleteRes/{id}")
    public String deleteRes(@PathVariable int id, Model model, HttpSession session) {

        resService.deleteResById(id);
        List<Restaurant> allRestaurants = resService.findAllRestaurnts();

        model.addAttribute("allRestaurants", allRestaurants);
        return "adminRestaurants";
    }

    @GetMapping("/viewRes/{id}")
    public String viewRestaurant(@PathVariable int id, Model model, HttpSession session) {

        Restaurant thisRes = resService.findResById(id);
        model.addAttribute("thisRes", thisRes);

        return "viewRestaurant";
    }

    @GetMapping("/editRes/{id}")
    public String editRestaurant(@PathVariable int id, Model model, HttpSession session) {

        Restaurant thisRes = resService.findResById(id);
        model.addAttribute("thisRes", thisRes);

        return "editRestaurant";
    }

    @PostMapping("/edittedRes/{id}/{addId}")
    public String addEdittedRes(@PathVariable int id, @PathVariable int addId, @ModelAttribute("thisRes") Restaurant thisRes, Model model, HttpSession session)
    {
        thisRes.getAddress().setId(addId);
        thisRes.getAddress().setRestaurant(thisRes);
        resService.updateRestaurant(id,thisRes);
        List<Restaurant> allRestaurants = resService.findAllRestaurnts();
        model.addAttribute("allRestaurants", allRestaurants);
        return "adminRestaurants";
    }

    @RequestMapping("/createRes/")
    public String createRestaurant(Model model)
    {
        model.addAttribute("restaurant", new Restaurant());
        return "createRestaurant";
    }

    @PostMapping("/newRestaurant/")
    public String newRestaurant(Model model, @ModelAttribute("restaurant") Restaurant restaurant)
    {
        restaurant.getAddress().setRestaurant(restaurant);
        Restaurant res= resService.createRes(restaurant);
        List<Restaurant> allRestaurants = resService.findAllRestaurnts();
        model.addAttribute("allRestaurants", allRestaurants);
        return "adminRestaurants";
    }

    @RequestMapping("/createUser/")
    public String createUser(Model model)
    {
        List<DeliveryManager> deliveryManagers = new ArrayList<>();
        List<DeliveryAgent> deliveryAgentList = deliveryAgentService.findAllDeliveryAgents();
        for(DeliveryAgent deliveryAgent: deliveryAgentList){
            DeliveryManager deliveryManager = new DeliveryManager();
            deliveryManager.setId(deliveryAgent.getId());
            deliveryManager.setDeliveryManagerName(deliveryAgent.getFirstName());
            deliveryManagers.add(deliveryManager);
        }

        model.addAttribute("deliveryManagers", deliveryManagers);
        model.addAttribute("newUser", new RegisterForm());
        return "createUser";
    }

    @PostMapping("/newUser/")
    public String newUser (Model model, @ModelAttribute("newUser") RegisterForm newUser)
    {
        if(newUser!=null) {
            String name = newUser.getName();
            String email = newUser.getEmail();
            String password = newUser.getPassword();
            String phone = newUser.getPhone();
            String username = newUser.getName().toLowerCase();
            String type = newUser.getType();


            if ((customerService.findByEmail(email) != null) || (deliveryAgentService.findByEmail(email) != null) ||
                    (restaurantManagerService.findByEmail(email) != null) || (adminService.findByEmail(email) != null)) {

                model.addAttribute("newUser", newUser);
                model.addAttribute("error", "error");
                System.out.println("User already exists");
            }

            if (type.equals("DeliveryAgent")) {
                int deliveryManagerId = newUser.getDeliveryManagerId();

                DeliveryAgent deliveryManager = deliveryAgentService.findById(deliveryManagerId);
                DeliveryAgent deliveryAgent = new DeliveryAgent(true, 0, "foot", 0, username, password, name, name, email, phone);
                deliveryAgentService.saveUser(deliveryAgent, deliveryManager);

            }
            if (type.equals("Customer")) {
                System.out.println("in customer===" + name);
                Customer customer = new Customer(username, password, name, name, email, phone);
                customer.setAbout(newUser.getAbout());
                System.out.println(customerService.saveUser(customer));
            }
            if (type.equals("RestaurantManager")) {
                RestaurantManager restaurantManager = new RestaurantManager(0, newUser.getWorkStartTime(), newUser.getWorkEndTime(), newUser.getWeeklyOffDay(), username, password, name, name, email, phone);
                restaurantManagerService.saveUser(restaurantManager);
            }

            if(type.equals("Admin"))
            {
                Admin admin = new Admin("key1234",username,password,name,name,email,phone);
                adminService.saveUser(admin);
            }
        }

        /*model.addAttribute("newUser",new RegisterForm());
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);*/
        model.addAttribute("search", new Search());
        model.addAttribute("loginForm", new LoginForm());
        return "index";
    }

    @RequestMapping("/orderReviews")
    public String adminOR (Model model, HttpSession session) {

        List<OrderReviews> allOrderReviews = orderReviewsService.findAllOrderReview();

        model.addAttribute("allOrderReviews", allOrderReviews);

        return "adminOrderReviews";
    }

    @PostMapping("/deleteOr/{id}")
    public String deleteOR(@PathVariable int id, Model model, HttpSession session) {

        orderReviewsService.deleteORById(id);
        List<OrderReviews> allOrderReviews = orderReviewsService.findAllOrderReview();

        model.addAttribute("allOrderReviews", allOrderReviews);

        return "adminOrderReviews";
    }

    @GetMapping("/viewOR/{id}")
    public String viewOR(@PathVariable int id, Model model, HttpSession session) {

        OrderReviews thisOR = orderReviewsService.findOrById(id);
        model.addAttribute("thisOR", thisOR);

        return "viewOrderReview";
    }

    @GetMapping("/editOR/{id}")
    public String editOR(@PathVariable int id, Model model, HttpSession session) {

        OrderReviews thisOR = orderReviewsService.findOrById(id);
        model.addAttribute("thisOR", thisOR);

        return "editOrderReview";
    }

    @PostMapping("/edittedOR/{id}/{oId}/{cid}")
    public String addEdittedRes(@PathVariable int id, @PathVariable int oId, @PathVariable int cid, @ModelAttribute("thisOR") OrderReviews thisOR, Model model, HttpSession session)
    {
        orderReviewsService.updateOrderReview(thisOR);
        List<OrderReviews> allOrderReviews = orderReviewsService.findAllOrderReview();

        model.addAttribute("allOrderReviews", allOrderReviews);

        return "adminOrderReviews";
    }

    @RequestMapping("/createOR/")
    public String createOR(Model model)
    {
        model.addAttribute("orderReview", new OrderReviews());
        return "createOrderReview";
    }

    @PostMapping("/newOR/")
    public String newOrderReview (Model model, @ModelAttribute("orderReview") OrderReviews orderReview)
    {

        OrderReviews createdOR = orderReviewsService.createOrderReview(orderReview);
        List<OrderReviews> allOrderReviews = orderReviewsService.findAllOrderReview();

        model.addAttribute("allOrderReviews", allOrderReviews);

        return "adminOrderReviews";
    }

}