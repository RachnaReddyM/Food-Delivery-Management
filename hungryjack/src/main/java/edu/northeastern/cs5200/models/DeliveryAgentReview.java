package edu.northeastern.cs5200.models;

import javax.persistence.*;

@Entity
public class DeliveryAgentReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int ratings;
    private String review;

    @ManyToOne
    private Customer reviewByCustomer;

    @ManyToOne
    private DeliveryAgent reviewToDeliveryAgent;
    
    @OneToOne
    private FoodOrders relatedOrder;


	public DeliveryAgentReview(){

    }

    public DeliveryAgentReview(int ratings, String review){
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

    public Customer getReviewByCustomer() {
        return reviewByCustomer;
    }

    public void setReviewByCustomer(Customer reviewByCustomer) {
        this.reviewByCustomer = reviewByCustomer;
    }

    public DeliveryAgent getReviewToDeliveryAgent() {
        return reviewToDeliveryAgent;
    }

    public void setReviewToDeliveryAgent(DeliveryAgent reviewToDeliveryAgent) {
        this.reviewToDeliveryAgent = reviewToDeliveryAgent;
    }
    
    public FoodOrders getRelatedOrder() {
		return relatedOrder;
	}

	public void setRelatedOrder(FoodOrders relatedOrder) {
		this.relatedOrder = relatedOrder;
	}
}
