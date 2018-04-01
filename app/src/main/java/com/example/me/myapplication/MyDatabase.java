package com.example.me.myapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;

/**
 * Created by Me on 2/26/2018.
 */
@Database(entities = {User.class }, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase INSTANCE;
    public abstract UserDOA userDOA();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        // Since we didn't alter the table, there's nothing else to do here.
        }
    };




}

