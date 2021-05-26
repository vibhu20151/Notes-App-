package com.example.notes_app.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.notes_app.entity.notes;
import com.example.notes_app.repository.repository;

import java.util.List;

public class viewmodel extends ViewModel {


    public repository noterepository;
    public LiveData<List<notes>> getallnodes;
    public LiveData<List<notes>> hightolow;
    public LiveData<List<notes>> lowtohigh;


    public void init(Application application)
    {
        noterepository = new repository(application);
        getallnodes = noterepository.getallnodes;
        hightolow=noterepository.hightolow;
        lowtohigh=noterepository.lowtohigh;

    }

    public void insertnote(notes notes) {
        noterepository.insertnodes(notes);
    }

    public void deletenote(int id) {
        noterepository.deletenode(id);
    }

    public void updatenotes(notes notes) {
        noterepository.updatenodes(notes);
    }
}
