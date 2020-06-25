package com.example.logindata;

import com.google.android.material.textfield.TextInputLayout;

public class pickupClass {

    String pickup, drop;

    public pickupClass(){

    }



    public pickupClass(String pickup, String drop) {
        this.pickup = pickup;
        this.drop = drop;
    }


    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }
}