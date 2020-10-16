package com.example.coachtimer.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Player {


PlayerName  name;
PlayerPicture picture;



    public Player(PlayerName name, PlayerPicture picture) {
        this.name = name;
        this.picture = picture;
    }

    public PlayerName getName() {
        return name;
    }

    public PlayerPicture getPicture() {
        return picture;
    }
}
