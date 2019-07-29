package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DeliveryAgent extends User {

    private Boolean status;
    private int salary;
    private String deliveryMode;
    private int numberOfDeliveries;

    @ManyToOne
    private DeliveryAgent deliveryManager;

    @OneToMany(mappedBy = "deliveryManager", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<DeliveryAgent> deliveryAgentList = new ArrayList<>();

    @OneToMany(mappedBy = "orderAssigned", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<FoodOrders> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "reviewToDeliveryAgent", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<DeliveryAgentReview> deliveryAgentReviews = new ArrayList<>();

    public DeliveryAgent(){

    }

    public DeliveryAgent(Boolean status, int salary, String deliveryMode, int numberOfDeliveries, String username, String password, String firstName, String lastName, String email){
        super(username, password, firstName, lastName, email);
        this.status = status;
        this.salary = salary;
        this.deliveryMode = deliveryMode;
        this.numberOfDeliveries = numberOfDeliveries;
    }

    public DeliveryAgent(Boolean status, int salary, String deliveryMode, int numberOfDeliveries, String username, String password, String firstName, String lastName, String email, String phone){
        super(username, password, firstName, lastName, email, phone);
        this.status = status;
        this.salary = salary;
        this.deliveryMode = deliveryMode;
        this.numberOfDeliveries = numberOfDeliveries;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public int getNumberOfDeliveries() {
        return numberOfDeliveries;
    }

    public void setNumberOfDeliveries(int numberOfDeliveries) {
        this.numberOfDeliveries = numberOfDeliveries;
    }

    public List<FoodOrders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<FoodOrders> orderList) {
        this.orderList = orderList;
    }

    public DeliveryAgent getDeliveryManager() {
        return deliveryManager;
    }

    public void setDeliveryManager(DeliveryAgent deliveryManager) {
        this.deliveryManager = deliveryManager;
    }

    public List<DeliveryAgent> getDeliveryAgentList() {
        return deliveryAgentList;
    }

    public void setDeliveryAgentList(List<DeliveryAgent> deliveryAgentList) {
        this.deliveryAgentList = deliveryAgentList;
    }

    public List<DeliveryAgentReview> getDeliveryAgentReviews() {
        return deliveryAgentReviews;
    }

    public void setDeliveryAgentReviews(List<DeliveryAgentReview> deliveryAgentReviews) {
        this.deliveryAgentReviews = deliveryAgentReviews;
    }
}
