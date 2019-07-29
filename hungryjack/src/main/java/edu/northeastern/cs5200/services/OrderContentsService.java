package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderContents;

public interface OrderContentsService {

    OrderContents createOrderContents(String itemName, double price, int quantity, FoodOrders foodOrders);
}
