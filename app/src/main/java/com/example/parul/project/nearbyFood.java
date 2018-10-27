package com.example.parul.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class nearbyFood extends AppCompatActivity {

    RecyclerView recyclerView;
    List<nearbyFoodFoodClass> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_food);

        recyclerView = findViewById(R.id.rvNearbyFood);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();

        foodList.add(new nearbyFoodFoodClass("The Crumbs", "1153, 15B, Sector 15, Chandigarh, 160015", "099889 90010", "11AM - 9AM", "zomato.com", R.drawable.crumbs));

        foodList.add(new nearbyFoodFoodClass("Castle Grill", "194, Sector 37 Market Rd, Sector 37 C, Sector 37, Chandigarh, 160036", "0172 507 3636", "11AM - 11PM", "swiggy.com, zomato.com", R.drawable.castle_grill));

        foodList.add(new nearbyFoodFoodClass("Gopal's","SCO 64-65, Vidya Path, 15D, Sector 15-D, Chandigarh, 160015", "0172 272 4222", "10AM - 9:30PM", "zomato.com", R.drawable.gopals));


        foodList.add(new nearbyFoodFoodClass("Hash Guys", ".153, 36D Market, Chandigarh, 160036", "099889 90010", "11AM - 9AM", "zomato.com", R.drawable.crumbs));

        nearbyFoodFoodAdapter foodAdapter = new nearbyFoodFoodAdapter(foodList, this);
        recyclerView.setAdapter(foodAdapter);

    }
}
