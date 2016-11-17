package com.charlesdrews.heterogeneousrecyclerview.model;

/**
 * Parent class for our Team and Player objects. Since they both will inherit from this class,
 * we can create a list of type List<BaseFootballObject> and put both teams and players in it.
 *
 * Created by charlie on 11/14/16.
 */

public abstract class BaseFootballObject {

    public abstract String getName();
}
