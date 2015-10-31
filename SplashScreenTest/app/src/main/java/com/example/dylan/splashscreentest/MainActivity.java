package com.example.dylan.splashscreentest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 5000;
    //private Drawable drawable;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash);
        mProgress = (ProgressBar) findViewById(R.id.progressBar1);
    }


    public void onStart(){
        super.onStart();
        //Log.i("START", "In on start");
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (mProgressStatus < 100) {
                        sleep(80);
                        //waited += 200;
                        mProgressStatus += 4;
                        mProgress.setProgress(mProgressStatus);
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        splashThread.start();
    }