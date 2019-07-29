package edu.northeastern.cs5200.services;

import edu.northeastern.cs5200.models.Customer;
import edu.northeastern.cs5200.models.FoodOrders;
import edu.northeastern.cs5200.models.User;

public interface CustomerService {

    Customer findByEmail(String email);
    
    Boolean saveUser(Customer customer);

    void assignOrderToCustomer(FoodOrders foodOrders, Customer customer);
}
