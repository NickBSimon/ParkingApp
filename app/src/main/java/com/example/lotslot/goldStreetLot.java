package com.example.lotslot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class goldStreetLot extends AppCompatActivity {
    parkingSpot spot0 = new parkingSpot();
    parkingSpot spot1 = new parkingSpot();
    parkingSpot spot2 = new parkingSpot();
    parkingSpot spot3 = new parkingSpot(new int[]{0});
    parkingSpot spot4 = new parkingSpot(new int[]{1});
    parkingSpot spot5 = new parkingSpot(new int[]{2, 6, 7});
    parkingSpot spot6 = new parkingSpot();
    parkingSpot spot7 = new parkingSpot();
    parkingSpot spot8 = new parkingSpot(new int[]{3});
    parkingSpot spot9 = new parkingSpot(new int[]{4});
    parkingSpot spot10 = new parkingSpot(new int[]{5, 11, 12});
    parkingSpot spot11 = new parkingSpot();
    parkingSpot spot12 = new parkingSpot();
    parkingSpot spot13 = new parkingSpot(new int[]{8, 14});
    parkingSpot spot14 = new parkingSpot(new int[]{9, 15});
    parkingSpot spot15 = new parkingSpot(new int[]{10, 16});
    parkingSpot spot16 = new parkingSpot();
    TextView vacancy;
    TextView shortTerm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_street_lot);

        Button slot0 = (Button) findViewById(R.id.slot0);
        Button slot1 = (Button) findViewById(R.id.slot1);
        Button slot2 = (Button) findViewById(R.id.slot2);
        Button slot3 = (Button) findViewById(R.id.slot3);
        Button slot4 = (Button) findViewById(R.id.slot4);
        Button slot5 = (Button) findViewById(R.id.slot5);
        Button slot6 = (Button) findViewById(R.id.slot6);
        Button slot7 = (Button) findViewById(R.id.slot7);
        Button slot8 = (Button) findViewById(R.id.slot8);
        Button slot9 = (Button) findViewById(R.id.slot9);
        Button slot10 = (Button) findViewById(R.id.slot10);
        Button slot11 = (Button) findViewById(R.id.slot11);
        Button slot12 = (Button) findViewById(R.id.slot12);
        Button slot13 = (Button) findViewById(R.id.slot13);
        Button slot14 = (Button) findViewById(R.id.slot14);
        Button slot15 = (Button) findViewById(R.id.slot15);
        Button slot16 = (Button) findViewById(R.id.slot16);

        vacancy = findViewById(R.id.vacancy);
        int totalVacancy = 0;
        int totalShort = 0;
        if (spot0.getState() == 1) totalVacancy++;
        if (spot0.getState() == 2) totalShort++;
        if (spot1.getState() == 1) totalVacancy++;
        if (spot1.getState() == 2) totalShort++;
        if (spot2.getState() == 1) totalVacancy++;
        if (spot2.getState() == 2) totalShort++;
        if (spot3.getState() == 1) totalVacancy++;
        if (spot3.getState() == 2) totalShort++;
        if (spot4.getState() == 1) totalVacancy++;
        if (spot4.getState() == 2) totalShort++;
        if (spot5.getState() == 1) totalVacancy++;
        if (spot5.getState() == 2) totalShort++;
        if (spot6.getState() == 1) totalVacancy++;
        if (spot6.getState() == 2) totalShort++;
        if (spot7.getState() == 1) totalVacancy++;
        if (spot7.getState() == 2) totalShort++;
        if (spot8.getState() == 1) totalVacancy++;
        if (spot8.getState() == 2) totalShort++;
        if (spot9.getState() == 1) totalVacancy++;
        if (spot9.getState() == 2) totalShort++;
        if (spot10.getState() == 1) totalVacancy++;
        if (spot10.getState() == 2) totalShort++;
        if (spot11.getState() == 1) totalVacancy++;
        if (spot11.getState() == 2) totalShort++;
        if (spot12.getState() == 1) totalVacancy++;
        if (spot12.getState() == 2) totalShort++;
        if (spot13.getState() == 1) totalVacancy++;
        if (spot13.getState() == 2) totalShort++;
        if (spot14.getState() == 1) totalVacancy++;
        if (spot14.getState() == 2) totalShort++;
        if (spot15.getState() == 1) totalVacancy++;
        if (spot15.getState() == 2) totalShort++;
        if (spot16.getState() == 1) totalVacancy++;
        if (spot16.getState() == 2) totalShort++;
        vacancy.setText(totalVacancy);
        shortTerm.setText(totalShort);


    }
}