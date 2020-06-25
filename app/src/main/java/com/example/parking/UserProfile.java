package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {

    TextInputLayout vehicle, driver, phone, date, time_in, fare, owner_name, owner_phone;
    TextView vehicleLabel, driverLabel;
    Button EnterOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        vehicle = findViewById(R.id.Vehicle_profile);
        driver = findViewById(R.id.driver_profile);
        phone = findViewById(R.id.phone_profile);
        date = findViewById(R.id.date_profile);
        time_in = findViewById(R.id.time_profile);
        fare = findViewById(R.id.Fare_profile);
        owner_name = findViewById(R.id.owner_name_profile);
        owner_phone = findViewById(R.id.owner_Phone_profile);
        vehicleLabel = findViewById(R.id.Vehicle_field);
        driverLabel = findViewById(R.id.driver_field);
        EnterOut = findViewById(R.id.OutDetails_btn);


        EnterOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this,Checkfair.class);
                startActivity(intent);
            }
        });

        showAllUserDate();
    }

    private void showAllUserDate() {

        Intent intent = getIntent();
        String user_vehicle = intent.getStringExtra("vehicle");
        String user_driver = intent.getStringExtra("driver");
        String user_phone = intent.getStringExtra("phone");
        String user_date = intent.getStringExtra("date");
        String user_time_in = intent.getStringExtra("time_in");
        String user_fare = intent.getStringExtra("fare");
        String user_owner_name = intent.getStringExtra("owner_name");
        String user_owner_phone = intent.getStringExtra("owner_phone");

        vehicleLabel.setText(user_vehicle);
        driverLabel.setText(user_driver);
        vehicle.getEditText().setText(user_vehicle);
        driver.getEditText().setText(user_driver);
        phone.getEditText().setText(user_phone);
        date.getEditText().setText(user_date);
        time_in.getEditText().setText(user_time_in);
        fare.getEditText().setText(user_fare);
        owner_name.getEditText().setText(user_owner_name);
        owner_phone.getEditText().setText(user_owner_phone);

    }
}
