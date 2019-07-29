package edu.northeastern.cs5200.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;

import java.util.List;

public interface DeliveryAgentService {

    DeliveryAgent findByEmail(String email);
    
    Boolean saveUser(DeliveryAgent deliveryAgent, DeliveryAgent deliveryManager);

    Boolean saveUser(DeliveryAgent deliveryAgent);
    
    void assignOrder(FoodOrders foodOrders, DeliveryAgent deliveryAgent);

    public DeliveryAgent findRandom();

    DeliveryAgent findById(int id);

    List<DeliveryAgent> findAllDeliveryAgents();
}
