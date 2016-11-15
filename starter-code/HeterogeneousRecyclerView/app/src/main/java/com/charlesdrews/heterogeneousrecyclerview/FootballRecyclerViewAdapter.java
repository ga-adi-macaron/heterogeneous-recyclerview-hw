package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.heterogeneousrecyclerview.model.BaseFootballObject;
import com.charlesdrews.heterogeneousrecyclerview.model.Player;
import com.charlesdrews.heterogeneousrecyclerview.model.Team;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by charlie on 11/14/16.
 */

public class FootballRecyclerViewAdapter extends RecyclerView.Adapter {

    private final int PLAYER_VIEW = 0;
    private final int TEAM_VIEW = 1;
    private List <BaseFootballObject> myList = new ArrayList<>();

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator


    public FootballRecyclerViewAdapter(List<BaseFootballObject> myList) {
        this.myList = myList;
    }

    @Override
    public int getItemViewType(int position) {

        if (myList.get(position) instanceof Player) {
            return PLAYER_VIEW;
        } else if (myList.get(position) instanceof Team) {
            return TEAM_VIEW;
        }

        return -1;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == PLAYER_VIEW) {
            View playerView = layoutInflater.inflate(R.layout.player_list_entry, parent, false);
            return new PlayerViewHolder(playerView);
        } else if (viewType == TEAM_VIEW){
            View teamView = layoutInflater.inflate(R.layout.team_list_entry, parent, false);
            return new PlayerViewHolder(teamView);
        }

        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case PLAYER_VIEW:
                PlayerViewHolder playerViewHolder = (PlayerViewHolder) holder;
                configurePlayerVH(playerViewHolder, position);
                break;
            case TEAM_VIEW:
                TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
                configureTeamVH(teamViewHolder, position);
                break;
        }
    }


    @Override
    public int getItemCount() {
       return myList.size();
    }

    private void configurePlayerVH(PlayerViewHolder holder, int position){
        Player player = (Player) myList.get(position);
        if (player != null){
            holder.bindDataToViews(player);
        }
    }

    private void configureTeamVH(TeamViewHolder holder, int position){
        Team team = (Team) myList.get(position);
        if (team != null){
            holder.bindDataToViews(team);
        }
    }

}
