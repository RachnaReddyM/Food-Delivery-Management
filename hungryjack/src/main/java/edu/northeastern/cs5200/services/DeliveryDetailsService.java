package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.DeliveryDetails;
import edu.northeastern.cs5200.models.FoodOrders;

public interface DeliveryDetailsService {

    void createDeliveryDetails(DeliveryDetails deliveryDetails, FoodOrders foodOrders);
}
