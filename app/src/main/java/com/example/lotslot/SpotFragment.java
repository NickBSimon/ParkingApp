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
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class SpotFragment  extends DialogFragment implements View.OnClickListener{
    int slotNum;
    View view;
    private TextView spotFragmentNumber, endDate, endTime, textViewNote;
    private EditText note;
    private FirebaseUser user;
    private Button reserve, sendNote, leaveSpot;
    private String userID;
    int occupying;
    private DatabaseReference reference;

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
        leaveSpot = (Button) view.findViewById(R.id.leaveSpotButton);
        leaveSpot.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if(userProfile != null){
                    occupying = (int) userProfile.occupying;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });



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
                                note.setVisibility(View.GONE);
                                endTime.setVisibility(View.GONE);
                                endDate.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list0.get(3)) == 3){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list0.get(3)) == 3){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
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
                            if(Integer.parseInt(list1.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list1.get(3)) == 3 && occupying != 1){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list1.get(3)) == 3 && occupying == 1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 2:
                spotFragmentNumber.setText("Slot #3");
                ArrayList<String> list2 = new ArrayList<>();
                DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot2");
                reference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list2.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list2.add(dataSnapshot.getValue().toString());
                        }
                        if(list2.get(0) != null && (Integer.parseInt(list2.get(3)) == 3)){
                            endDate.setText("End Date: " + list2.get(0));
                        }
                        if(list2.get(1) != null && (Integer.parseInt(list2.get(3)) == 3)){
                            endTime.setText("End Time: " + list2.get(1));
                        }
                        if(list2.get(2) != null&& (Integer.parseInt(list2.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list2.get(2));
                        }
                        if(list2.get(3) != null){
                            if(Integer.parseInt(list2.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list2.get(3)) == 3 && occupying != 2){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list2.get(3)) == 3 && occupying == 2){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 3:
                spotFragmentNumber.setText("Slot #4");
                ArrayList<String> list3 = new ArrayList<>();
                DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot3");
                reference3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list3.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list3.add(dataSnapshot.getValue().toString());
                        }
                        if(list3.get(0) != null && (Integer.parseInt(list3.get(3)) == 3)){
                            endDate.setText("End Date: " + list3.get(0));
                        }
                        if(list3.get(1) != null && (Integer.parseInt(list3.get(3)) == 3)){
                            endTime.setText("End Time: " + list3.get(1));
                        }
                        if(list3.get(2) != null&& (Integer.parseInt(list3.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list3.get(2));
                        }
                        if(list3.get(3) != null){
                            if(Integer.parseInt(list3.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list3.get(3)) == 3 && occupying != 3){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list3.get(3)) == 3 && occupying == 3){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case 4:
                spotFragmentNumber.setText("Slot #5");
                ArrayList<String> list4 = new ArrayList<>();
                DatabaseReference reference4 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot4");
                reference4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list4.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list4.add(dataSnapshot.getValue().toString());
                        }
                        if(list4.get(0) != null && (Integer.parseInt(list4.get(3)) == 3)){
                            endDate.setText("End Date: " + list4.get(0));
                        }
                        if(list4.get(1) != null && (Integer.parseInt(list4.get(3)) == 3)){
                            endTime.setText("End Time: " + list4.get(1));
                        }
                        if(list4.get(2) != null&& (Integer.parseInt(list4.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list4.get(2));
                        }
                        if(list4.get(3) != null){
                            if(Integer.parseInt(list4.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list4.get(3)) == 3 && occupying != 4){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list4.get(3)) == 3 && occupying == 4){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 5:
                spotFragmentNumber.setText("Slot #6");
                ArrayList<String> list5 = new ArrayList<>();
                DatabaseReference reference5 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot5");
                reference5.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list5.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list5.add(dataSnapshot.getValue().toString());
                        }
                        if(list5.get(0) != null && (Integer.parseInt(list5.get(3)) == 3)){
                            endDate.setText("End Date: " + list5.get(0));
                        }
                        if(list5.get(1) != null && (Integer.parseInt(list5.get(3)) == 3)){
                            endTime.setText("End Time: " + list5.get(1));
                        }
                        if(list5.get(2) != null&& (Integer.parseInt(list5.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list5.get(2));
                        }
                        if(list5.get(3) != null){
                            if(Integer.parseInt(list5.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list5.get(3)) == 3 && occupying != 5){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list5.get(3)) == 3 && occupying == 5){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 6:
                spotFragmentNumber.setText("Slot #7");
                ArrayList<String> list6 = new ArrayList<>();
                DatabaseReference reference6 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot6");
                reference6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list6.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list6.add(dataSnapshot.getValue().toString());
                        }
                        if(list6.get(0) != null && (Integer.parseInt(list6.get(3)) == 3)){
                            endDate.setText("End Date: " + list6.get(0));
                        }
                        if(list6.get(1) != null && (Integer.parseInt(list6.get(3)) == 3)){
                            endTime.setText("End Time: " + list6.get(1));
                        }
                        if(list6.get(2) != null&& (Integer.parseInt(list6.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list6.get(2));
                        }
                        if(list6.get(3) != null){
                            if(Integer.parseInt(list6.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list6.get(3)) == 3 && occupying != 6){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list6.get(3)) == 3 && occupying == 6){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 7:
                spotFragmentNumber.setText("Slot #8");
                ArrayList<String> list7 = new ArrayList<>();
                DatabaseReference reference7 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot7");
                reference7.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list7.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list7.add(dataSnapshot.getValue().toString());
                        }
                        if(list7.get(0) != null && (Integer.parseInt(list7.get(3)) == 3)){
                            endDate.setText("End Date: " + list7.get(0));
                        }
                        if(list7.get(1) != null && (Integer.parseInt(list7.get(3)) == 3)){
                            endTime.setText("End Time: " + list7.get(1));
                        }
                        if(list7.get(2) != null&& (Integer.parseInt(list7.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list7.get(2));
                        }
                        if(list7.get(3) != null){
                            if(Integer.parseInt(list7.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list7.get(3)) == 3 && occupying != 7){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list7.get(3)) == 3 && occupying == 7){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 8:
                spotFragmentNumber.setText("Slot #9");
                ArrayList<String> list8 = new ArrayList<>();
                DatabaseReference reference8 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot8");
                reference8.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list8.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list8.add(dataSnapshot.getValue().toString());
                        }
                        if(list8.get(0) != null && (Integer.parseInt(list8.get(3)) == 3)){
                            endDate.setText("End Date: " + list8.get(0));
                        }
                        if(list8.get(1) != null && (Integer.parseInt(list8.get(3)) == 3)){
                            endTime.setText("End Time: " + list8.get(1));
                        }
                        if(list8.get(2) != null&& (Integer.parseInt(list8.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list8.get(2));
                        }
                        if(list8.get(3) != null){
                            if(Integer.parseInt(list8.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list8.get(3)) == 3 && occupying != 8){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list8.get(3)) == 3 && occupying == 8){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 9:
                spotFragmentNumber.setText("Slot #10");
                ArrayList<String> list9 = new ArrayList<>();
                DatabaseReference reference9 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot9");
                reference9.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list9.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list9.add(dataSnapshot.getValue().toString());
                        }
                        if(list9.get(0) != null && (Integer.parseInt(list9.get(3)) == 3)){
                            endDate.setText("End Date: " + list9.get(0));
                        }
                        if(list9.get(1) != null && (Integer.parseInt(list9.get(3)) == 3)){
                            endTime.setText("End Time: " + list9.get(1));
                        }
                        if(list9.get(2) != null&& (Integer.parseInt(list9.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list9.get(2));
                        }
                        if(list9.get(3) != null){
                            if(Integer.parseInt(list9.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list9.get(3)) == 3 && occupying != 9){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list9.get(3)) == 3 && occupying == 9){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 10:
                spotFragmentNumber.setText("Slot #11");
                ArrayList<String> list10 = new ArrayList<>();
                DatabaseReference reference10 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot10");
                reference10.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list10.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list10.add(dataSnapshot.getValue().toString());
                        }
                        if(list10.get(0) != null && (Integer.parseInt(list10.get(3)) == 3)){
                            endDate.setText("End Date: " + list10.get(0));
                        }
                        if(list10.get(1) != null && (Integer.parseInt(list10.get(3)) == 3)){
                            endTime.setText("End Time: " + list10.get(1));
                        }
                        if(list10.get(2) != null&& (Integer.parseInt(list10.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list10.get(2));
                        }
                        if(list10.get(3) != null){
                            if(Integer.parseInt(list10.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list10.get(3)) == 3 && occupying != 10){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list10.get(3)) == 3 && occupying == 10){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 11:
                spotFragmentNumber.setText("Slot #12");
                ArrayList<String> list11 = new ArrayList<>();
                DatabaseReference reference11 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot11");
                reference11.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list11.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list11.add(dataSnapshot.getValue().toString());
                        }
                        if(list11.get(0) != null && (Integer.parseInt(list11.get(3)) == 3)){
                            endDate.setText("End Date: " + list11.get(0));
                        }
                        if(list11.get(1) != null && (Integer.parseInt(list11.get(3)) == 3)){
                            endTime.setText("End Time: " + list11.get(1));
                        }
                        if(list11.get(2) != null&& (Integer.parseInt(list11.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list11.get(2));
                        }
                        if(list11.get(3) != null){
                            if(Integer.parseInt(list11.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list11.get(3)) == 3 && occupying != 11){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list11.get(3)) == 3 && occupying == 11){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 12:
                spotFragmentNumber.setText("Slot #13");
                ArrayList<String> list12 = new ArrayList<>();
                DatabaseReference reference12 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot12");
                reference12.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list12.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list12.add(dataSnapshot.getValue().toString());
                        }
                        if(list12.get(0) != null && (Integer.parseInt(list12.get(3)) == 3)){
                            endDate.setText("End Date: " + list12.get(0));
                        }
                        if(list12.get(1) != null && (Integer.parseInt(list12.get(3)) == 3)){
                            endTime.setText("End Time: " + list12.get(1));
                        }
                        if(list12.get(2) != null&& (Integer.parseInt(list12.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list12.get(2));
                        }
                        if(list12.get(3) != null){
                            if(Integer.parseInt(list12.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list12.get(3)) == 3 && occupying != 12){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list12.get(3)) == 3 && occupying == 12){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 13:
                spotFragmentNumber.setText("Slot #14");
                ArrayList<String> list13 = new ArrayList<>();
                DatabaseReference reference13 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot13");
                reference13.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list13.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list13.add(dataSnapshot.getValue().toString());
                        }
                        if(list13.get(0) != null && (Integer.parseInt(list13.get(3)) == 3)){
                            endDate.setText("End Date: " + list13.get(0));
                        }
                        if(list13.get(1) != null && (Integer.parseInt(list13.get(3)) == 3)){
                            endTime.setText("End Time: " + list13.get(1));
                        }
                        if(list13.get(2) != null&& (Integer.parseInt(list13.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list13.get(2));
                        }
                        if(list13.get(3) != null){
                            if(Integer.parseInt(list13.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list13.get(3)) == 3 && occupying != 13){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list13.get(3)) == 3 && occupying == 13){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case 14:
                spotFragmentNumber.setText("Slot #15");
                ArrayList<String> list14 = new ArrayList<>();
                DatabaseReference reference14 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot14");
                reference14.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list14.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list14.add(dataSnapshot.getValue().toString());
                        }
                        if(list14.get(0) != null && (Integer.parseInt(list14.get(3)) == 3)){
                            endDate.setText("End Date: " + list14.get(0));
                        }
                        if(list14.get(1) != null && (Integer.parseInt(list14.get(3)) == 3)){
                            endTime.setText("End Time: " + list14.get(1));
                        }
                        if(list14.get(2) != null&& (Integer.parseInt(list14.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list14.get(2));
                        }
                        if(list14.get(3) != null){
                            if(Integer.parseInt(list14.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list14.get(3)) == 3 && occupying != 14){
                                note.setVisibility(View.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list14.get(3)) == 3 && occupying == 14){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 15:
                spotFragmentNumber.setText("Slot #16");
                ArrayList<String> list15 = new ArrayList<>();
                DatabaseReference reference15 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot15");
                reference15.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list15.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list15.add(dataSnapshot.getValue().toString());
                        }
                        if(list15.get(0) != null && (Integer.parseInt(list15.get(3)) == 3)){
                            endDate.setText("End Date: " + list15.get(0));
                        }
                        if(list15.get(1) != null && (Integer.parseInt(list15.get(3)) == 3)){
                            endTime.setText("End Time: " + list15.get(1));
                        }
                        if(list15.get(2) != null&& (Integer.parseInt(list15.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list15.get(2));
                        }
                        if(list15.get(3) != null){
                            if(Integer.parseInt(list15.get(3)) == 1 && occupying == -1){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list15.get(3)) == 3 && occupying != 15){
                                note.setVisibility(view.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list15.get(3)) == 3 && occupying == 15){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 16:
                spotFragmentNumber.setText("Slot #17");
                ArrayList<String> list16 = new ArrayList<>();
                DatabaseReference reference16 = FirebaseDatabase.getInstance().getReference().child("goldstreet").child("slot16");
                reference16.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list16.clear();
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            list16.add(dataSnapshot.getValue().toString());
                        }
                        if(list16.get(0) != null && (Integer.parseInt(list16.get(3)) == 3)){
                            endDate.setText("End Date: " + list16.get(0));
                        }
                        if(list16.get(1) != null && (Integer.parseInt(list16.get(3)) == 3)){
                            endTime.setText("End Time: " + list16.get(1));
                        }
                        if(list16.get(2) != null&& (Integer.parseInt(list16.get(3)) == 3)){
                            textViewNote.setText("Note from user: " + list16.get(2));
                        }
                        if(list16.get(3) != null){
                            if(Integer.parseInt(list16.get(3)) == 1 && occupying == -1){
                                note.setVisibility(View.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.VISIBLE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list16.get(3)) == 3 && occupying != 16){
                                note.setVisibility(view.VISIBLE);
                                sendNote.setVisibility(View.VISIBLE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.GONE);
                            }
                            else if(Integer.parseInt(list16.get(3)) == 3 && occupying == 16){
                                note.setVisibility(view.GONE);
                                sendNote.setVisibility(View.GONE);
                                reserve.setVisibility(View.GONE);
                                leaveSpot.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }


        return view;
    }

    @Override
    public void onClick(View view1) {
        HashMap hashMap;
        DatabaseReference lotReference;
        switch (view1.getId()){
            case R.id.leaveSpotButton:
                switch(slotNum){
                    case 0:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot0").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot3").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 1:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot1").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot4").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 2:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot2").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot5").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 3:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot3").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot8").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 4:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot4").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot9").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 5:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot5").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot10").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 6:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot6").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot5").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 7:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot7").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot5").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot10").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 8:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot8").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot13").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 9:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot9").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot14").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 10:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot10").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot15").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 11:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot11").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot10").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 12:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot12").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot10").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot15").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                    case 13:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot13").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        occupying = -1;
                        break;
                    case 14:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot14").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        occupying = -1;
                        break;
                    case 15:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot15").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        occupying = -1;
                        break;
                    case 16:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 1);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot16").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Left spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 0);
                        lotReference.child("slot15").updateChildren(hashMap);
                        hashMap = new HashMap();
                        hashMap.put("occupying", -1);
                        reference.child(userID).updateChildren(hashMap);
                        occupying = -1;
                        break;
                }
                break;
            case R.id.reserveButton:
                switch(slotNum){
                    case 0:
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 3);
                        hashMap.put("end_date", "none");
                        hashMap.put("end_time", "none");
                        hashMap.put("note", "none");
                        lotReference = FirebaseDatabase.getInstance().getReference().child("goldstreet");
                        lotReference.child("slot0").updateChildren(hashMap).addOnSuccessListener(o -> Toast.makeText(getActivity(), "Reserved spot", Toast.LENGTH_LONG).show());
                        hashMap = new HashMap();
                        hashMap.put("state", (long) 2);
                        lotReference.child("slot3").updateChildren(hashMap);
                        break;
                }
                break;
        }
    }
}