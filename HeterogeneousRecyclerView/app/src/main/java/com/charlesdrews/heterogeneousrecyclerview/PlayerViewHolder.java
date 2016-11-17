package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.charlesdrews.heterogeneousrecyclerview.model.Player;

/**
 * Created by charlie on 11/14/16.
 */

public class PlayerViewHolder extends RecyclerView.ViewHolder {

    private TextView mName, mPosition, mTeam;

    public PlayerViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.player_name);
        mPosition = (TextView) itemView.findViewById(R.id.player_position);
        mTeam = (TextView) itemView.findViewById(R.id.player_team);
    }

    public void bindDataToViews(Player player) {
        mName.setText(player.getName());
        mPosition.setText(player.getPosition());
        mTeam.setText(player.getTeam());
    }
}
