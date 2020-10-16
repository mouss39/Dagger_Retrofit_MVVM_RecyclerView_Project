package com.example.coachtimer.data.rest;

import com.example.coachtimer.data.model.Player;
import com.example.coachtimer.data.model.PlayerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlayerService {

//    @GET("results")
    //    Call<List<Player>> getPlayers(@Query("seed") String s, @Query("name") String name);
//

    @GET("api")
    Call<PlayerResponse> getPlayers(
            @Query("seed") String seed,
            @Query("inc") String inc,
            @Query("gender") String gender,
            @Query("results") Integer results,
            @Query("noinfo") String noinfo);

}
