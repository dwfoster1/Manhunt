package com.example.dylan.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;


public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView textView1 = (TextView) findViewById(R.id.textView1);
            textView1.setText("Nice job!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //pretends to calculate something large for ten seconds
                long futureTime = System.currentTimeMillis() + 3000;
                while(System.currentTimeMillis() < futureTime) {
                    //prevents multiple threads by doing the same thing
                    synchronized (this){
                        try{
                            wait(futureTime - System.currentTimeMillis());
                        }catch(Exception e) {
                            //dont need to do anything yet
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(r);
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
