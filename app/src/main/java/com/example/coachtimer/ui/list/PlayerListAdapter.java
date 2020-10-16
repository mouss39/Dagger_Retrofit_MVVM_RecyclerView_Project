package com.example.coachtimer.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coachtimer.R;
import com.example.coachtimer.data.model.Player;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerListHolder> {
    private List<Player> players = new ArrayList<>();

    @NonNull
    @Override
    public PlayerListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlayerListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListHolder holder, int position) {
        Player currentPlayer = players.get(position);

        holder.textViewPlayerName.setText(currentPlayer.getName().getFirst() + " " + currentPlayer.getName().getLast());
        Picasso.get().load(currentPlayer.getPicture().getLarge()).into(holder.imageViewPlayer);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public void updatePlayers(List<Player> players) {
        this.players = players;
        notifyDataSetChanged();
    }

    class PlayerListHolder extends RecyclerView.ViewHolder {
        private TextView textViewPlayerName;
        private ImageView imageViewPlayer;

        public PlayerListHolder(View itemView) {
            super(itemView);
            textViewPlayerName = itemView.findViewById(R.id.text_view_playerName);
            imageViewPlayer = itemView.findViewById(R.id.image_view_playerImage);
        }
    }


}
