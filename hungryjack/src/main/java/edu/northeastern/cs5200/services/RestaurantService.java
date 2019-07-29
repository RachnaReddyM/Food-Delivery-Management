package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.api.RestaurantApi;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findRestaurantsByName(String email);
    String findRestaurantKey(int id);

    RestaurantApi getAllRestaurants();

    List<Restaurant> findAllRestaurnts();

    void createRestaurantTable();

    void addOrder(int id, FoodOrders foodOrders);

    void deleteResById(int id);
    Restaurant findResById(int id);

    void updateRestaurant(int id, Restaurant res);

    Restaurant createRes(Restaurant res);
    
    List<FoodOrders> findOrdersByRestaurant(edu.northeastern.cs5200.models.Restaurant restaurant);

}
