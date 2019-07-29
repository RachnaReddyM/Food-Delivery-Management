package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private FoodOrders orderDeliveryDetails;

    private String apartmentNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String deliveryComments;

    public DeliveryDetails(){

    }

    public DeliveryDetails(String apartmentNumber, String street, String city, String state, String country, String zipCode, String deliveryComments){

        this.apartmentNumber = apartmentNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.deliveryComments = deliveryComments;
    }

    public DeliveryDetails(String apartmentNumber, String street, String city, String state, String country, String zipCode, String deliveryComments, FoodOrders foodOrders){

        this.apartmentNumber = apartmentNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.deliveryComments = deliveryComments;
        this.orderDeliveryDetails = foodOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodOrders getOrderDeliveryDetails() {
        return orderDeliveryDetails;
    }

    public void setOrderDeliveryDetails(FoodOrders orderDeliveryDetails) {
        this.orderDeliveryDetails = orderDeliveryDetails;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeliveryComments() {
        return deliveryComments;
    }

    public void setDeliveryComments(String deliveryComments) {
        this.deliveryComments = deliveryComments;
    }
}
