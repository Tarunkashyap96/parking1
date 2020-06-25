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

public class OutMessage extends AppCompatActivity {

    Button OutMessage, OutApi_btn;
    EditText mobile, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_message);

        mobile = findViewById(R.id.mobileNo);
        OutMessage = findViewById(R.id.OutMessage_btn);
        details = findViewById(R.id.details);
        OutApi_btn = findViewById(R.id.OutApi_btn);


        OutApi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(OutMessage.this, "Api message Sent", Toast.LENGTH_SHORT).show();
                    // Construct data
                    String apiKey = "apikey=" + "cnbVML0n/pw-kV4nD3QRD7YzFH1FxSNyW6VOtAaeFd";
                    String message = "&message=" + details.getText().toString();
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + mobile.getText().toString();

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
                        Toast.makeText(OutMessage.this, line.toString(), Toast.LENGTH_SHORT).show();
                    }
                    rd.close();

                } catch (Exception e) {
                    Toast.makeText(OutMessage.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        StrictMode.ThreadPolicy tr = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(tr);


        OutMessage.setOnClickListener(new View.OnClickListener() {
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
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        }
    }

    private void MyMessage() {
        String phoneNumber = mobile.getText().toString().trim();
        String Message = details.getText().toString().trim();

        if (!mobile.getText().toString().equals("") || !details.getText().toString().equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, Message, null, null);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length >= 1 && grantResults[1] == getPackageManager().PERMISSION_GRANTED) {
                    MyMessage();
                } else {
                    Toast.makeText(this, "you don't have permission", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}