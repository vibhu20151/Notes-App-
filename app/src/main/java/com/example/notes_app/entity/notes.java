package com.example.notes_app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_database")
public class notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="notestitle")
    public String notestitle;

    @ColumnInfo(name="notessubtitle")
    public String notessubtitle;

    @ColumnInfo(name="notesdata")
    public String notesdata;

    @ColumnInfo(name="notesdate")
    public String notesdate;

    @ColumnInfo(name="notespriority")
    public String notespriority;

}
