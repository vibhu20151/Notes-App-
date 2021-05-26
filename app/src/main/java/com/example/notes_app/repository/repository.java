package com.example.notes_app.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notes_app.dao.dao;
import com.example.notes_app.database.database;
import com.example.notes_app.entity.notes;

import java.util.List;

public class repository {


    public dao notesdoa;

    public LiveData<List<notes>>getallnodes;
    public LiveData<List<notes>>hightolow;
    public LiveData<List<notes>>lowtohigh;

    public  repository(Application application){
    database database= com.example.notes_app.database.database.getdatabaseInstace(application);
    notesdoa=database.dao();
    getallnodes=notesdoa.getallnotes();
    hightolow=notesdoa.hightolow();
    lowtohigh=notesdoa.lowtohigh();
}
public void insertnodes(notes notes)
{
    notesdoa.insertnodes(notes);
}
public void deletenode(int id)
{
    notesdoa.deletenode(id);
}
public void updatenodes(notes notes)
{
    notesdoa.updatenode(notes);
}

}
