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
    List<BaseFootballObject> mObjectList;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> list) {
        mObjectList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == R.layout.player_list_entry) {
            View player = inflater.inflate(R.layout.player_list_entry, parent, false);
            PlayerViewHolder pvh = new PlayerViewHolder(player);
            return pvh;
        } else {
            View team = inflater.inflate(R.layout.team_list_entry, parent, false);
            TeamViewHolder tvh = new TeamViewHolder(team);
            return tvh;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type == R.layout.player_list_entry) {
            ((PlayerViewHolder)holder).bindDataToViews((Player)mObjectList.get(position));
        } else if(type == R.layout.team_list_entry) {
            ((TeamViewHolder)holder).bindDataToViews((Team)mObjectList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mObjectList.get(position) instanceof Player) {
            return R.layout.player_list_entry;
        } else if(mObjectList.get(position) instanceof Team) {
            return R.layout.team_list_entry;
        }
        return -1;
    }

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
