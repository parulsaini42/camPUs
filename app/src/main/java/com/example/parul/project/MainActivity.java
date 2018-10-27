package com.example.parul.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.gb,R.drawable.sc,R.drawable.pl};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
  //function for image slider
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 4000);
    }


    //Methods for image button
    public void Maps(View v) {

        Intent intentToMaps =  new Intent(this,MapsActivity.class);
        startActivity(intentToMaps);

    }
    public void Events(View v) {

        Intent intentToEvents =  new Intent(this,highlights.class);
        startActivity(intentToEvents);

    }
    public void News(View v) {

        Toast.makeText(this, "News and Announcements coming soon", Toast.LENGTH_LONG).show();

    }
    public void Nearby(View v) {

        Intent intentTonearby =  new Intent(this,Nearby.class);
        startActivity(intentTonearby);

    }
    public void Notification(View v) {

        Toast.makeText(this, "Notifications coming soon", Toast.LENGTH_LONG).show();

    }
    public void Calendar(View v) {

        Toast.makeText(this, "Calendar coming soon", Toast.LENGTH_LONG).show();

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //switch (item.getItemId()) {
            //case R.id.notify:
               // Intent intent = new Intent(this, Notification.class);
               // startActivity(intent);
               // break;}


        return super.onOptionsItemSelected(item);
    }
//for viewpager

    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        if (id == R.id.nav_home) {
            // Handle the home action
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }
            //  else if (id == R.id.nav_admission) {
                // Handle the admission action
               // fragment = new ImportAdmission();
               //ft.replace(R.id.screen_area, fragment);

               // ft.commit();}
        else if (id == R.id.nav_alumni) {// Handle the alumni action
                Intent intent_import_alumni =new Intent(this,ImportAlumni.class);
                startActivity(intent_import_alumni);

            }   else if (id == R.id.nav_events) {
                // Handle the heads action
            Intent intent_import_events =new Intent(this,ImportEvents.class);
            startActivity(intent_import_events);
            }  //else if (id == R.id.nav_forms) {
                // Handle the form action
                //fragment = new ImportFragment();
                //ft.replace(R.id.screen_area, fragment);

               //ft.commit();

            //} else if (id == R.id.nav_hostels) {
                // Handle the hostel action
                //fragment = new ImportFragment();
                //ft.replace(R.id.screen_area, fragment);

                //ft.commit();}

            else if (id == R.id.nav_lib) {
                // Handle the library action
            Intent intent_import_lib =new Intent(this,ImportLibrary.class);
            startActivity(intent_import_lib);

            } else if (id == R.id.nav_sports) {
                // Handle the library action
            Intent intent_import_sports =new Intent(this,ImportSports.class);
            startActivity(intent_import_sports);

            } else if (id == R.id.nav_transport) {
                // Handle the transport action
            Intent intent_import_transport =new Intent(this,ImportTransport.class);
            startActivity(intent_import_transport);

            }
        else if (id == R.id.nav_abtoutus) {
            Intent intent_us =new Intent(this,Aboutus.class);
            startActivity(intent_us);

        }
        //else if (id == R.id.nav_set) {
            // Handle the transport action
            //fragment = new ImportFragment();
           // ft.replace(R.id.screen_area, fragment);

          //  ft.commit();
        //}
        else if (id == R.id.nav_exit) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

