package com.example.project_impact.Ngo_landing_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_impact.Navigation_Fragments.ngo_campagin_adapter;
import com.example.project_impact.Navigation_Fragments.vrv_Adapter;
import com.example.project_impact.Navigation_Fragments.vrv_data;
import com.example.project_impact.R;

import java.util.ArrayList;
import java.util.List;


public class ngo_Campaign_fragment extends Fragment {


    RecyclerView vrv_recycler;
    List<vrv_data> camp_dataholder = new ArrayList<vrv_data>();

    public void camp_handle(int size, ArrayList<String> title, ArrayList<String> url , ArrayList<String> discp){
        int camp_count = size;

        for(int i = 0; i < camp_count; i++){
            camp_dataholder.add(new vrv_data(title.get(i), url.get(i), discp.get(i)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_campaign_fragment, container, false);
        vrv_recycler = view.findViewById(R.id.volunteer_rv_ngo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        vrv_recycler.setLayoutManager(layoutManager);
        vrv_recycler.setAdapter(new ngo_campagin_adapter(getContext(),camp_dataholder));
        return view;
    }
}