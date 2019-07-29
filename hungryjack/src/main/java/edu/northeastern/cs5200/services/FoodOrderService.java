package edu.northeastern.cs5200.services;


import edu.northeastern.cs5200.models.FoodOrders;

import java.util.List;

public interface FoodOrderService {

    List<FoodOrders> findAllFoodOrders();

    FoodOrders createFoodOrder(double total_price, String prepComments);

    FoodOrders findFoodOrderById(int id);
}
