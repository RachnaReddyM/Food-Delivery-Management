package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RestaurantManager extends User {

    private int salary;
    private String workStartTime;
    private String workEndTime;
    private String weeklyOffDay;

    @ManyToOne
    private Restaurant restaurantManager;

    public RestaurantManager(){

    }

    public RestaurantManager(int salary, String workStartTime, String workEndTime, String weeklyOffDay, String username, String password, String firstName, String lastName, String email){
        super(username, password, firstName, lastName, email);
        this.salary = salary;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.weeklyOffDay = weeklyOffDay;
    }

    public RestaurantManager(int salary, String workStartTime, String workEndTime, String weeklyOffDay, String username, String password, String firstName, String lastName, String email, String phone){
        super(username, password, firstName, lastName, email, phone);
        this.salary = salary;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.weeklyOffDay = weeklyOffDay;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public Restaurant getRestaurantManager() {
        return restaurantManager;
    }

    public void setRestaurantManager(Restaurant restaurantManager) {
        this.restaurantManager = restaurantManager;
    }
}
