package com.example.lotslot;

public class parkingSpot{
    private String begin;
    private String end;
    int state;
    /*
    Parking spots have a state to represent the availability of the spot. 0 means closed,
    1 means open, 2 means open for set amount of time, 3 means taken
     */

    public parkingSpot(){
        begin = null;
        end = null;
        state = 0;
    }

    public parkingSpot(String _begin, String _end, int _state){
        begin = _begin;
        end = _end;
        state = _state;
    }


    public String getBeginParkDate() {
        return begin;
    }

    public String getEndParkDate() {
        return end;
    }

    public int getState() {
        return state;
    }


    public void setBeginParkDate(String beginParkDate) {
        this.begin = beginParkDate;
    }

    public void setEndParkDate(String endParkDate) {
        this.end = endParkDate;
    }

    public void setState(int state) {
        this.state = state;
    }
}