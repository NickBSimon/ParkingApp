package com.example.lotslot;

public class parkingSpot{
    vehicle parkedCar;
    private String beginParkDate;
    private String endParkDate;
    int state;
    int constraints[];
    /*
    Parking spots have a state to represent the availability of the spot. 0 means closed,
    1 means open, 2 means open for set amount of time, 3 means taken, 4 means unavailable until more
    spots fill up
     */

    public parkingSpot(){
        beginParkDate = null;
        endParkDate = null;
        parkedCar = null;
        constraints = null;
        state = 1;
    }

    public parkingSpot(int _constraints[]){
        beginParkDate = null;
        endParkDate = null;
        parkedCar = null;
        state = 4;
        constraints = _constraints;
    }

    public vehicle getParkedCar() {
        return parkedCar;
    }

    public String getBeginParkDate() {
        return beginParkDate;
    }

    public String getEndParkDate() {
        return endParkDate;
    }

    public int getState() {
        return state;
    }

    public void setParkedCar(vehicle parkedCar) {
        this.parkedCar = parkedCar;
    }

    public void setBeginParkDate(String beginParkDate) {
        this.beginParkDate = beginParkDate;
    }

    public void setEndParkDate(String endParkDate) {
        this.endParkDate = endParkDate;
    }

    public void setState(int state) {
        this.state = state;
    }
}