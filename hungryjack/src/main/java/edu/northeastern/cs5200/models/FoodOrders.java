package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalPrice;
    private String orderPrepComments;

    @ManyToOne
    private Restaurant restaurantOrder;

    @OneToOne(mappedBy = "orderDeliveryDetails", cascade={CascadeType.ALL},orphanRemoval = true)
    private DeliveryDetails deliveryDetails;

    @OneToMany(mappedBy = "orderContent", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<OrderContents> orderContentsList = new ArrayList<>();

    @ManyToOne
    private DeliveryAgent orderAssigned;

    @OneToOne(mappedBy = "relatedOrder", cascade={CascadeType.ALL},orphanRemoval = true)
    private OrderStatus orderStatus;
    
    @OneToOne(mappedBy = "relatedOrder", cascade={CascadeType.ALL},orphanRemoval = true)
    private DeliveryAgentReview deliveryAgentReview;

	@ManyToOne
    private Customer customer;

	@OneToOne(mappedBy = "foodOrderReview", cascade={CascadeType.ALL},orphanRemoval = true)
    private OrderReviews orderReviews;

    public FoodOrders(){

    }

    public FoodOrders(double totalPrice, String orderPrepComments){

        this.totalPrice = totalPrice;
        this.orderPrepComments = orderPrepComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderPrepComments() {
        return orderPrepComments;
    }

    public void setOrderPrepComments(String orderPrepComments) {
        this.orderPrepComments = orderPrepComments;
    }

    public Restaurant getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(Restaurant restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public DeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public List<OrderContents> getOrderContentsList() {
        return orderContentsList;
    }

    public void setOrderContentsList(List<OrderContents> orderContentsList) {
        this.orderContentsList = orderContentsList;
    }

    public DeliveryAgent getOrderAssigned() {
        return orderAssigned;
    }

    public void setOrderAssigned(DeliveryAgent orderAssigned) {
        this.orderAssigned = orderAssigned;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public DeliveryAgentReview getDeliveryAgentReview() {
		return deliveryAgentReview;
	}

	public void setDeliveryAgentReview(DeliveryAgentReview deliveryAgentReview) {
		this.deliveryAgentReview = deliveryAgentReview;
	}

    public OrderReviews getOrderReviews() {
        return orderReviews;
    }

    public void setOrderReviews(OrderReviews orderReviews) {
        this.orderReviews = orderReviews;
    }
}