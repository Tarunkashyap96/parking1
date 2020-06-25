package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Splash_Activity extends AppCompatActivity {

    Button check_in, check_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        check_in = findViewById(R.id.checkin_btn);
        check_out = findViewById(R.id.checkout_btn);

        check_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash_Activity.this,CheckIn.class);
                startActivity(intent);
            }
        });

        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash_Activity.this,checkout.class);
                startActivity(intent);
            }
        });

        }
    }

