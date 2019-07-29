package edu.northeastern.cs5200.forms;

import edu.northeastern.cs5200.models.Restaurant;

public class ProfileForm {
	
	private String restaurant = null;
	
	private String name = null;
	
	private String password = null;
	
	private String phoneNumber = null;
	
	private String about = null;

	private String deliveryMode = null;
	
	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	
	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurantName) {
		this.restaurant = restaurantName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
