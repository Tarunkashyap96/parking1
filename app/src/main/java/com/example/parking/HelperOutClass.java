package com.example.parking;

public class HelperOutClass {

 String  vehicleOut, timeOut, dateOut, checkFair, checkerName;

  public HelperOutClass(String vehicleOut, String timeOut, String dateOut, String checkFair, String checkerName) {
    this.vehicleOut = vehicleOut;
    this.timeOut = timeOut;
    this.dateOut = dateOut;
    this.checkFair = checkFair;
    this.checkerName = checkerName;
  }

  public String getVehicleOut() {
    return vehicleOut;
  }

  public void setVehicleOut(String vehicleOut) {
    this.vehicleOut = vehicleOut;
  }

  public String getTimeOut() {
    return timeOut;
  }

  public void setTimeOut(String timeOut) {
    this.timeOut = timeOut;
  }

  public String getDateOut() {
    return dateOut;
  }

  public void setDateOut(String dateOut) {
    this.dateOut = dateOut;
  }

  public String getCheckFair() {
    return checkFair;
  }

  public void setCheckFair(String checkFair) {
    this.checkFair = checkFair;
  }

  public String getCheckerName() {
    return checkerName;
  }

  public void setCheckerName(String checkerName) {
    this.checkerName = checkerName;
  }
}
