package com.example.dylan.gestures;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.AccessibilityDelegateCompat;


public class Gestures extends AppCompatActivity implements GestureDetector.OnGestureListener,
                                                           GestureDetector.OnDoubleTapListener{
    //reference to our textView
    private TextView textView;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView text1 = (TextView)findViewById(R.id.textView2);
                        text1.setText("Welcome to ManHunt");
                    }
                }
        );

        button1.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView text1 = (TextView) findViewById(R.id.textView2);
                        text1.setText("You like holding,\nthe button for a long\ntime...");
                        //tells computer the user did something and we took care of it
                        return false;
                    }
                }
        );
        textView = (TextView)findViewById(R.id.textView);
        //allows us to detect gestures
        this.gestureDetector = new GestureDetectorCompat(this, this);
        //separated double tap gestures for some reason
        gestureDetector.setOnDoubleTapListener(this);

    }

    ////////////////////BEGIN GESTURES///////////////////



    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("onFling");
        return true;
    }

    ////////////////////END GESTURES///////////////////

    //default functionality that gets called whenever a user touches screen
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //detect if that touch was a gesture and handle accordingly
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gestures, menu);
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
