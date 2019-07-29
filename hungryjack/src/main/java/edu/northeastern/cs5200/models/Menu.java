package edu.northeastern.cs5200.models;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Menu {

    private String itemName;
    private double price;
    private int resId;
    private int quantity;

    public Menu(){

    }

    public Menu(String itemName, double price){
        this.itemName = itemName;
        this.price = price;
        this.quantity = 1;

    }

    public Menu(String itemName, double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Menu(String itemName, double price, int quantity, int resId){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.resId = resId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
