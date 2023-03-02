package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SQLAdapter extends RecyclerView.Adapter<SQLAdapter.MyViewHolder> {
    ArrayList<ModelClass> userdata;
    Context context;

    public SQLAdapter(ArrayList<ModelClass> userdata,Context context) {
        this.context=context;
        this.userdata=userdata;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sql_adapter,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass recylerModel = userdata.get(position);
        holder.nametxt.setText(recylerModel.getName());
        holder.surnametxt.setText(recylerModel.getSurname());
        holder.markstxt.setText((recylerModel.getMarks()));
        holder.idtxt.setText(recylerModel.getId());

//        if(recylerModel.getId().equals("1"))
//        {
//            holder.name.setVisibility(View.VISIBLE);
//        }
//        else {
//            holder.name.setVisibility(View.GONE);
//        }

    }



    @Override
    public int getItemCount() {
        return userdata.size();
    }





    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametxt,surnametxt,markstxt,idtxt;
        public MyViewHolder(View itemview) {
            super(itemview);
            nametxt=itemView.findViewById(R.id.nameadapter);
            surnametxt=itemView.findViewById(R.id.surnameadapter);
            markstxt=itemView.findViewById(R.id.marksadapter);
            idtxt=itemView.findViewById(R.id.idadapter);
        }
    }
}
