package com.example.socmedapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pagefirst extends AppCompatActivity {

    BottomNavigationView btnavViewId;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagefirst);

        btnavViewId=findViewById(R.id.bottomNavViewId);
        frameLayout=findViewById(R.id.frameLayoutId);

        setFragment(new HomeFragment());

        btnavViewId.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homeId:
                        btnavViewId.setItemBackgroundResource(R.color.purple_200);
                        setFragment(new HomeFragment());
                        return true;

                    case R.id.aramaId:
                        btnavViewId.setItemBackgroundResource(R.color.teal_200);
                        setFragment(new SearchFragment());
                        return true;

                    case R.id.hesapId:
                        btnavViewId.setItemBackgroundResource(R.color.white);
                        setFragment(new AccountFragment());
                        return true;

                    default:
                        return false;
                }


                //return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId ,fragment ) ;
        fragmentTransaction.commit();

    }

    }
