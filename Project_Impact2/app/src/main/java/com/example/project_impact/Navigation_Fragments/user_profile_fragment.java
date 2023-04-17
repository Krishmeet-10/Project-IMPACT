package com.example.project_impact.Navigation_Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_impact.R;

import org.w3c.dom.Text;


public class user_profile_fragment extends Fragment {

    ImageView user_pfp, edit_pfp, edit_email, edit_location, edit_job, edit_phone;
    TextView user_email , user_name, user_location, user_job;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user_profile_fragment, container, false);

        user_pfp = (ImageView) view.findViewById(R.id.user_pfp);
        user_email = (TextView) view.findViewById(R.id.user_email);
        user_job = (TextView) view.findViewById(R.id.user_job);
        user_name = (TextView) view.findViewById(R.id.user_name);
        user_location = (TextView) view.findViewById(R.id.user_location);

        edit_email = (ImageView) view.findViewById(R.id.edit_email);
        edit_job = (ImageView) view.findViewById(R.id.edit_job);
        edit_location = (ImageView) view.findViewById(R.id.edit_location);
        edit_pfp  = (ImageView) view.findViewById(R.id.edit_pfp);
        edit_phone = (ImageView) view.findViewById(R.id.edit_phone);

        edit_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "location");
                popup_action();
            }
        });


        edit_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "job");
                popup_action();
            }
        });

        edit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "email");
                popup_action();
            }
        });


        edit_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "phone");
                popup_action();
            }
        });


        return view;
    }

    public void popup_action(){

        Intent intent = new Intent(getActivity(),edit_popup.class);
        startActivity(intent);

    }
}