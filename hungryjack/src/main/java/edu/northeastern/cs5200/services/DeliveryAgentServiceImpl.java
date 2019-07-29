package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.Restaurant;
import edu.northeastern.cs5200.repositories.DeliveryAgentRepository;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public DeliveryAgent findByEmail(String email){

        return deliveryAgentRepository.findDeliveryAgentByEmail(email);
    }
    
    public Boolean saveUser(DeliveryAgent deliveryAgent) {
        deliveryAgentRepository.save(deliveryAgent);
        return true;
    }

    public Boolean saveUser(DeliveryAgent deliveryAgent, DeliveryAgent deliveryManager) {

        deliveryAgent.setDeliveryManager(deliveryManager);
        deliveryAgentRepository.save(deliveryAgent);
        if(deliveryManager!= null && !deliveryManager.getDeliveryAgentList().contains(deliveryAgent)){
            deliveryManager.getDeliveryAgentList().add(deliveryAgent);
            deliveryAgentRepository.save(deliveryManager);
        }
    	return true;
    }
    
    public DeliveryAgent findRandom(){
    	
    	Long qty = deliveryAgentRepository.count();
    	int idx = (int)(Math.random() * qty);
    	Page<DeliveryAgent> deliveryAgentPage = deliveryAgentRepository.findAll(new PageRequest(idx, 1));
    	DeliveryAgent q = null;
    	if (deliveryAgentPage.hasContent()) {
    		q = deliveryAgentPage.getContent().get(0);
    	}
    	System.out.println(q);
    	System.out.println(q.getEmail());
    	return q;	
    }
    

    public void assignOrder(FoodOrders foodOrders, DeliveryAgent deliveryAgent){

        if(!deliveryAgent.getOrderList().contains(foodOrders)){
            deliveryAgent.getOrderList().add(foodOrders);
            deliveryAgentRepository.save(deliveryAgent);
            
            foodOrders.setOrderAssigned(deliveryAgent);
            foodOrdersRepository.save(foodOrders);
        }
    }

    public DeliveryAgent findById(int id){

        return deliveryAgentRepository.findDeliveryAgentById(id);
    }

    public List<DeliveryAgent> findAllDeliveryAgents(){

        return (List<DeliveryAgent>)deliveryAgentRepository.findAll();
    }
}
