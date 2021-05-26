package com.example.notes_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.notes_app.entity.notes;
import com.example.notes_app.viewmodel.viewmodel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class insertnode_activity extends AppCompatActivity {

    EditText title,subtitle,notesdata;
    FloatingActionButton done;
    viewmodel notesviewmodel;
    notes no;
    ImageView green,orange,red;
    String priority="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertnode);

        notesviewmodel=new ViewModelProvider(this).get(viewmodel.class);
        notesviewmodel.init(this.getApplication());

        title=(EditText)findViewById(R.id.title);
        subtitle=(EditText)findViewById(R.id.subtitle);
        notesdata=(EditText)findViewById(R.id.notes);

        done=(FloatingActionButton) findViewById(R.id.donebutton);

        green=(ImageView)findViewById(R.id.green);
        orange=(ImageView)findViewById(R.id.oragne);
        red=(ImageView)findViewById(R.id.red);

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                green.setImageResource(R.drawable.ic_baseline_done_24);
                orange.setImageResource(0);
                red.setImageResource(0);
                priority="1";
            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orange.setImageResource(R.drawable.ic_baseline_done_24);
                green.setImageResource(0);
                red.setImageResource(0);
                priority="2";
            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red.setImageResource(R.drawable.ic_baseline_done_24);
                orange.setImageResource(0);
                green.setImageResource(0);
                priority="3";
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createnote();
                Toast.makeText(insertnode_activity.this, "Your Note is Created ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void createnote() {

        String notestitles=title.getText().toString();
        String notessubtitles=subtitle.getText().toString();
        String notess=notesdata.getText().toString();

        no=new notes();
        Calendar calendar=Calendar.getInstance();
        String currcurrent=DateFormat.getDateInstance().format(calendar.getTime());

        no.notestitle=notestitles;
        no.notessubtitle=notessubtitles;
        no.notesdata=notess;
        no.notesdate=currcurrent;
        no.notespriority=priority;

        notesviewmodel.insertnote(no);

    }
}