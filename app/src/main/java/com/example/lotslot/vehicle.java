package com.example.lotslot;

public class vehicle {
    private String ownerName;
    private String licensePlate;
    public vehicle(String name, String plate) {
        ownerName = name;
        licensePlate = plate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
