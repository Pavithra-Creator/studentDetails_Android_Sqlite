package com.example.studentinfo;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder> {

    Context context;
    List<StudentModel> studentModels;

    public RecyclerAdapter(Context context, List<StudentModel> studentModels) {
        this.context = context;
        this.studentModels = studentModels;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.list_info, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.studnet_idd.setText("Student ID - "+studentModels.get(position).getStudent_id());
        holder.tm1.setText("Mark-1 = "+studentModels.get(position).getM1());
        holder.tm2.setText("Mark-2 = "+studentModels.get(position).getM2());
        holder.tm3.setText("Mark-3 = "+studentModels.get(position).getM3());
    }

    @Override
    public int getItemCount() {
        return studentModels.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView studnet_idd, tm1, tm2, tm3;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            studnet_idd = itemView.findViewById(R.id.txtStuid);
            tm1 = itemView.findViewById(R.id.txtm1);
            tm2 = itemView.findViewById(R.id.txtm2);
            tm3 = itemView.findViewById(R.id.txtm3);
        }
    }
}
