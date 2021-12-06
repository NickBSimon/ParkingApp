package com.example.lotslot;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class fragment1 extends Fragment implements View.OnClickListener {

    private Button goldStreetSelect;
    View view;

    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
    private ImageView help;

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

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.slot0:
                break;
            case R.id.slot1:
                break;
            case R.id.slot2:
                break;
            case R.id.slot3:
                break;
            case R.id.slot4:
                break;
            case R.id.slot5:
                break;
            case R.id.slot6:
                break;
            case R.id.slot7:
                break;
            case R.id.slot8:
                break;
            case R.id.slot9:
                break;
            case R.id.slot10:
                break;
            case R.id.slot11:
                break;
            case R.id.slot12:
                break;
            case R.id.slot13:
                break;
            case R.id.slot14:
                break;
            case R.id.slot15:
                break;
            case R.id.slot16:
                break;
            case R.id.helpButton:
                HelpFragment helpFragment = new HelpFragment();
                helpFragment.show(getParentFragmentManager(), "help fragment");
                break;
        }
    }
}