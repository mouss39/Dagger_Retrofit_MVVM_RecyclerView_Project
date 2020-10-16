package com.example.coachtimer.data.model;

public class PlayerPicture {

     String large;
     String medium;
     String thumbnail;

    public PlayerPicture(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
