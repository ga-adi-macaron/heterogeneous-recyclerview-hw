package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.heterogeneousrecyclerview.model.BaseFootballObject;
import com.charlesdrews.heterogeneousrecyclerview.model.Player;
import com.charlesdrews.heterogeneousrecyclerview.model.Team;

import java.util.List;

/**
 * Created by charlie on 11/14/16.
 */

public class FootballRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseFootballObject> list;

    private final int PLAYER = 0, TEAM = 1;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> list) {
        this.list = list;
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof Player){
            return PLAYER;
        }
        else if (list.get(position) instanceof Team){
            return TEAM;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case PLAYER:
                View playerView = inflater.inflate(R.layout.player_list_entry, parent, false);
                viewHolder = new PlayerViewHolder(playerView);
                break;
            case TEAM:
                View teamView = inflater.inflate(R.layout.team_list_entry, parent, false);
                viewHolder = new TeamViewHolder(teamView);
                break;
            default:
                View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new TeamViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case PLAYER:
                PlayerViewHolder pvh = (PlayerViewHolder) holder;
                configurePlayerVH(pvh,position);
                break;
            case TEAM:
                TeamViewHolder tvh = (TeamViewHolder) holder;
                configureTeamVH(tvh, position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void configurePlayerVH(PlayerViewHolder play, int position){
        Player player = (Player) list.get(position);
        if (player != null){
            play.bindDataToViews(player);
        }
    }

    private void configureTeamVH(TeamViewHolder team, int position){
        Team newTeam = (Team) list.get(position);
        if (newTeam != null){
            team.bindDataToViews(newTeam);
        }
    }

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
