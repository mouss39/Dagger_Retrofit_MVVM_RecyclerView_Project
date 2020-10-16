package com.example.coachtimer.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coachtimer.data.model.PlayerResponse;
import com.example.coachtimer.data.rest.PlayerRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerViewModel extends ViewModel {

    private final PlayerRepository repository;

    private MutableLiveData<PlayerResponse> listOfPlayers = new MutableLiveData<>();

    @Inject
    public PlayerViewModel(PlayerRepository playerRepository) {
        repository = playerRepository;
    }

    public LiveData<PlayerResponse> getListOfPlayers(){
        return listOfPlayers;
    }

    public void getPlayers(String seed, String inc, String gender, Integer results, String noinfo) {
        repository.getPlayers(seed, inc, gender, results, noinfo).enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                listOfPlayers.postValue(response.body());
            }
            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {
            }
        });
    }
}