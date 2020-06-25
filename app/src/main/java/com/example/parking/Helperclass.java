package com.example.parking;

public class Helperclass {

    String vehicle, driver, phone, date, time_in, fare, owner_name, owner_phone ;


    public Helperclass(String name) {

    }

    public Helperclass(String vehicle, String driver, String phone, String date, String time_in, String fare, String owner_name, String owner_phone) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.phone = phone;
        this.date = date;
        this.time_in = time_in;
        this.fare = fare;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_Phone) {
        this.owner_phone = owner_Phone;
    }
}
