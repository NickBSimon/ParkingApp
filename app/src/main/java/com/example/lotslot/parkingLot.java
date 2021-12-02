package com.example.lotslot;

import java.util.ArrayList;
import java.util.List;

public class parkingLot {
    private String lotName;
    List<parkingSpot> parkingSpots;
    private int capacity;
    private int totalParked;
    public parkingLot(String _lotName, int _capacity){
        lotName = _lotName;
        parkingSpots  = new ArrayList<parkingSpot>();
        capacity = _capacity;
        totalParked = 0;
    }

    public String getLotName() {
        return lotName;
    }

    public List<parkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalParked() {
        return totalParked;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setParkingSpots(List<parkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTotalParked(int totalParked) {
        this.totalParked = totalParked;
    }
}
