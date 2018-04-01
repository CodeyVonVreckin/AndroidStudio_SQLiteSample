package com.example.me.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Me on 2/26/2018.
 */
@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo
    private String uid;

    @ColumnInfo(name = "first_name")
    private String firstName = "";

    @ColumnInfo(name= "last_Name")
    private String lastName="";

    public String uid(){return uid;}
    public void uid(String val){uid = val;}

    public String firstName(){return firstName;}
    public void firstName(String val){firstName = val;}

    public String lastName(){return lastName;}
    public void lastName(String val){lastName = val;}

}
