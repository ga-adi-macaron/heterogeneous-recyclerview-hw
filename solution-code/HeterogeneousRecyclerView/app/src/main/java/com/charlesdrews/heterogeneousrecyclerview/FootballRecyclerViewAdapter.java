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

public class FootballRecyclerViewAdapter extends RecyclerView.Adapter {

    // Constants to represent the two types of list entries we'll have
    private static final int TEAM_TYPE = 0;
    private static final int PLAYER_TYPE = 1;

    private List<BaseFootballObject> mData;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> data) {
        mData = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof Team) {
            return TEAM_TYPE;
        } else if (mData.get(position) instanceof Player) {
            return PLAYER_TYPE;
        } else {
            throw new RuntimeException("Invalid data! Must be either a Team or Player object.");
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TEAM_TYPE:
                View teamView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.team_list_entry, parent, false);
                return new TeamViewHolder(teamView);

            case PLAYER_TYPE:
                View playerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.player_list_entry, parent, false);
                return new PlayerViewHolder(playerView);

            default:
                throw new RuntimeException("Invalid view type! Must be either a Team or Player view.");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEAM_TYPE:
                ((TeamViewHolder) holder).bindDataToViews((Team) mData.get(position));
                break;

            case PLAYER_TYPE:
                ((PlayerViewHolder) holder).bindDataToViews((Player) mData.get(position));
                break;

            default:
                throw new RuntimeException("Invalid view type! Must be either a Team or Player view.");
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
