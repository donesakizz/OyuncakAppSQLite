package com.example.socmedapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "userdata", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        //Kullanıcı tablosunu oluşturma SQL sorgusu
        DB.execSQL("create table Userdetails(username TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        //Veritabanı sürümü değiştiğinde yapılması gereken işlemler
        DB.execSQL("drop table if exists Userdetails");

    }

    public Boolean insertdata(String username ,String password){
        SQLiteDatabase DB= this.getWritableDatabase();//getWritableDataBase ile mevcut veritabaı açar,değilse oluşturur
        ContentValues contentValues = new ContentValues();//ContentValues metodu bir veritabanına eklenecek veya güncellenecek verilerin tutlması için kullanılır.
        contentValues.put("username" ,username);
        contentValues.put("password",password);
        long result =DB.insert("userdetails",null,contentValues);//Userdetails tablosuna "username"ve"password" sütunlarına karşılık gelen değerler eklenir
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }


    public Boolean checkusername(String username){
        SQLiteDatabase DB= this.getWritableDatabase();//getWritableDataBase ile mevcut veritabaı açar,değilse oluşturur
        Cursor cursor = DB.rawQuery("select * from Userdetails where username=?",new String[] {username});//Cursor ve rawQuery ile veritabanı sorguların sonuçları okunur,işlenir
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public Boolean checkusernamepassword(String username,String password) {
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where username=? and password=?" ,new String[] {username , password} );
        if(cursor.getCount()<0){//getCount Cursor sınıfında bulunan bir metot.Cursor nesnesi üzerinde sorgu sonucunun boş olup olmadığını döndürecek
            return false;
        }
        else {
            return true;
        }
    }




}
