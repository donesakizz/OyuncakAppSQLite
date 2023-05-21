package com.example.socmedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signup , login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        //Kayıt Ol butonuna tıklanabilir yapılır.
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();

            }
        });


        //Giriş yap butonu tıklanabilir yapılır
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openlogin();
            }
        });


    }


    //Kayıt ol butonuna tıklayınca Intent Metodu ile signup bulunduğu activitye gidecektir
    public void opensignup(){
        Intent intent =new Intent(this ,signup.class);
        startActivity(intent);
    }


    // Giriş yap butonuna tıklayınca Intent Metodu ile login  bulunduğu activitye gidecektir
    public void openlogin(){
        Intent intent =new Intent(this , login.class);
        startActivity(intent);
    }



}