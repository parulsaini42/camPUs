package com.example.parul.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Nearby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);


//Back button on toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backw));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();


            }
        });

    }
    public void sight(View view){
        Intent intentNearbySight =  new Intent(this,nearbySight.class);
        startActivity(intentNearbySight);
    }
    public void food(View view){
        Intent intentNearbyFood =  new Intent(this,nearbyFood.class);
        startActivity(intentNearbyFood);
    }
}
