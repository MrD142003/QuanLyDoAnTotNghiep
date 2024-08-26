package com.example.myprojects.bottomnav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myprojects.DataClass;
import com.example.myprojects.R;
import com.example.myprojects.adapter.HomeAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recHome;
    private ArrayList<DataClass> homeArrayList;
    private String[] taskTitle, taskTime;
    private int[] imageResourceID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInit();
        recHome = view.findViewById(R.id.recycleViewHome);
        recHome.setLayoutManager(new LinearLayoutManager(getContext()));
        recHome.setHasFixedSize(true);
        HomeAdapter homeAdapter = new HomeAdapter(getContext(), homeArrayList);
        recHome.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

    }

    private void dataInit() {
        homeArrayList = new ArrayList<>();

        taskTitle = new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),
                getString(R.string.head_4),
                getString(R.string.head_5),
                getString(R.string.head_6),

        };

        taskTime = new String[]{
                getString(R.string.time_1),
                getString(R.string.time_2),
                getString(R.string.time_3),
                getString(R.string.time_4),
                getString(R.string.time_4),
                getString(R.string.time_4),
        };

        imageResourceID = new int[]{
                R.drawable.news,
                R.drawable.news,
                R.drawable.news,
                R.drawable.news,
                R.drawable.news,
                R.drawable.news
        };

        for (int i = 0; i < taskTitle.length; i++){
            DataClass dataClass = new DataClass(taskTitle[i], taskTime[i], imageResourceID[i]);
            homeArrayList.add(dataClass);
        }
    }

}