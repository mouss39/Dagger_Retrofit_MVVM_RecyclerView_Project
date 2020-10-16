package com.example.coachtimer.data.rest;

import com.example.coachtimer.data.model.Player;
import com.example.coachtimer.data.model.PlayerResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class PlayerRepository {


    private static final String TAG = "Auth";
    private final PlayerService playerAPiservice;

    @Inject
    public PlayerRepository(PlayerService playerAPiservice) {
        this.playerAPiservice = playerAPiservice;

    }

public Call<PlayerResponse> getPlayers(String seed, String inc, String gender, Integer results, String noinfo){

        return playerAPiservice.getPlayers(seed, inc, gender, results, noinfo);
}

}
