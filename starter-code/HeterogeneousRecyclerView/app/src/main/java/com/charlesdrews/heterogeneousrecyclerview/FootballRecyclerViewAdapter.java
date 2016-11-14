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

/**
 * Created by charlie on 11/14/16.
 */

public class FootballRecyclerViewAdapter extends RecyclerView.Adapter {

    List<BaseFootballObject> mBaseFootballObjects;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> listOfFutbol) {
        mBaseFootballObjects = listOfFutbol;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_entry, null);
            return new TeamViewHolder(view);
        } else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list_entry, null);
            return new PlayerViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseFootballObject baseFootballObject = mBaseFootballObjects.get(holder.getAdapterPosition());
        if (Team.class.equals(baseFootballObject.getClass())){
            ((TeamViewHolder) holder).bindDataToViews((Team)mBaseFootballObjects.get(holder.getAdapterPosition()));
        }else{
            ((PlayerViewHolder) holder).bindDataToViews((Player)mBaseFootballObjects.get(holder.getAdapterPosition()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (Team.class.equals(mBaseFootballObjects.get(position).getClass())){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mBaseFootballObjects.size();
    }

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
