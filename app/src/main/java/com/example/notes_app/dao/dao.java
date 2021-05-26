package com.example.notes_app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notes_app.entity.notes;

import java.util.List;

@Dao
public interface dao {

    @Query("SELECT * FROM notes_database")
    LiveData<List<notes>>getallnotes();

    @Query("SELECT * FROM notes_database ORDER BY notespriority DESC")
    LiveData<List<notes>>hightolow();


    @Query("SELECT * FROM notes_database ORDER BY notespriority ASC")
    LiveData<List<notes>>lowtohigh();

    @Insert
    public void insertnodes(notes notes);

    @Query("DELETE FROM notes_database WHERE id=:id")
    public void deletenode(int id);

    @Update
    public void updatenode(notes notes);
}
