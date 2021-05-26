package com.example.notes_app.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notes_app.dao.dao;
import com.example.notes_app.entity.notes;

@Database(entities = {notes.class}, version = 1)
public abstract class database extends RoomDatabase {

    public abstract dao dao();

    public static database INSTANCE;

    public static database getdatabaseInstace(Context context) {
        if (INSTANCE == null) {
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    database.class,"notes_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
