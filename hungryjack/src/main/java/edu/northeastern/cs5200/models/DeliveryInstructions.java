package edu.northeastern.cs5200.models;

import java.util.List;

public class DeliveryInstructions {

    private String prepInstructions;
    private String apt;
    private String street;
    private String city;
    private String state;
    private String country;
    private String delzipcode;
    private String deliveryInstructions;
    private List<Menu> menuItems;
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public DeliveryInstructions() {
    }

    public DeliveryInstructions(List<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    public DeliveryInstructions(String prepInstructions, String apt, String street, String city, String state, String country, String delzipcode, String deliveryInstructions, List<Menu> menuItems) {
        this.prepInstructions = prepInstructions;
        this.apt = apt;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.delzipcode = delzipcode;
        this.deliveryInstructions = deliveryInstructions;
        this.menuItems = menuItems;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    public DeliveryInstructions(String prepInstructions, String apt, String street, String city, String state, String country, String delzipcode, String deliveryInstructions) {
        this.prepInstructions = prepInstructions;
        this.apt = apt;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.delzipcode = delzipcode;
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getPrepInstructions() {
        return prepInstructions;
    }

    public void setPrepInstructions(String prepInstructions) {
        this.prepInstructions = prepInstructions;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    public String getDelzipcode() {
        return delzipcode;
    }

    public void setDelzipcode(String delzipcode) {
        this.delzipcode = delzipcode;
    }
}
