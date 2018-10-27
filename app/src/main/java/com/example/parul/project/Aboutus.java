package com.example.parul.project;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backw));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();


            }
        });
    }
    public void parul(View view){
        Toast.makeText(this, "Parul Saini", Toast.LENGTH_LONG).show();
        String url = "https://www.linkedin.com/in/parul-saini-493284135";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void ananay(View view){
        Toast.makeText(this, "Ananay Sharma", Toast.LENGTH_LONG).show();
        String url = "https://www.linkedin.com/in/ananay-sharma-1205";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void aman(View view){
        Toast.makeText(this, "Aman Saini", Toast.LENGTH_LONG).show();

    }
    public void mail(View view){
        try{
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "prthsharma753@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback about app");
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            //TODO smth
        }
    }
}
