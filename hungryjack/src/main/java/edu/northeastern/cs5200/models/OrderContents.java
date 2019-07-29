package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class OrderContents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String menuItem;
    private int itemQuantity;
    private double itemPrice;

    @ManyToOne
    private FoodOrders orderContent;

    public OrderContents(){

    }

    public OrderContents(String menuItem, int itemQuantity, double itemPrice){

        this.menuItem = menuItem;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public OrderContents(String menuItem, int itemQuantity, double itemPrice, FoodOrders orderContent){

        this.menuItem = menuItem;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.orderContent = orderContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public FoodOrders getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(FoodOrders orderContent) {
        this.orderContent = orderContent;
    }
}
