package com.example.dylan.timercount;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends Activity {

    ViewGroup dylansLayout;
    MyCount timerCount;
    private TextView timerValue;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dylansLayout = (ViewGroup) findViewById(R.id.dylansLayout);

        setContentView(R.layout.activity_main);
        timerValue = (TextView) findViewById(R.id.timerValue);


        timerCount = new MyCount(11 * 1000, 1000);
        timerCount.start();
    }

    public class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            //some script here
            timerValue.setText("-BEGIN HUNT-");
            timerValue.setTextSize(50);

            TranslateAnimation trans = new TranslateAnimation(0, 0, 0, 1600);
            trans.setDuration(4000);
            trans.setInterpolator(new AccelerateInterpolator(1.0f));
            timerValue.startAnimation(trans);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //some script here
            timerValue.setText("Time Left: " + millisUntilFinished / 1000);
        }
    }
}