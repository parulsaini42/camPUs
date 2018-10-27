package com.example.parul.project;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;

public class ImportLibrary extends TabActivity {
    TabHost host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_library);

        host = findViewById(android.R.id.tabhost);
        host.setup();

        TabHost.TabSpec tab_home = host.newTabSpec("Tab One");
        TabHost.TabSpec tab_contact = host.newTabSpec("Tab Two");
        TabHost.TabSpec tab_form = host.newTabSpec("Tab Three");

        tab_home.setIndicator("Home");
        Intent intent_home = new Intent(this,libraryHome.class);
        tab_home.setContent(intent_home);

        tab_contact.setIndicator("Contact");
        Intent intent_contact = new Intent(this,libraryContact.class);
        tab_contact.setContent(intent_contact);

        tab_form.setIndicator("Form");
        Intent intent_form = new Intent(this,libraryForm.class);
        tab_form.setContent(intent_form);

        host.addTab(tab_home);
        host.addTab(tab_contact);
        host.addTab(tab_form);
    }

}
