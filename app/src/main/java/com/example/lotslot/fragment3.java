package com.example.lotslot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fragment3 extends Fragment implements View.OnClickListener{

    View view;
    private Button logout, reset;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment3, container, false);
        logout = (Button) view.findViewById(R.id.logoutButton);
        logout.setOnClickListener(this);
        reset = (Button) view.findViewById(R.id.resetPassButton2);
        reset.setOnClickListener(this);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        final TextView userNameTextView = (TextView) view.findViewById(R.id.profileName);
        final TextView userEmailTextView = (TextView) view.findViewById(R.id.profileEmail);
        final TextView userOccupy = (TextView) view.findViewById(R.id.profileOccupy);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if(userProfile != null){
                    String fullName = userProfile.username;
                    String email = userProfile.email;
                    String occupying = String.valueOf(userProfile.occupying + 1);
                    userNameTextView.setText(fullName);
                    userEmailTextView.setText(email);
                    if(userProfile.occupying != -1){
                        userOccupy.setText("Currently occupying slot " + occupying);
                    }
                    else{
                        userOccupy.setText("No spots claimed.");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.logoutButton:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;
            case R.id.resetPassButton2:
                startActivity(new Intent(getActivity(), ForgotPassword.class));
                break;

        }
    }
}