package com.example.project_impact.Ngo_landing_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.project_impact.Navigation_Fragments.vrv_Adapter;
import com.example.project_impact.Navigation_Fragments.vrv_data;
import com.example.project_impact.R;
import com.example.project_impact.ngo_volunteer_campaign_creation;

import java.util.ArrayList;
import java.util.List;

public class ngo_Home_fragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    RecyclerView vrv_recycler;
    List<vrv_data> items = new ArrayList<vrv_data>();

    Button new_camp_btn ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {

        View view = inflater.inflate(R.layout.fragment_home_fragment2, container, false);

        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));

        vrv_recycler = view.findViewById(R.id.volunteer_rv_ngo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        vrv_recycler.setLayoutManager(layoutManager);
        vrv_recycler.setAdapter(new vrv_Adapter(getContext(),items));

        new_camp_btn = view.findViewById(R.id.cncbutton);
        new_camp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gen_popup(view);
            }
        });
        return view;
    }

    public void gen_popup(View view) {
        PopupMenu popup = new PopupMenu(getContext(), view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.campaign_pop_up_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.volun_option:
                Toast.makeText(getContext(), "volun click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ngo_volunteer_campaign_creation.class);
                startActivity(intent);
                return true;
            case R.id.donation_option:
                Toast.makeText(getContext(), "don click", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }




}