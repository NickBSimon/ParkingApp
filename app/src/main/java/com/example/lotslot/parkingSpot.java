package com.example.lotslot;

public class parkingSpot{
    private String end_time;
    private String end_date;
    private String note;
    int state;

    /*
    Parking spots have a state to represent the availability of the spot. 0 means closed,
    1 means open, 2 means open for set amount of time, 3 means taken
     */

    public parkingSpot(){
        end_time = null;
        end_date = null;
        state = 0;
        note = "";
    }

    public parkingSpot(String _begin, String _end, int _state){
        end_date = _begin;
        end_time = _end;
        state = _state;
    }

    public parkingSpot(String _ed, String _et, int _state, String _note){
        end_date = _ed;
        end_time = _et;
        state = _state;
        note = _note;
    }


    public int getState() {
        return state;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}