package com.kellydouglass.venmo2;


import java.util.ArrayList;

public class Me {


    private String firstName;
    private String lastName;
    private double amount;
    private int daysAgo;
    private ArrayList<String> imageList;
    private String userImage;

    public Me(String firstName, String lastName, double amount, int daysAgo, String userImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.daysAgo = daysAgo;
        this.userImage = userImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDaysAgo() {
        return daysAgo;
    }

    public void setDaysAgo(int daysAgo) {
        this.daysAgo = daysAgo;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
