package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.DeliveryAgent;
import edu.northeastern.cs5200.models.DeliveryAgentReview;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.repositories.CustomerRepository;
import edu.northeastern.cs5200.repositories.DeliveryAgentRepository;
import edu.northeastern.cs5200.repositories.DeliveryAgentReviewRepository;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAgentReviewServiceImpl implements DeliveryAgentReviewService {

    @Autowired
    private DeliveryAgentReviewRepository deliveryAgentReviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;
    
    @Autowired
    private FoodOrdersRepository foodOrderRepository;

    public void addReview(Customer customer, DeliveryAgent deliveryAgent, FoodOrders foodOrder){
        DeliveryAgentReview deliveryAgentReview = new DeliveryAgentReview();
        if(customer != null){
            deliveryAgentReview.setReviewByCustomer(customer);
        }
        if(deliveryAgent != null){
            deliveryAgentReview.setReviewToDeliveryAgent(deliveryAgent);
        }
        if(foodOrder != null) {
        	deliveryAgentReview.setRelatedOrder(foodOrder);
        }
        DeliveryAgentReview deliveryAgentReview1 = deliveryAgentReviewRepository.save(deliveryAgentReview);

        if(customer!=null && !customer.getDeliveryAgentReviews().contains(deliveryAgentReview1)){
            customer.getDeliveryAgentReviews().add(deliveryAgentReview1);
            customerRepository.save(customer);
        }
        if(deliveryAgent != null && !deliveryAgent.getDeliveryAgentReviews().contains(deliveryAgentReview1)){
            deliveryAgent.getDeliveryAgentReviews().add(deliveryAgentReview1);
            deliveryAgentRepository.save(deliveryAgent);
        }
        
    }
    
    public void updateReview(int ratings, String review, FoodOrders foodOrder) {
    	DeliveryAgentReview deliveryAgentReview = deliveryAgentReviewRepository.findDeliveryAgentReviewById(foodOrder.getId());
    	deliveryAgentReview.setRatings(ratings);
    	deliveryAgentReview.setReview(review);
    	deliveryAgentReviewRepository.save(deliveryAgentReview);
    }
}
