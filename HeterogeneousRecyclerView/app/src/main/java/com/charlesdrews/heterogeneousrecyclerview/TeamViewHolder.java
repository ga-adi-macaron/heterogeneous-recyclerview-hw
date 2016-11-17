package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.charlesdrews.heterogeneousrecyclerview.model.Team;

/**
 * Created by charlie on 11/14/16.
 */

public class TeamViewHolder extends RecyclerView.ViewHolder {

    private TextView mName, mLocation;

    public TeamViewHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.team_name);
        mLocation = (TextView) itemView.findViewById(R.id.team_location);
    }

    public void bindDataToViews(Team team) {
        mName.setText(team.getName());
        mLocation.setText(team.getLocation());
    }
}
