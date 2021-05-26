package com.example.notes_app.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notes_app.MainActivity;
import com.example.notes_app.R;
import com.example.notes_app.entity.notes;
import com.example.notes_app.updatenode_activity;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {


    MainActivity mainActivity;
    List<notes> notes;

    public adapter(MainActivity mainActivity, List<notes> notes) {
        this.mainActivity = mainActivity;
        this.notes = notes;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new viewholder(LayoutInflater.from(mainActivity).inflate(R.layout.single_row, parent, false));
    }

    @Override
    public void onBindViewHolder(adapter.viewholder holder, int position) {



        holder.title.setText(notes.get(position).notestitle);
        holder.subtitle.setText(notes.get(position).notessubtitle);
        holder.notesdate.setText(notes.get(position).notesdate);

        if(notes.get(position).notespriority.equals("1"))
        {
            holder.notespriority.setBackgroundResource(R.drawable.green_shape);
        }

        else if(notes.get(position).notespriority.equals("2"))
        {
            holder.notespriority.setBackgroundResource(R.drawable.orange_shape);
        }

        else
        {
            holder.notespriority.setBackgroundResource(R.drawable.red_shaoe);
        }

        notes no= notes.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mainActivity, updatenode_activity.class);

                intent.putExtra("id",no.id);
                intent.putExtra("title",no.notestitle);
                intent.putExtra("subtitle",no.notessubtitle);
                intent.putExtra("priority",no.notespriority);
                intent.putExtra("notes",no.notesdata);

                mainActivity.startActivity(intent);

            }

        });
    }


    @Override
    public int getItemCount() {

        return notes.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        TextView title, subtitle, notesdate;
        ImageView notespriority;

        public viewholder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.notestitle);
            subtitle = (TextView) itemView.findViewById(R.id.notessubtitle);
            notesdate = (TextView) itemView.findViewById(R.id.notesdate);
            notespriority=(ImageView)itemView.findViewById(R.id.notespriority);
        }
    }

}
