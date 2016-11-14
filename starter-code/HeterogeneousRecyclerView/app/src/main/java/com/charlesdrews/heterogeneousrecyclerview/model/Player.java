package com.charlesdrews.heterogeneousrecyclerview.model;

import android.support.annotation.NonNull;

/**
 * Models an NFL player
 *
 * Created by charlie on 11/14/16.
 */

public class Player extends BaseFootballObject {

    private String mFirstName, mLastName, mTeam, mPosition;

    public Player(@NonNull String firstName, @NonNull String lastName, @NonNull String team,
                  @NonNull String position) {
        mFirstName = firstName;
        mLastName = lastName;
        mTeam = team;
        mPosition = position;
    }

    @Override
    public String getName() {
        return mFirstName + " " + mLastName;
    }

    public String getTeam() {
        return mTeam;
    }

    public String getPosition() {
        return mPosition;
    }
}
