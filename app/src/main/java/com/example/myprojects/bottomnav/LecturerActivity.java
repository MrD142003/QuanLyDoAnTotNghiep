package com.example.myprojects.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.myprojects.HelperClass;
import com.example.myprojects.R;
import com.example.myprojects.adapter.GiangVienAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LecturerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    GiangVienAdapter adapter;
    ArrayList<HelperClass> list;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);

        recyclerView = findViewById(R.id.user_recycle_view);
        database = FirebaseDatabase.getInstance().getReference("users");
        btnBack = findViewById(R.id.back_btn);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new GiangVienAdapter(this, list);
        recyclerView.setAdapter(adapter);

        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    HelperClass user = dataSnapshot.getValue(HelperClass.class);
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}