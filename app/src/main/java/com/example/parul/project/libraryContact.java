package com.example.parul.project;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class libraryContact extends Activity {
    //make AppCompatActivity to include toolbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_contact);
    }
}
