package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class OrderStatus {

    //TODO - no constructors for this. create object and then assign values using getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String OrderedAt;
    private String preparedAt;
    private String deliveredAt;
    //TODO - order status can be either "orderReceived", "orderPrepared", "orderEnroute", "orderDelivered"
    private String orderStatus;

    @OneToOne
    private FoodOrders relatedOrder;

    public OrderStatus(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderedAt() {
        return OrderedAt;
    }

    public void setOrderedAt(String orderedAt) {
        OrderedAt = orderedAt;
    }

    public String getPreparedAt() {
        return preparedAt;
    }

    public void setPreparedAt(String preparedAt) {
        this.preparedAt = preparedAt;
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(String deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public FoodOrders getRelatedOrder() {
        return relatedOrder;
    }

    public void setRelatedOrder(FoodOrders relatedOrder) {
        this.relatedOrder = relatedOrder;
    }
}
