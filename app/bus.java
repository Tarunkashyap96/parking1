package com.example.logindata;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Bus extends AppCompatActivity {

    ImageButton minibus, regularbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        minibus = findViewById(R.id.Minibus);
        regularbus = findViewById(R.id.Regularbus);


        minibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bus.this,MiniBus.class);
                startActivity(intent);
            }
        });

        regularbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bus.this,RegularBus.class);
                startActivity(intent);
            }
        });



    }
}
