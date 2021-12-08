package com.example.lotslot;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class fragment1 extends Fragment implements View.OnClickListener {
    View view;

    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    private ImageView help;
    private TextView vacancy, conditionalSpots;
    final ArrayList<parkingSpot> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        b0 = (Button) view.findViewById(R.id.slot0);
        b0.setOnClickListener(this);
        b1 = (Button) view.findViewById(R.id.slot1);
        b1.setOnClickListener(this);
        b2 = (Button) view.findViewById(R.id.slot2);
        b2.setOnClickListener(this);
        b3 = (Button) view.findViewById(R.id.slot3);
        b3.setOnClickListener(this);
        b4 = (Button) view.findViewById(R.id.slot4);
        b4.setOnClickListener(this);
        b5 = (Button) view.findViewById(R.id.slot5);
        b5.setOnClickListener(this);
        b6 = (Button) view.findViewById(R.id.slot6);
        b6.setOnClickListener(this);
        b7 = (Button) view.findViewById(R.id.slot7);
        b7.setOnClickListener(this);
        b8 = (Button) view.findViewById(R.id.slot8);
        b8.setOnClickListener(this);
        b9 = (Button) view.findViewById(R.id.slot9);
        b9.setOnClickListener(this);
        b10 = (Button) view.findViewById(R.id.slot10);
        b10.setOnClickListener(this);
        b11 = (Button) view.findViewById(R.id.slot11);
        b11.setOnClickListener(this);
        b12 = (Button) view.findViewById(R.id.slot12);
        b12.setOnClickListener(this);
        b13 = (Button) view.findViewById(R.id.slot13);
        b13.setOnClickListener(this);
        b14 = (Button) view.findViewById(R.id.slot14);
        b14.setOnClickListener(this);
        b15 = (Button) view.findViewById(R.id.slot15);
        b15.setOnClickListener(this);
        b16 = (Button) view.findViewById(R.id.slot16);
        b16.setOnClickListener(this);

        help = (ImageView) view.findViewById(R.id.helpButton);
        help.setOnClickListener(this);

        vacancy = (TextView) view.findViewById(R.id.vacancy);
        conditionalSpots = (TextView) view.findViewById(R.id.conditionalSpots);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    parkingSpot spot = dataSnapshot.getValue(parkingSpot.class);
                    list.add(spot);
                }
                switch(list.get(0).getState()){
                    case 0:
                        b0.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b0.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b0.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b0.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(1).getState()){
                    case 0:
                        b1.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b1.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b1.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b1.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(2).getState()){
                    case 0:
                        b10.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b10.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b10.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b10.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(3).getState()){
                    case 0:
                        b11.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b11.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b11.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b11.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(4).getState()){
                    case 0:
                        b12.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b12.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b12.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b12.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(5).getState()){
                    case 0:
                        b13.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b13.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b13.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b13.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(6).getState()){
                    case 0:
                        b14.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b14.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b14.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b14.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(7).getState()){
                    case 0:
                        b15.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b15.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b15.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b15.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(8).getState()){
                    case 0:
                        b16.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b16.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b16.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b16.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(9).getState()){
                    case 0:
                        b2.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b2.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b2.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b2.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(10).getState()){
                    case 0:
                        b3.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b3.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b3.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b3.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(11).getState()){
                    case 0:
                        b4.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b4.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b4.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b4.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(12).getState()){
                    case 0:
                        b5.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b5.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b5.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b5.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(13).getState()){
                    case 0:
                        b6.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b6.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b6.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b6.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(14).getState()){
                    case 0:
                        b7.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b7.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b7.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b7.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(15).getState()){
                    case 0:
                        b8.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b8.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b8.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b8.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                switch(list.get(16).getState()){
                    case 0:
                        b9.setBackgroundColor(Color.parseColor("#535353"));
                        break;
                    case 1:
                        b9.setBackgroundColor(Color.parseColor("#4CAF50"));
                        break;
                    case 2:
                        b9.setBackgroundColor(Color.parseColor("#FFEB3B"));
                        break;
                    case 3:
                        b9.setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                }
                int vacancyCount = 0;
                int conditionalCount = 0;
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i).getState() == 1){
                        vacancyCount++;
                    }
                    else if(list.get(i).getState() == 2){
                        conditionalCount++;
                    }
                }

                vacancy.setText(String.valueOf(vacancyCount));
                conditionalSpots.setText(String.valueOf(conditionalCount));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.slot0:
                SpotFragment spot0Fragment = new SpotFragment(0);
                spot0Fragment.show(getParentFragmentManager(), "Spot0 fragment");
                break;
            case R.id.slot1:
                SpotFragment spot1Fragment = new SpotFragment(1);
                spot1Fragment.show(getParentFragmentManager(), "Spot1 fragment");
                break;
            case R.id.slot2:
                SpotFragment spot2Fragment = new SpotFragment(2);
                spot2Fragment.show(getParentFragmentManager(), "Spot2 fragment");
                break;
            case R.id.slot3:
                SpotFragment spot3Fragment = new SpotFragment(3);
                spot3Fragment.show(getParentFragmentManager(), "Spot3 fragment");
                break;
            case R.id.slot4:
                SpotFragment spot4Fragment = new SpotFragment(4);
                spot4Fragment.show(getParentFragmentManager(), "Spot4 fragment");
                break;
            case R.id.slot5:
                SpotFragment spot5Fragment = new SpotFragment(5);
                spot5Fragment.show(getParentFragmentManager(), "Spot5 fragment");
                break;
            case R.id.slot6:
                SpotFragment spot6Fragment = new SpotFragment(6);
                spot6Fragment.show(getParentFragmentManager(), "Spot6 fragment");
                break;
            case R.id.slot7:
                SpotFragment spot7Fragment = new SpotFragment(7);
                spot7Fragment.show(getParentFragmentManager(), "Spot7 fragment");
                break;
            case R.id.slot8:
                SpotFragment spot8Fragment = new SpotFragment(8);
                spot8Fragment.show(getParentFragmentManager(), "Spot8 fragment");
                break;
            case R.id.slot9:
                SpotFragment spot9Fragment = new SpotFragment(9);
                spot9Fragment.show(getParentFragmentManager(), "Spot9 fragment");
                break;
            case R.id.slot10:
                SpotFragment spot10Fragment = new SpotFragment(10);
                spot10Fragment.show(getParentFragmentManager(), "Spot10 fragment");
                break;
            case R.id.slot11:
                SpotFragment spot11Fragment = new SpotFragment(11);
                spot11Fragment.show(getParentFragmentManager(), "Spot11 fragment");
                break;
            case R.id.slot12:
                SpotFragment spot12Fragment = new SpotFragment(12);
                spot12Fragment.show(getParentFragmentManager(), "Spot12 fragment");
                break;
            case R.id.slot13:
                SpotFragment spot13Fragment = new SpotFragment(13);
                spot13Fragment.show(getParentFragmentManager(), "Spot13 fragment");
                break;
            case R.id.slot14:
                SpotFragment spot14Fragment = new SpotFragment(14);
                spot14Fragment.show(getParentFragmentManager(), "Spot14 fragment");
                break;
            case R.id.slot15:
                SpotFragment spot15Fragment = new SpotFragment(15);
                spot15Fragment.show(getParentFragmentManager(), "Spot15 fragment");
                break;
            case R.id.slot16:
                SpotFragment spot16Fragment = new SpotFragment(16);
                spot16Fragment.show(getParentFragmentManager(), "Spot16 fragment");
                break;
            case R.id.helpButton:
                HelpFragment helpFragment = new HelpFragment();
                helpFragment.show(getParentFragmentManager(), "help fragment");
                break;
        }
    }
}