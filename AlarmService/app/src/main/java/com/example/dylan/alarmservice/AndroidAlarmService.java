package com.example.dylan.alarmservice;

import java.util.Calendar;



import android.app.Activity;

import android.app.AlarmManager;

import android.app.PendingIntent;

import android.content.Intent;

import android.os.Bundle;

import android.os.SystemClock;

import android.view.Menu;
import android.view.View;

import android.widget.Button;

import android.widget.Toast;
public class AndroidAlarmService extends Activity {

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_alarm_service);

        Button buttonStart = (Button)findViewById(R.id.startalarm);

        Button buttonCancel = (Button)findViewById(R.id.cancelalarm);



        buttonStart.setOnClickListener(new Button.OnClickListener(){



            @Override

            public void onClick(View arg0) {

                // TODO Auto-generated method stub



                Intent myIntent = new Intent(AndroidAlarmService.this, MyAlarmService.class);

                pendingIntent = PendingIntent.getService(AndroidAlarmService.this, 0, myIntent, 0);



                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);



                Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(System.currentTimeMillis());

                calendar.add(Calendar.SECOND, 10);

                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);



                Toast.makeText(AndroidAlarmService.this, "Start Alarm", Toast.LENGTH_LONG).show();

            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_android_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


