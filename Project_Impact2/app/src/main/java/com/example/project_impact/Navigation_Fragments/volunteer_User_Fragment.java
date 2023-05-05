package com.example.project_impact.Navigation_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_impact.R;

import java.util.ArrayList;


public class volunteer_User_Fragment extends Fragment {

    RecyclerView volunteer_track_rv;
    ArrayList<model_vol_tracker> tracker_data_holder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volunteer__user_, container, false);
        volunteer_track_rv = (RecyclerView) view.findViewById(R.id.vol_track_rv);
        volunteer_track_rv.setLayoutManager(new LinearLayoutManager(getContext()));

        tracker_data_holder = new ArrayList<>();

        model_vol_tracker m1 = new model_vol_tracker("prog","org");
        model_vol_tracker m2 = new model_vol_tracker("prog2","org2");


        tracker_data_holder.add(m1);
        tracker_data_holder.add(m2);

        volunteer_track_rv.setAdapter(new vol_tracker_adapter(tracker_data_holder));

        return view;
    }
}