package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.OrderReviews;
import edu.northeastern.cs5200.repositories.CustomerRepository;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import edu.northeastern.cs5200.repositories.OrderReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderReviewsServiceImpl implements OrderReviewsService{

    @Autowired
    private OrderReviewsRepository orderReviewsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public void assignOrderReview(Customer customer, FoodOrders foodOrders){

        OrderReviews orderReviews = new OrderReviews();
        if(customer != null){
            orderReviews.setCustomerOrderReview(customer);
        }
        if(foodOrders != null){
            orderReviews.setFoodOrderReview(foodOrders);
        }
        OrderReviews orderReviews1 = orderReviewsRepository.save(orderReviews);
        if(customer != null && !customer.getOrderReviews().contains(orderReviews1)){
            customer.getOrderReviews().add(orderReviews1);
            customerRepository.save(customer);

        }
        if(foodOrders != null){
            foodOrders.setOrderReviews(orderReviews1);
            foodOrdersRepository.save(foodOrders);
        }
    }
    
    public void updateReview(int ratings, String review, FoodOrders foodOrder) {
    	OrderReviews orderReview = orderReviewsRepository.findOrderReviewById(foodOrder.getId());
    	orderReview.setRatings(ratings);
    	orderReview.setReview(review);
    	orderReviewsRepository.save(orderReview);
    }

    public List<OrderReviews> findAllOrderReview()
    {
        return (List<OrderReviews>)orderReviewsRepository.findAll();
    }

    public void deleteORById(int id)
    {
        orderReviewsRepository.deleteById(id);
    }

    public OrderReviews findOrById(int id)
    {
        return orderReviewsRepository.findOrderReviewById(id);
    }

    public OrderReviews createOrderReview(OrderReviews OR)
    {
        return orderReviewsRepository.save(OR);
    }

    public void updateOrderReview(OrderReviews OR)
    {
        orderReviewsRepository.save(OR);
    }
}
