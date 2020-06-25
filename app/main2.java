package com.example.logindata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         end = findViewById(R.id.Thankyou);

         end.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(Main2Activity.this,Thankyou_Activity.class);
                 startActivity(intent);
                 Toast.makeText(Main2Activity.this, "Your Booking is Confirm" +
                         "", Toast.LENGTH_SHORT).show();
             }
         });
    }
}

