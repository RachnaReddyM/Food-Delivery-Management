package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderStatus;

public interface OrderStatusService {

    void createOrderStatus(String orderedAt, String orderStatus, FoodOrders foodOrders);

    void updateOrderStatus(OrderStatus orderStatus, String status);
    
    OrderStatus findOrderStatusById(Integer id);

    OrderStatus findOrderStatusByFoodOrderId(FoodOrders foodOrders);
}
