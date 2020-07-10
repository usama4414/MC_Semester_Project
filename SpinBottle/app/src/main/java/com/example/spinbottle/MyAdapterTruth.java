package com.example.spinbottle;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterTruth extends RecyclerView.Adapter<MyAdapterTruth.ViewHolder> {
    SqlLiteDataBase db;
    private List<String> values;
    public MyAdapterTruth(List<String> myData, SqlLiteDataBase my_database)
    {
        values=myData;
        db=my_database;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.singleitem,parent,false);
        MyAdapterTruth.ViewHolder vh=new MyAdapterTruth.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final String name=values.get(position);
        holder.dareText.setText(name);
        if (position==0)
        {
            holder.deleteMe.setText("Fixed");
            holder.deleteMe.setBackgroundColor(Color.LTGRAY);
        }
        holder.deleteMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position!=0)
                {
                    remove(position);
                    db.deleteTruth(name);
                }
            }
        });
    }
    public void remove(int position)
    {
        values.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dareText;
        public TextView deleteMe;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dareText=(TextView)itemView.findViewById(R.id.dareText);
            deleteMe=(TextView)itemView.findViewById(R.id.deleteMe);
        }
    }
}
