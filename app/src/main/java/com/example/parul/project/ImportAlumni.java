package com.example.parul.project;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class ImportAlumni extends TabActivity {
    TabHost alumniHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_alumni);

        alumniHost = findViewById(android.R.id.tabhost);
        alumniHost.setup();

        TabHost.TabSpec Tab1 = alumniHost.newTabSpec("Home");
        TabHost.TabSpec Tab2 = alumniHost.newTabSpec("Form");
        TabHost.TabSpec Tab3 = alumniHost.newTabSpec("Contact");

        Tab1.setIndicator("Home");
        Intent intent_home = new Intent(this,alumniHome.class);
        Tab1.setContent(intent_home);

        Tab2.setIndicator("Contact");
        Intent intent_contact = new Intent(this,alumniContact.class);
        Tab2.setContent(intent_contact);

        Tab3.setIndicator("Form");
        Intent intent_form = new Intent(this,alumniForm.class);
        Tab3.setContent(intent_form);

        alumniHost.addTab(Tab1);
        alumniHost.addTab(Tab2);
        alumniHost.addTab(Tab3);
    }

}

