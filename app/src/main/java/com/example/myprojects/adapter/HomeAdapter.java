package com.example.myprojects.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myprojects.DataClass;
import com.example.myprojects.R;
import com.example.myprojects.TaskActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<DataClass> dataList;

    public HomeAdapter(Context context, ArrayList<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataClass dataClass = dataList.get(position);

        holder.imageTask.setImageResource(dataClass.getImage());
        holder.txtTitleTask.setText(dataClass.getTitle());
        holder.txtTimeTask.setText(dataClass.getTime());

        holder.cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TaskActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("Time", dataList.get(holder.getAdapterPosition()).getTime());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageTask;
        TextView txtTitleTask, txtTimeTask;
        CardView cardHome;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            imageTask = itemView.findViewById(R.id.imageTask);
            txtTitleTask = itemView.findViewById(R.id.txtTitleTask);
            txtTimeTask = itemView.findViewById(R.id.txtTimeTask);
            cardHome = itemView.findViewById(R.id.cardHome);
        }
    }
}


