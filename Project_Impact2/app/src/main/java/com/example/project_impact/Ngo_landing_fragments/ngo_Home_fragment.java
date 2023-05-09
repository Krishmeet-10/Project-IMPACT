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

    public void camp_handle(int size, ArrayList<String> title, ArrayList<String> url , ArrayList<String> discp){
        int camp_count = size;

        for(int i = 0; i < camp_count; i++){
            items.add(new vrv_data(title.get(i), url.get(i), discp.get(i)));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {

        View view = inflater.inflate(R.layout.fragment_home_fragment2, container, false);


        vrv_recycler = view.findViewById(R.id.volunteer_rv_ngo);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        items.add(new vrv_data("title", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Paracas_National_Reserve%2C_Ica%2C_Peru-3April2011.jpg/1200px-Paracas_National_Reserve%2C_Ica%2C_Peru-3April2011.jpg", "clean the oceans"));
        items.add(new vrv_data("title","https://www.royalcaribbean.com/blog/wp-content/uploads/2021/06/iStock-1170804921-1650x1100.jpg", "save the sea"));

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
                Intent intent = new Intent(getContext(), ngo_volunteer_campaign_creation.class);
                startActivity(intent);
                return true;
            case R.id.donation_option:
                Intent intent1 = new Intent(getContext(), ngo_volunteer_campaign_creation.class);
                startActivity(intent1);
                return true;
            default:
                return false;
        }
    }


}