package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String restaurantName;
    private String deliveryStartTime;
    private String deliveryEndTime;
    private String restaurantKey;

    @OneToMany(mappedBy = "restaurantOrder", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<FoodOrders> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurantManager", cascade={CascadeType.ALL},orphanRemoval = true)
    private List<RestaurantManager> restaurantManagerList = new ArrayList<>();

    @OneToOne(mappedBy = "restaurant", cascade={CascadeType.ALL},orphanRemoval = true)
    private RestaurantAddress address;

    public Restaurant(){

    }

    public Restaurant(String restaurantName, String deliveryStartTime, String deliveryEndTime, String restaurantKey){

        this.restaurantName = restaurantName;
        this.deliveryStartTime = deliveryStartTime;
        this.deliveryEndTime = deliveryEndTime;
        this.restaurantKey = restaurantKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDeliveryStartTime() {
        return deliveryStartTime;
    }

    public void setDeliveryStartTime(String deliveryStartTime) {
        this.deliveryStartTime = deliveryStartTime;
    }

    public String getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(String deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public List<FoodOrders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<FoodOrders> orderList) {
        this.orderList = orderList;
    }

    public List<RestaurantManager> getRestaurantManagerList() {
        return restaurantManagerList;
    }

    public void setRestaurantManagerList(List<RestaurantManager> restaurantManagerList) {
        this.restaurantManagerList = restaurantManagerList;
    }

    public String getRestaurantKey() {
        return restaurantKey;
    }

    public void setRestaurantKey(String restaurantKey) {
        this.restaurantKey = restaurantKey;
    }

    public RestaurantAddress getAddress() {
        return address;
    }

    public void setAddress(RestaurantAddress address) {
        this.address = address;
    }
}
