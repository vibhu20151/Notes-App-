package com.example.notes_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notes_app.entity.notes;
import com.example.notes_app.viewmodel.viewmodel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

public class updatenode_activity extends AppCompatActivity {

    TextView uptitle,upsubtitle,upnote;
    ImageView upgreen,uporange,upred;
    String priority;
    String stitle,ssubtitle,spriority,snotes;
    int sid;
    FloatingActionButton updatebott;
    viewmodel notesviewmodel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatenode);


        stitle=getIntent().getStringExtra("title");
        sid=getIntent().getIntExtra("id",0);
        ssubtitle=getIntent().getStringExtra("subtitle");
        spriority=getIntent().getStringExtra("priority");
        snotes=getIntent().getStringExtra("notes");

        notesviewmodel=new ViewModelProvider(this).get(viewmodel.class);
        notesviewmodel.init(this.getApplication());

        updatebott=(FloatingActionButton)findViewById(R.id.updatebutton);


        uptitle=(TextView)findViewById(R.id.uptitle);
        upsubtitle=(TextView)findViewById(R.id.upsubtitle);
        upnote=(TextView)findViewById(R.id.upnotes);
        upgreen=(ImageView)findViewById(R.id.upgreen);
        uporange=(ImageView)findViewById(R.id.uporange);
        upred=(ImageView)findViewById(R.id.upred);

        if(spriority.equals("1"))
        {
            upgreen.setImageResource(R.drawable.ic_baseline_done_24);
            uporange.setImageResource(0);
            upred.setImageResource(0);
            priority="2";
        }
        else if (spriority.equals("2"))
        {
            uporange.setImageResource(R.drawable.ic_baseline_done_24);
            upgreen.setImageResource(0);
            upred.setImageResource(0);
            priority="2";
        }
        else
        {
            upred.setImageResource(R.drawable.ic_baseline_done_24);
            uporange.setImageResource(0);
            upgreen.setImageResource(0);
            priority="3";
        }

        upgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upgreen.setImageResource(R.drawable.ic_baseline_done_24);
                uporange.setImageResource(0);
                upred.setImageResource(0);
                priority="1";
            }
        });

        uporange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uporange.setImageResource(R.drawable.ic_baseline_done_24);
                upgreen.setImageResource(0);
                upred.setImageResource(0);
                priority="2";
            }
        });

        upred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upred.setImageResource(R.drawable.ic_baseline_done_24);
                uporange.setImageResource(0);
                upgreen.setImageResource(0);
                priority="3";
            }
        });

        uptitle.setText(stitle);
        upsubtitle.setText(ssubtitle);
        upnote.setText(snotes);

        updatebott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatenotes();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.delete_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.notesdelete)
        {
            BottomSheetDialog sheetDialog=new BottomSheetDialog(updatenode_activity.this);

            View view= LayoutInflater.from(updatenode_activity.this)
                .inflate(R.layout.delete_bottom,(LinearLayout)findViewById(R.id.bottom_delete));

            sheetDialog.setContentView(view);

            TextView yes,no;

            yes=view.findViewById(R.id.delete_yes);
            no=view.findViewById(R.id.delete_no);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notesviewmodel.deletenote(sid);
                    finish();
                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sheetDialog.dismiss();
                }
            });

            sheetDialog.show();


        }
        return true;
    }

    private void updatenotes() {

        String title=uptitle.getText().toString();
        String subtitle=upsubtitle.getText().toString();
        String notes=upnote.getText().toString();

        Calendar calendar=Calendar.getInstance();
        String currcurrent= DateFormat.getDateInstance().format(calendar.getTime());

        com.example.notes_app.entity.notes notesss=new notes();
        notesss.id=sid;
        notesss.notestitle=title;
        notesss.notessubtitle=subtitle;
        notesss.notesdata=notes;
        notesss.notesdate=currcurrent;
        notesss.notespriority=priority;

        notesviewmodel.updatenotes(notesss);




        Toast.makeText(updatenode_activity.this, "Your Note is Updated ", Toast.LENGTH_SHORT).show();
        finish();

    }


    
}