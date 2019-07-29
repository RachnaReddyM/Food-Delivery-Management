package edu.northeastern.cs5200;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;
import edu.northeastern.cs5200.services.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HungryjackApplicationTests {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantManagerRepository restaurantManagerRepository;

    @Test
    public void contextLoads() {

        restaurantService.createRestaurantTable();
        Admin admin = new Admin("root","admin","admin","Admin","Admin","admin@admin.com");
        DeliveryAgent alice = new DeliveryAgent(true, 1000, "Car", 0, "alice", "alice", "Alice", "Alice", "alice@alice.com");
        DeliveryAgent frank = new DeliveryAgent(true, 1000, "Car", 10, "frank", "frank", "frank", "frank", "frank@frank.com");
        Customer bob = new Customer("bob", "bob", "Bob", "Bob", "bob@bob.com", "88888");
        Customer ed = new Customer("ed", "ed", "Ed", "Ed", "ed@ed.com", "888888888");
        RestaurantManager charlie = new RestaurantManager(1000, "08:00", "21:00", "Monday", "charlie", "charlie", "Charlie", "Charlie", "charlie@charlie.com", "9999");
        RestaurantManager han = new RestaurantManager(1000, "08:00", "21:00", "Tuesday", "han", "han", "Han", "Han", "han@han.com", "999900999");
        List<Restaurant> restaurantList = restaurantService.findRestaurantsByName("eatery");
        List<Restaurant> restaurantListhan = restaurantService.findRestaurantsByName("n");
        if(restaurantList != null && restaurantList.size() > 0){
            charlie.setRestaurantManager(restaurantList.get(0));
        }
        if(restaurantListhan != null && restaurantListhan.size() > 0){
            han.setRestaurantManager(restaurantListhan.get(0));
        }
        restaurantManagerRepository.save(charlie);
        customerRepository.save(bob);
        deliveryAgentRepository.save(alice);

        restaurantManagerRepository.save(han);
        customerRepository.save(ed);
        deliveryAgentRepository.save(frank);
        adminRepository.save(admin);

    }

}