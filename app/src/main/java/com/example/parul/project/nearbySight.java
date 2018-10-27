package com.example.parul.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class nearbySight extends AppCompatActivity {

    List<nearbySightSightClass> sightList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_sight);

        recyclerView = (RecyclerView) findViewById(R.id.rvNearbySight);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sightList = new ArrayList<>();

        sightList.add(new nearbySightSightClass("Rose Garden", "085910 08038", "16B, Sector 16, Jan Marg, Chandigarh, 160016", "6AM-10PM", R.drawable.rose_garden));

        sightList.add(new nearbySightSightClass("Sukhna Lake", "-", "Sector 1, Chandigarh, 160001", "5AM-9PM",
                R.drawable.sukhna_lake));

        sightList.add(new nearbySightSightClass("Rock Garden", "-", "Sector 1, Chandigarh, 160001", "9AM-7:30PM (1st April-30th September) and 9AM-6PM (1st October-31st March)",
                R.drawable.rock_garden));

        //creating recyclerview adapter
        nearbySightSightAdapter sightAdapter = new nearbySightSightAdapter(sightList, this);

        //setting adapter to recyclerview
        recyclerView.setAdapter(sightAdapter);
    }
}
