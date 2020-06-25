package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;

public class CheckIn extends AppCompatActivity {

    Button Send;
    TextInputLayout Vehicle, Driver, Phone, Time, Date, Fare, Owner_name, Owner_Phone;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        Vehicle = findViewById(R.id.vehicle);
        Driver = findViewById(R.id.driver);
        Phone = findViewById(R.id.phone);
        Date = findViewById(R.id.date);
        Time = findViewById(R.id.time_in);
        Fare = findViewById(R.id.fare);
        Owner_name = findViewById(R.id.owner_name);
        Owner_Phone = findViewById(R.id.owner_Phone);
        Send = findViewById(R.id.park_btn);


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User");

                String vehicle = Vehicle.getEditText().getText().toString();
                String driver = Driver.getEditText().getText().toString();
                String phone = Phone.getEditText().getText().toString();
                String date = Date.getEditText().getText().toString();
                String time_in = Time.getEditText().getText().toString();
                String fare = Fare.getEditText().getText().toString();
                String owner_name = Owner_name.getEditText().getText().toString();
                String owner_Phone = Owner_Phone.getEditText().getText().toString();


                Intent intent = new Intent(getApplicationContext(), VerfiyPhoneNo.class);
                intent.putExtra("owner_Phone", owner_Phone);
                startActivity(intent);

                Helperclass helperClass = new Helperclass(vehicle, driver, phone, date, time_in, fare, owner_name, owner_Phone);
                reference.child(vehicle).setValue(helperClass);
                Toast.makeText(CheckIn.this, "Detail save in database", Toast.LENGTH_SHORT).show();
            }
        });
    }
}