package com.example.parking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;

public class checkout extends AppCompatActivity {

    Button checkout_btn, NewDriver;
    TextInputLayout vehicle, owner_name;
    TextView logoText, sloganText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkout_btn = findViewById(R.id.CheckDetails_btn);
        vehicle = findViewById(R.id.vehicle);
        owner_name = findViewById(R.id.owner_name);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        NewDriver = findViewById(R.id.NewDriver_btn);

        NewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(checkout.this, CheckIn.class);
                startActivity(intent);
            }
        });

        checkout_btn.setOnClickListener(new View.OnClickListener() {

            private Boolean validateVehicle() {

                String val = vehicle.getEditText().getText().toString();

                if (val.isEmpty()) {
                    vehicle.setError("Field cannot be empty");
                    return false;
                } else {
                    vehicle.setError(null);
                    vehicle.setErrorEnabled(false);
                    return true;
                }
            }

             private Boolean validateOwner() {

                String val = owner_name.getEditText().getText().toString();

                if (val.isEmpty()) {
                    owner_name.setError("Field cannot be empty");
                    return false;
                } else {
                    owner_name.setError(null);
                    owner_name.setErrorEnabled(false);
                    return true;
                }
            }

            @Override
            public void onClick(View v) {
                if (!validateVehicle()) {
                    return;
                } else {

                    final String userEnteredVehicle = vehicle.getEditText().getText().toString().trim();
                    final String userEnteredOwner_name = owner_name.getEditText().getText().toString().trim();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");

                    Query checkUser = reference.orderByChild("vehicle").equalTo(userEnteredVehicle);

                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {

                                vehicle.setError(null);
                                vehicle.setErrorEnabled(false);

                                String owner_nameFromDB = dataSnapshot.child(userEnteredVehicle).child("owner_name").getValue(String.class);

                                if (owner_nameFromDB.equals(userEnteredOwner_name)) {

                                    vehicle.setError(null);
                                    vehicle.setErrorEnabled(false);

                                    String vehicleFromDB = dataSnapshot.child(userEnteredVehicle).child("vehicle").getValue(String.class);
                                    String driverFromDB = dataSnapshot.child(userEnteredVehicle).child("driver").getValue(String.class);
                                    String phoneFromDB = dataSnapshot.child(userEnteredVehicle).child("phone").getValue(String.class);
                                    String dateFromDB = dataSnapshot.child(userEnteredVehicle).child("date").getValue(String.class);
                                    String timeFromDB = dataSnapshot.child(userEnteredVehicle).child("time_in").getValue(String.class);
                                    String fareFromDB = dataSnapshot.child(userEnteredVehicle).child("fare").getValue(String.class);
                                    String owner_phoneFromDB = dataSnapshot.child(userEnteredVehicle).child("owner_phone").getValue(String.class);


                                    Intent intent = new Intent(getApplicationContext(), UserProfile.class);

                                    intent.putExtra("vehicle", vehicleFromDB);
                                    intent.putExtra("driver", driverFromDB);
                                    intent.putExtra("phone", phoneFromDB);
                                    intent.putExtra("date", dateFromDB);
                                    intent.putExtra("time_in", timeFromDB);
                                    intent.putExtra("fare", fareFromDB);
                                    intent.putExtra("owner_name", owner_nameFromDB);
                                    intent.putExtra("owner_phone", owner_phoneFromDB);

                                    startActivity(intent);
                                }
                                else {
                                    owner_name.setError("Wrong Owner name");
                                    owner_name.requestFocus();
                                }
                            }

                            else {
                                vehicle.setError("No such Driver exist");
                                vehicle.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                }
            }
        });

    }
}
