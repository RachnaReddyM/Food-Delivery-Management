package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class OrderReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ratings;
    private String review;

    @ManyToOne
    private Customer customerOrderReview;

    @OneToOne
    private FoodOrders foodOrderReview;

    public OrderReviews(){

    }
    public OrderReviews(int ratings, String review){
        this.ratings = ratings;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Customer getCustomerOrderReview() {
        return customerOrderReview;
    }

    public void setCustomerOrderReview(Customer customerOrderReview) {
        this.customerOrderReview = customerOrderReview;
    }

    public FoodOrders getFoodOrderReview() {
        return foodOrderReview;
    }

    public void setFoodOrderReview(FoodOrders foodOrderReview) {
        this.foodOrderReview = foodOrderReview;
    }
}
