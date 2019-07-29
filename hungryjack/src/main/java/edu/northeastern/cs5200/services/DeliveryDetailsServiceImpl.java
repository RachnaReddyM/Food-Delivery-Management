package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.DeliveryDetails;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.repositories.DeliveryDetailesRepository;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryDetailsServiceImpl implements DeliveryDetailsService{

    @Autowired
    private DeliveryDetailesRepository deliveryDetailesRepository;

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public void createDeliveryDetails(DeliveryDetails deliveryDetails, FoodOrders foodOrders){

        if(deliveryDetails != null){
            deliveryDetails.setOrderDeliveryDetails(foodOrders);
            deliveryDetailesRepository.save(deliveryDetails);
        }

        if(foodOrders != null){
            foodOrders.setDeliveryDetails(deliveryDetails);
            foodOrdersRepository.save(foodOrders);
        }
    }
}
