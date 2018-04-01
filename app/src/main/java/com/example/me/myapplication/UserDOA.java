package com.example.me.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.me.myapplication.User;

import java.util.List;

/**
 * Created by Me on 2/26/2018.
 */
//  User Data Access Objects .... supposed to be DAO :?/
@Dao
public interface UserDOA {

    @Query( "SELECT * FROM users")
    List<User> getAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
