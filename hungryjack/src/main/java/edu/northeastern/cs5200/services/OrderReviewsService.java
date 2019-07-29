package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderReviews;

import java.util.List;

public interface OrderReviewsService {

    void assignOrderReview(Customer customer, FoodOrders foodOrders);
    
    void updateReview(int ratings, String review, FoodOrders foodOrder);

    List<OrderReviews> findAllOrderReview();

    void deleteORById(int id);

    OrderReviews findOrById(int id);

    OrderReviews createOrderReview(OrderReviews OR);
    void updateOrderReview(OrderReviews OR);
}
