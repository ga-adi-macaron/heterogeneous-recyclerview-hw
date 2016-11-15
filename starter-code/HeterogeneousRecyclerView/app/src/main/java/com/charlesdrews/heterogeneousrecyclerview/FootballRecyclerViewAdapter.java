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

    public FootballRecyclerViewAdapter(List<BaseFootballObject> objectList) {
        mObjectList = objectList;
    }

    @Override
    public int getItemViewType(int position) {
        if(mObjectList.get(position) instanceof Team){
            return 2;
        } else if(mObjectList.get(position) instanceof Player){
            return 1;
        } return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 2:
                View team = inflater.inflate(R.layout.team_list_entry,parent,false);
                viewHolder = new TeamViewHolder(team);
                break;
            case 1:
                View player = inflater.inflate(R.layout.player_list_entry,parent,false);
                viewHolder = new PlayerViewHolder(player);
                break;
            default:break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseFootballObject baseFootballObject = mObjectList.get(holder.getAdapterPosition());
        switch (holder.getItemViewType()){
            case 2:
                TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
                teamViewHolder.bindDataToViews((Team)mObjectList.get(position));
                break;
            case 1:
                PlayerViewHolder playerViewHolder = (PlayerViewHolder) holder;
                playerViewHolder.bindDataToViews((Player)mObjectList.get(position));
                break;
            default:break;
        }
    }


    @Override
    public int getItemCount() {
        return mObjectList.size();
    }

    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
