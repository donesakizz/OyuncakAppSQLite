package com.example.socmedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username,password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))  {
                    Toast.makeText(login.this ,"Bütün Alanlar Doldurulmalıdır",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(login.this ,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Pagefirst.class);
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(login.this ,"Giriş Başarısız",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}