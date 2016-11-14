package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charlesdrews.heterogeneousrecyclerview.model.BaseFootballObject;
import com.charlesdrews.heterogeneousrecyclerview.model.Player;
import com.charlesdrews.heterogeneousrecyclerview.model.Team;

import java.util.List;

import javax.xml.transform.Templates;

/**
 * Created by charlie on 11/14/16.
 */

public class FootballRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<BaseFootballObject> mBaseFootballObjects;

    public FootballRecyclerViewAdapter(List<BaseFootballObject> baseFootballObjects) {
        mBaseFootballObjects = baseFootballObjects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==1) {
            return new PlayerViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.player_list_entry, parent, false));
        }

        return new TeamViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.team_list_entry,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PlayerViewHolder){
            ((PlayerViewHolder) holder).bindDataToViews((Player)mBaseFootballObjects.get(position));
        }else{
            ((TeamViewHolder) holder).bindDataToViews((Team) mBaseFootballObjects.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mBaseFootballObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mBaseFootballObjects.get(position) instanceof Player) {
            return 1;
        }
        return 2;
    }
    // TODO: Implement this class to use multiple xml layouts in the same RecyclerView

    // If the data object is a Team object, use the res/layout/team_list_entry.xml layout.
    // If the data object is a Player object, use the res/layout/player_list_entry.xml layout.

    // Hint 1: you'll need to override the getItemViewType() method from RecyclerView.Adapter.
    // Hint 2: you might want to use the `instanceof` operator
}
