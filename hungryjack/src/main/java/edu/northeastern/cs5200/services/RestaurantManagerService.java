package edu.northeastern.cs5200.services;

import java.util.List;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.models.RestaurantManager;

public interface RestaurantManagerService {

	RestaurantManager findByEmail(String email);
    
    Boolean saveUser(RestaurantManager deliveryAgent);
    
    Boolean setRestaurant(RestaurantManager restaurantManager, Restaurant restaurant);

}
