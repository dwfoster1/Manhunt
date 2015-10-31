package com.example.dylan.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChatServerActivity extends Activity {

    private static final String host = null;
    private int port;
    String str = null;
    /**
     * Called when the activity is first created.
     */
    TextView txt5, txt1;
    byte[] send_data = new byte[1024];
    byte[] receiveData = new byte[1024];
    String modifiedSentence;
    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_server);

        txt1 = (TextView) findViewById(R.id.textView1);
        txt5 = (TextView) findViewById(R.id.textView2);

        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        //textIn.setText("oncreate");

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //textIn.setText("test");
                //txt2.setText("text2");
                //task.execute(null);
                str = "temp";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });

        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //textIn.setText("test");
                //txt2.setText("text2");
                //task.execute(null);

                str = "test";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //textIn.setText("test");
                //txt2.setText("text2");
                //task.execute(null);

                str = "humi";
                try {
                    client();
                    //txt1.setText(modifiedSentence);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });

        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //textIn.setText("test");
                //txt2.setText("text2");
                //task.execute(null);
                txt1.setText("null");
                txt5.setText("null");

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_server, menu);
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

    public void client() throws IOException {
        DatagramSocket client_socket = new DatagramSocket(8080);
        InetAddress IPAddress = InetAddress.getByName("152.30.122.201");

        send_data = str.getBytes();
        //System.out.println("Type Something (q or Q to quit): ");

        DatagramPacket send_packet = new DatagramPacket(send_data, str.length(), IPAddress, 8080);
        client_socket.send(send_packet);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client_socket.receive(receivePacket);
        modifiedSentence = new String(receivePacket.getData());
        //System.out.println("FROM SERVER:" + modifiedSentence);
        if (modifiedSentence.charAt(2) == '%')
            txt5.setText(modifiedSentence.substring(0, 3));
        else
            txt1.setText(modifiedSentence);
        modifiedSentence = null;
        client_socket.close();

        // }

    }
}
