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
    List<BaseFootballObject> mFootballObjectList;

    private final int TEAM = 0, PLAYER = 1;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> footballObjectList) {
        mFootballObjectList = footballObjectList;
    }

    @Override
    public int getItemViewType(int position) {
        if (mFootballObjectList.get(position) instanceof Team) {
            return TEAM;
        } else if (mFootballObjectList.get(position) instanceof Player) {
            return PLAYER;
        }
        return  -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case PLAYER:
                View player = inflater.inflate(R.layout.player_list_entry, parent, false);
                viewHolder = new PlayerViewHolder(player);
                break;
            case TEAM:
                View team = inflater.inflate(R.layout.team_list_entry, parent, false);
                viewHolder = new TeamViewHolder(team);
                break;
            default:
                //
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case PLAYER:
                PlayerViewHolder playerViewHolder = (PlayerViewHolder) holder;
                configurePlayerViewHolder(playerViewHolder, position);
                break;
            case TEAM:
                TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
                configureTeamViewHolder(teamViewHolder, position);
                break;
            default:
                //
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mFootballObjectList.size();
    }

    public void configurePlayerViewHolder(PlayerViewHolder playerViewHolder, int position) {
        Player player = (Player) mFootballObjectList.get(position);
        playerViewHolder.bindDataToViews(player);
    }

    public void configureTeamViewHolder(TeamViewHolder teamViewHolder, int position) {
        Team team = (Team) mFootballObjectList.get(position);
        teamViewHolder.bindDataToViews(team);
    }

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
