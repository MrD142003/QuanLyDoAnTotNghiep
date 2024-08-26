package com.example.myprojects.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myprojects.HelperClass;
import com.example.myprojects.R;

import java.util.ArrayList;

public class GiangVienAdapter extends RecyclerView.Adapter<GiangVienAdapter.MyViewHolder> {

    Context context;
    ArrayList<HelperClass> list;

    public GiangVienAdapter(Context context, ArrayList<HelperClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.search_user_recycler_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HelperClass user = list.get(position);
        holder.txtUsername.setText(user.getUsername());
        holder.txtEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtUsername, txtEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtUsername = itemView.findViewById(R.id.username_text);
            txtEmail = itemView.findViewById(R.id.email_text);
        }
    }
}
