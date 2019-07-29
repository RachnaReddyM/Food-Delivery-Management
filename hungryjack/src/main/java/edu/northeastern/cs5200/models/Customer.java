package edu.northeastern.cs5200.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {

    //TODO - this will be populated only after the customer's first order
    private String about;
    private int creditsEarner;

    @OneToMany(mappedBy = "customer", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<FoodOrders> customerOrderList = new ArrayList<>();

    @OneToMany(mappedBy = "reviewByCustomer", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<DeliveryAgentReview> deliveryAgentReviews = new ArrayList<>();

    @OneToMany(mappedBy = "customerOrderReview", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<OrderReviews> orderReviews = new ArrayList<>();

    public Customer(){

    }

    public Customer(String username, String password, String firstName, String lastName, String email){
        super(username, password, firstName, lastName, email);
    }

    public Customer(String username, String password, String firstName, String lastName, String email, String phone){
        super(username, password, firstName, lastName, email, phone);
    }

    public int getCreditsEarner() {
        return creditsEarner;
    }

    public void setCreditsEarner(int creditsEarner) {
        this.creditsEarner = creditsEarner;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<FoodOrders> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(List<FoodOrders> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    public List<DeliveryAgentReview> getDeliveryAgentReviews() {
        return deliveryAgentReviews;
    }

    public void setDeliveryAgentReviews(List<DeliveryAgentReview> deliveryAgentReviews) {
        this.deliveryAgentReviews = deliveryAgentReviews;
    }

    public List<OrderReviews> getOrderReviews() {
        return orderReviews;
    }

    public void setOrderReviews(List<OrderReviews> orderReviews) {
        this.orderReviews = orderReviews;
    }
}
