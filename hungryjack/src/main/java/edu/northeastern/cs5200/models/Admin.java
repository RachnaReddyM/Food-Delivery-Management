package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    private String adminKey;

    public Admin(){

    }
    public Admin(String key, String username, String password, String firstName, String lastName, String email){
        super(username, password, firstName, lastName, email);
        this.adminKey = key;
    }

    public Admin(String key, String username, String password, String firstName, String lastName, String email, String phone){
        super(username, password, firstName, lastName, email, phone);
        this.adminKey = key;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }
}
