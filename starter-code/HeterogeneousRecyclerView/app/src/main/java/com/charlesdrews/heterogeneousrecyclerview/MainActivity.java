package com.charlesdrews.heterogeneousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.charlesdrews.heterogeneousrecyclerview.model.BaseFootballObject;
import com.charlesdrews.heterogeneousrecyclerview.model.Player;
import com.charlesdrews.heterogeneousrecyclerview.model.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.football_recycler_view);
        List<BaseFootballObject> footballObjects = generateSomeDataToDisplay();

        recyclerView.setAdapter(new FootballRecyclerViewAdapter(footballObjects));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        // TODO: Set up the RecyclerView

        // You can use the helper method below to generate data to pass to your Adapter, or
        // you can come up with your own data.
    }

    private List<BaseFootballObject> generateSomeDataToDisplay() {
        List<BaseFootballObject> list = new ArrayList<>();

        // Create and add some players
        // Copy top 2 players in fantasy stats at each position from http://fantasy.nfl.com/research/rankings
        list.add(new Player("Cam", "Newton", "Jaguars", "QB"));
        list.add(new Player("Aaron", "Rodgers", "Packers", "QB"));
        list.add(new Player("David", "Johnson", "Cardinals", "RB"));
        list.add(new Player("Ezekiel", "Elliot", "Cowboys", "RB"));
        list.add(new Player("Antonio", "Brown", "Steelers", "WR"));
        list.add(new Player("Mike", "Evans", "Buccaneers", "WR"));

        // Create and add some teams
        // Copy the top several teams in defense fantasy stats from http://fantasy.nfl.com/research/rankings
        list.add(new Team("Cardinals", "Arizona"));
        list.add(new Team("Texans", "Houston"));
        list.add(new Team("Broncos", "Denver"));
        list.add(new Team("Chiefs", "Kansas City"));
        list.add(new Team("Rams", "Los Angeles"));

        // Shuffle the list so the entries are in a random order
        Collections.shuffle(list);

        return list;
    }
}
