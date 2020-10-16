package com.example.coachtimer;

import android.os.Bundle;

import com.example.coachtimer.data.model.Player;
import com.example.coachtimer.data.model.PlayerResponse;
import com.example.coachtimer.data.rest.PlayerRepository;
import com.example.coachtimer.ui.detail.PlayerViewModel;
import com.example.coachtimer.ui.list.PlayerListAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    PlayerViewModel playerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        ((BaseApplication) getApplication()).getAppComponent().inject(playerViewModel);



        //recyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final PlayerListAdapter adapter = new PlayerListAdapter();
        recyclerView.setAdapter(adapter);


        //attach the adapter to the list
        playerViewModel.getListOfPlayers().observe(this, new Observer<PlayerResponse>() {
            @Override
            public void onChanged(PlayerResponse playerResponse) {
                adapter.updatePlayers(playerResponse.getResults());
            }
        });

        //fetch the data
        playerViewModel.getPlayers("empatica", "name,picture", "female", 20, "");

    }
}
