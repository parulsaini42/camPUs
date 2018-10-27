package com.example.parul.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //splash screen for 3s
    private static int TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        StartAnimations();

    }
    private void StartAnimations()
    {
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        anim.reset();
        final ImageView i =(ImageView) findViewById(R.id.cam);
        i.clearAnimation();
        i.startAnimation(anim);

        anim= AnimationUtils.loadAnimation(this,R.anim.translate);
        anim.reset();
        Thread splashThread =new Thread()
        {
            @Override
            public void run(){
                try {
                    int waited = 0;
                    while (waited < 4000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashScreen.this.finish();
                }
                catch (InterruptedException e) {

                }
                finally {
                    SplashScreen.this.finish();
                }


            }
        };
        splashThread.start();
    }
}
