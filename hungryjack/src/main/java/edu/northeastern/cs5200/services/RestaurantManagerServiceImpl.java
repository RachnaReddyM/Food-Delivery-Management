package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.models.RestaurantManager;
import edu.northeastern.cs5200.repositories.RestaurantManagerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    @Autowired
    private RestaurantManagerRepository restaurantAgentRepository;

    public RestaurantManager findByEmail(String email){

        return restaurantAgentRepository.findRestaurantManagerByEmail(email);
    }
    
    public Boolean saveUser(RestaurantManager restaurantManager) {
    	restaurantAgentRepository.save(restaurantManager);
    	return true;
    }
    
    public Boolean setRestaurant(RestaurantManager restaurantManager, Restaurant restaurant) {
    	restaurantManager.setRestaurantManager(restaurant);
    	restaurantAgentRepository.save(restaurantManager);
    	return true;
    }

}