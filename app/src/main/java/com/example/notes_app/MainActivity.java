package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.notes_app.adapter.adapter;
import com.example.notes_app.entity.notes;
import com.example.notes_app.viewmodel.viewmodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton newnodebutton;
    RecyclerView rcview;
    adapter adapter;
    viewmodel notesviewmodel;
    TextView nofilter, hightolow, lowtohigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nofilter = (TextView) findViewById(R.id.nofiler);
        hightolow = (TextView) findViewById(R.id.hightolow);
        lowtohigh = (TextView) findViewById(R.id.lowtohigh);

        nofilter.setBackgroundResource(R.drawable.selected_filter);

        nofilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nofilter.setBackgroundResource(R.drawable.selected_filter);
                hightolow.setBackgroundResource(R.drawable.filter_edit);
                lowtohigh.setBackgroundResource(R.drawable.filter_edit);
                loaddata(0);

            }
        });
        hightolow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hightolow.setBackgroundResource(R.drawable.selected_filter);
                nofilter.setBackgroundResource(R.drawable.filter_edit);
                lowtohigh.setBackgroundResource(R.drawable.filter_edit);
                loaddata(1);

            }
        });
        lowtohigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lowtohigh.setBackgroundResource(R.drawable.selected_filter);
                nofilter.setBackgroundResource(R.drawable.filter_edit);
                hightolow.setBackgroundResource(R.drawable.filter_edit);
                loaddata(2);

            }
        });


        rcview = (RecyclerView) findViewById(R.id.rcview);
        notesviewmodel = new ViewModelProvider(this).get(viewmodel.class);
        notesviewmodel.init(this.getApplication());
        newnodebutton = (FloatingActionButton) findViewById(R.id.newnodebutton);

        newnodebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, insertnode_activity.class));
            }
        });

        notesviewmodel.getallnodes.observe(this, new Observer<List<notes>>() {
            @Override
            public void onChanged(List<notes> notes) {
                setadapete(notes);
            }
        });
    }

    public void setadapete(List<notes> notes) {

        rcview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter = new adapter(MainActivity.this, notes);
        rcview.setAdapter(adapter);

    }

    private void loaddata(int i) {
        if(i==0)
        {
        notesviewmodel.getallnodes.observe(this, new Observer<List<notes>>() {
            @Override
            public void onChanged(List<notes> notes) {
                setadapete(notes);
            }
        });
    }else if(i==1)
        {
            notesviewmodel.hightolow.observe(this, new Observer<List<notes>>() {
                @Override
                public void onChanged(List<notes> notes) {
                    setadapete(notes);
                }
            });
        }
        else
        {
            notesviewmodel.lowtohigh.observe(this, new Observer<List<notes>>() {
                @Override
                public void onChanged(List<notes> notes) {
                    setadapete(notes);
                }
            });
        }
}

}