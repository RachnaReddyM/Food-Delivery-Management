package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderContents;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import edu.northeastern.cs5200.repositories.OrderContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContentsServiceImpl implements OrderContentsService {

    @Autowired
    private OrderContentsRepository orderContentsRepository;

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public OrderContents createOrderContents(String itemName, double price, int quantity, FoodOrders foodOrders){


        OrderContents orderContents = new OrderContents(itemName, quantity, price, foodOrders);
        if(foodOrders != null && !foodOrders.getOrderContentsList().contains(orderContents)){
            foodOrders.getOrderContentsList().add(orderContents);
            foodOrdersRepository.save(foodOrders);
        }
        return orderContentsRepository.save(orderContents);
    }
}
