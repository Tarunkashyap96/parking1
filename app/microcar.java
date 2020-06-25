package com.example.logindata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MicroCar extends AppCompatActivity {

    TextInputLayout Pickup, Drop;
    Button ConfirmMC, Goto;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_car);

        ConfirmMC = findViewById(R.id.confirm);
        Pickup = findViewById(R.id.pickup);
        Drop = findViewById(R.id.drop);
        Goto = findViewById(R.id.Go);

        ConfirmMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");


                String pickup = Pickup.getEditText().getText().toString();
                String drop = Drop.getEditText().getText().toString();

                pickupClass upClass = new pickupClass(pickup, drop);
                reference.setValue(upClass);

                Toast.makeText(MicroCar.this, "Thank you", Toast.LENGTH_SHORT).show();

            }
        });

        Goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MicroCar.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
