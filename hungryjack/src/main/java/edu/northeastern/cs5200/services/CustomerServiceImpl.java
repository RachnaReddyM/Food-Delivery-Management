package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.repositories.CustomerRepository;
import edu.northeastern.cs5200.repositories.FoodOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FoodOrdersRepository foodOrdersRepository;

    public Customer findByEmail(String email){

        return customerRepository.findCustomerByEmail(email);
    }
    
    public Boolean saveUser(Customer customer) {
    	customerRepository.save(customer);
    	return true;
    }

    public void assignOrderToCustomer(FoodOrders foodOrders, Customer customer){
        if(foodOrders != null){
            foodOrders.setCustomer(customer);
            foodOrdersRepository.save(foodOrders);
        }
        if(customer != null && !customer.getCustomerOrderList().contains(foodOrders)){
            customer.getCustomerOrderList().add(foodOrders);
            customerRepository.save(customer);
        }
    }
}
