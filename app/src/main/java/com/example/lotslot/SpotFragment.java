package com.example.lotslot;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpotFragment  extends DialogFragment{
    int slotNum;
    View view;
    private TextView spotFragmentNumber, endDate, endTime, textViewNote;
    private EditText note;
    Button reserve, sendNote;
    public SpotFragment(int _slotNum) {
        slotNum = _slotNum;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_spot, container, false);
        super.onCreateView(inflater, container, savedInstanceState);

        spotFragmentNumber = (TextView) view.findViewById(R.id.spotFragmentNumber);
        endDate = (TextView) view.findViewById(R.id.spotFragmentEndDate);
        endTime = (TextView) view.findViewById(R.id.spotFragmentEndTime);
        reserve = (Button) view.findViewById(R.id.reserveButton);
        textViewNote = (TextView) view.findViewById(R.id.spotFragmentNote);
        sendNote = (Button) view.findViewById(R.id.sendNoteButton);
        note = (EditText) view.findViewById(R.id.noteDialog);

        switch(slotNum){
            case 0:
                spotFragmentNumber.setText("Slot #1");
                ArrayList<String> list0 = new ArrayList<>();
                DatabaseReference reference0 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot0");
                reference0.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list0.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list0.add(dataSnapshot.getValue().toString());
                        }
                        if(list0.get(0) != null){
                            endDate.setText("End Date: " + list0.get(0));
                        }
                        if(list0.get(1) != null){
                            endTime.setText("End Time: " + list0.get(1));
                        }
                        if(list0.get(2) != null){
                            textViewNote.setText("Note from user: " + list0.get(2));
                        }
                        if(list0.get(3) != null){
                            if(Integer.parseInt(list0.get(3)) == 1){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                            }
                            else if(Integer.parseInt(list0.get(3)) == 3){
                                note.setVisibility(view.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case 1:
                spotFragmentNumber.setText("Slot #2");
                ArrayList<String> list1 = new ArrayList<>();
                DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot1");
                reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list1.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list1.add(dataSnapshot.getValue().toString());
                        }
                        if(list1.get(0) != null && (Integer.parseInt(list1.get(3)) == 3)){
                            endDate.setText("End Date: " + list1.get(0));
                        }
                        if(list1.get(1) != null && (Integer.parseInt(list1.get(3)) == 3)){
                            endTime.setText("End Time: " + list1.get(1));
                        }
                        if(list1.get(2) != null&& (Integer.parseInt(list1.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list1.get(2));
                        }
                        if(list1.get(3) != null){
                            if(Integer.parseInt(list1.get(3)) == 1){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                            }
                            else if(Integer.parseInt(list1.get(3)) == 3){
                                note.setVisibility(view.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case 2:
                spotFragmentNumber.setText("Slot #3");
                break;
            case 3:
                spotFragmentNumber.setText("Slot #4");
                break;
            case 4:
                spotFragmentNumber.setText("Slot #5");
                break;
            case 5:
                spotFragmentNumber.setText("Slot #6");
                break;
            case 6:
                spotFragmentNumber.setText("Slot #7");
                break;
            case 7:
                spotFragmentNumber.setText("Slot #8");
                break;
            case 8:
                spotFragmentNumber.setText("Slot #9");
                break;
            case 9:
                spotFragmentNumber.setText("Slot #10");
                break;
            case 10:
                spotFragmentNumber.setText("Slot #11");
                break;
            case 11:
                spotFragmentNumber.setText("Slot #12");
                break;
            case 12:
                spotFragmentNumber.setText("Slot #13");
                break;
            case 13:
                spotFragmentNumber.setText("Slot #14");
                break;
            case 14:
                spotFragmentNumber.setText("Slot #15");
                break;
            case 15:
                spotFragmentNumber.setText("Slot #16");
                break;
            case 16:
                spotFragmentNumber.setText("Slot #17");
                break;
        }


        return view;
    }

}