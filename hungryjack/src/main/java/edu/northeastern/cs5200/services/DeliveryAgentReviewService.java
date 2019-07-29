package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.FoodOrders;

public interface DeliveryAgentReviewService {

    void addReview(Customer customer, DeliveryAgent deliveryAgent, FoodOrders foodOrder);
    
    void updateReview(int ratings, String review, FoodOrders foodOrder);
}
