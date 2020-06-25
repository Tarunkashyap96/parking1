package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Checkfair extends AppCompatActivity {

    TextInputLayout VehicleOut,TimeOut, DateOut, CheckFair, CheckerName;
    Button saveout, outmessage;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfair);

        VehicleOut = findViewById(R.id.vehicleOut);
        TimeOut = findViewById(R.id.timeOut);
        DateOut = findViewById(R.id.dateOut);
        CheckFair = findViewById(R.id.checkFair);
        CheckerName = findViewById(R.id.checkerName);
        saveout = findViewById(R.id.OutSaveDetail_btn);
        outmessage = findViewById(R.id.out_message);



        saveout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Out Vehicle Details");

                String vehicleOut = VehicleOut.getEditText().getText().toString();
                String timeOut = TimeOut.getEditText().getText().toString();
                String dateOut = DateOut.getEditText().getText().toString();
                String checkFair = CheckFair.getEditText().getText().toString();
                String checkerName = CheckerName.getEditText().getText().toString();


                HelperOutClass helperOutClass = new HelperOutClass(vehicleOut,timeOut,dateOut,checkFair,checkerName);
                reference.child(vehicleOut).setValue(helperOutClass);
                Toast.makeText(Checkfair.this, "Detail save in database", Toast.LENGTH_SHORT).show();

            }
        });

        outmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkfair.this,OutMessage.class);
                startActivity(intent);
            }
        });
    }
}
