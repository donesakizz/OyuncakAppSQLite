package com.example.socmedapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class AccountFragment extends Fragment {

    TextView profilKulAd ,KulYas ,KulEmail ,KulTel;
    ImageView userfoto;
    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        userfoto=view.findViewById(R.id.userfoto);
        profilKulAd = view.findViewById(R.id.profilName);
        KulYas = view.findViewById(R.id.profilAge);
        KulEmail = view.findViewById(R.id.profilemail);
        KulTel =view.findViewById(R.id.profiltelefon);

        return view;
    }

}