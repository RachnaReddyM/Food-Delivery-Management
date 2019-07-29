package edu.northeastern.cs5200.forms;

public class OnlineUser {

	private String email;
	
	private String userType;
	
	public OnlineUser() {}
	
	public OnlineUser(String email, String userType) {
		this.email = email;
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
