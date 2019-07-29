package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public List<FoodOrders> findAllFoodOrders(){

        return (List<FoodOrders>) foodOrdersRepository.findAll();
    }

    public FoodOrders createFoodOrder(double total_price, String prepComments){

        FoodOrders foodOrders = new FoodOrders(total_price, prepComments);
        
        return foodOrdersRepository.save(foodOrders);
    }

    public FoodOrders findFoodOrderById(int id){
        return foodOrdersRepository.findFoodOrderById(id);
    }
}
