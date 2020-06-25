package com.example.logindata;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Car extends AppCompatActivity {

    ImageButton micro, mini, prime, luxury;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        micro = findViewById(R.id.Micro_btn);
        mini = findViewById(R.id.Mini_btn);
        prime = findViewById(R.id.Prime_btn);
        luxury = findViewById(R.id.Luxury_btn);

        micro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Car.this,MicroCar.class);
                startActivity(intent);
            }
        });

        mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Car.this,MiniCar.class);
                startActivity(intent);

            }
        });

        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Car.this,PrimeCar.class);
                startActivity(intent);

            }
        });

        luxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Car.this,LuxuaryCar.class);
                startActivity(intent);
            }
        });




    }
}
