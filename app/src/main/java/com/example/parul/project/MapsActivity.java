package com.example.parul.project;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener,LocationListener {
    AutoCompleteTextView acv;
    String S;
    private GoogleMap mMap;
    private Marker m1;
    private Marker m2;
    private Marker m3;
    private Marker a1;
    private Marker s1;
    private static final String TAG = MapsActivity.class.getSimpleName();
    private BottomSheetBehavior bottomSheetBehavior;
    View bottomsheet;

    //location
    LocationManager locationManager;
    LocationListener locationListener;
    String provider;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    Double dlat,dlang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Back button on toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();


            }


        });
        //bottomsheet
        bottomsheet = findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        //location

        checkLocationPermission();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            // Build the alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location Services Not Active");
            builder.setMessage("Please enable Location Services and GPS");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Show location settings when the user acknowledges the alert dialog
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            Dialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.show();
        }

        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {

            Log.i("Location Info", "Location achieved!");

        } else {

            Log.i("Location Info", "No location :(");

        }





        //autoCompleteTextView
        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] dogArr = getResources().getStringArray(R.array.items);
        List<String> dogList = Arrays.asList(dogArr);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, dogList);

        AutoCompleteTextView acv = (AutoCompleteTextView) findViewById(R.id.autoCompleteView);
        acv.setAdapter(adapter);
        acv.setThreshold(1);

        acv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                S=parent.getItemAtPosition(position).toString();
                if(S.equals("GATE 1"))
                {
                    LayoutInflater inflater = getLayoutInflater();
                    FrameLayout container = findViewById(R.id.screen_area);
                    inflater.inflate(R.layout.fragment_layout_bottomsheet, container);
                    //retrieving title of marker
                    TextView title = (TextView)findViewById(R.id.sheet_head);
                    title.setText("GATE 1");
                    //collapsing view(making it visible)
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                else if (S.equals("GATE 2"))
                {
                    LayoutInflater inflater = getLayoutInflater();
                    FrameLayout container = findViewById(R.id.screen_area);
                    inflater.inflate(R.layout.gate2, container);
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

        });


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        //enabling location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        //customizing map

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }




        // pu to camera
        LatLng pu = new LatLng(30.757965, 76.768412);
        //gate markers
        LatLng gate1 = new LatLng(30.76106437814946, 76.77405971371081);
        LatLng gate2 = new LatLng(30.754953658351678, 76.76877892511561);
        LatLng gate3 = new LatLng(30.755325243029397, 76.76209098043546);
        LatLng stuccy = new LatLng(30.7621797, 76.76980389999994);
        LatLng atm_stuccy = new LatLng(30.7620726, 76.7693812);
        m1 = mMap.addMarker(new MarkerOptions().position(gate1).title("GATE 1").icon(BitmapDescriptorFactory.fromResource(R.drawable.gate)));
        m1.setTag(1);
        m2 = mMap.addMarker(new MarkerOptions().position(gate2).title("GATE 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.gate)));
        m2.setTag(2);
        m3 = mMap.addMarker(new MarkerOptions().position(gate3).title("GATE 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.gate)));
        m3.setTag(3);
        s1 = mMap.addMarker(new MarkerOptions().position(stuccy).title("STUCCY").icon(BitmapDescriptorFactory.fromResource(R.drawable.food1)));
        s1.setTag(4);
        a1 = mMap.addMarker(new MarkerOptions().position(atm_stuccy).title("ATM,STUDENT CENTER").icon(BitmapDescriptorFactory.fromResource(R.drawable.atm1)));
        a1.setTag(5);
        mMap.setOnMarkerClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pu));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(14);
        mMap.animateCamera(zoom);
        // Set a listener for marker click.

    }




    @Override
    public boolean onMarkerClick(Marker marker) {
        //loc
        dlat = marker.getPosition().latitude;
        dlang = marker.getPosition().longitude;

        //bottomsheet
        Integer i=(Integer) marker.getTag();
        if( i==1)
        {   //inflating fragment in frame layout of bottom_sheet
            LayoutInflater inflater = getLayoutInflater();
            FrameLayout container = findViewById(R.id.screen_area);
            inflater.inflate(R.layout.fragment_layout_bottomsheet, container);
            //retrieving title of marker
            TextView title = (TextView)findViewById(R.id.sheet_head);
            title.setText(marker.getTitle());
            //collapsing view(making it visible)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
        else if(i==2)
        {   LayoutInflater inflater = getLayoutInflater();
            FrameLayout container = findViewById(R.id.screen_area);
            inflater.inflate(R.layout.gate2, container);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        return true;
    }


    //location code
    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location permission Needed")
                        .setMessage("Please Allow Setting Permissions")
                        .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(MapsActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        //Request location updates:
                        locationManager.requestLocationUpdates(provider, 400, 1, this);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }

            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkLocationPermission();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(provider, 400, 1, this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
    }


    @Override
    public void onLocationChanged(Location location) {

        Double lat = location.getLatitude();
        Double lng = location.getLongitude();

        Log.i("Location info: Lat", lat.toString());
        Log.i("Location info: Lng", lng.toString());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void navigate(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+dlat+","+dlang));
        startActivity(intent);
    }

}
