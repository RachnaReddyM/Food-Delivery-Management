package edu.northeastern.cs5200.forms;

public class RegisterForm {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private String type;
	private String phone;

	private int deliveryManagerId;

	private String about;

	private String workStartTime;

	private String workEndTime;

	private String weeklyOffDay;

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public String getWeeklyOffDay() {
		return weeklyOffDay;
	}

	public void setWeeklyOffDay(String weeklyOffDay) {
		this.weeklyOffDay = weeklyOffDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailAddress) {
		this.email = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDeliveryManagerId() {
		return deliveryManagerId;
	}

	public void setDeliveryManagerId(int deliveryManagerId) {
		this.deliveryManagerId = deliveryManagerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
