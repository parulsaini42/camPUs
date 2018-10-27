package com.example.parul.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImportEvents extends AppCompatActivity {

    RecyclerView recyclerView;
    ImportEventsEventAdapter event_adapter;
    List<ImportEventsEventClass> eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_events);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventsList = new ArrayList<>();

        eventsList.add(new ImportEventsEventClass("Udyami", "The Entrepreneurial Crossroads is Panjab University's national Entrepreneurship Summit organised annually by EDC UIET! ", "10-11 March", "Academic Block 1, South Campus(UIET) Panjab University, Sector 25, Chandigarh,\n" +
                "160036", "9AM-5PM", R.drawable.udyami));

        eventsList.add(new ImportEventsEventClass("Goonj", "", "23-25 Feb","UIET, Sector 25, Chandigarh,\n" +
                "160036", "9AM-5PM", R.drawable.goonj));

        eventsList.add(new ImportEventsEventClass("Agaaz", "", "23-25 Feb","UIET, Sector 25, Chandigarh,\n" +
                "160036", "9AM-5PM", R.drawable.goonj));

        eventsList.add(new ImportEventsEventClass("Jhankaar", "", "27-29 March","Panjab University, Sector 25,\n Chandigarh, 160036", "10AM-6PM", R.drawable.jhankaar));

        event_adapter = new ImportEventsEventAdapter(eventsList, this);
        recyclerView.setAdapter(event_adapter);
    }
}
