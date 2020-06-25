package com.example.parking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Message extends AppCompatActivity {

    Button API, Message;
    EditText number, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        API = findViewById(R.id.Api_btn);
        Message = findViewById(R.id.text_message_btn);
        number = findViewById(R.id.phone);
        text = findViewById(R.id.details);




        API.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(Message.this, "Api message Sent", Toast.LENGTH_SHORT).show();
                    // Construct data
                    String apiKey = "apikey=" + "cnbVML0n/pw-kV4nD3QRD7YzFH1FxSNyW6VOtAaeFd";
                    String message = "&message=" + text.getText().toString();
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + number.getText().toString();

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Toast.makeText(Message.this, line.toString(), Toast.LENGTH_SHORT).show();
                    }
                    rd.close();

                } catch (Exception e) {
                    Toast.makeText(Message.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        StrictMode.ThreadPolicy st = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(st);

        Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   send();
            }
        });
    }
        private void send() {

            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                MyMessage();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
            }
        }

        private void MyMessage () {

            String phoneNumber = number.getText().toString().trim();
            String Message = text.getText().toString().trim();

            if (!number.getText().toString().equals("") || !text.getText().toString().equals("")) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, Message, null, null);
                Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode) {
                case 0:
                    if (grantResults.length >= 0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
                        MyMessage();
                    } else {
                        Toast.makeText(this, "you don't have permission", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

