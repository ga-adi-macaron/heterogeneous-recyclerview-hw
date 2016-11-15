package com.charlesdrews.heterogeneousrecyclerview.model;

import android.support.annotation.NonNull;

/**
 * Models an NFL team
 *
 * Created by charlie on 11/14/16.
 */

public class Team extends BaseFootballObject {

    private String mName, mLocation;

    public Team(@NonNull String name, @NonNull String location) {
        mName = name;
        mLocation = location;
    }

    @Override
    public String getName() {
        return mName;
    }

    public String getLocation() {
        return mLocation;
    }
}
