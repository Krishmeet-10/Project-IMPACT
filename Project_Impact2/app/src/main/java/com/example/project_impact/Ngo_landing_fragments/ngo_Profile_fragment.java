package com.example.project_impact.Ngo_landing_fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_impact.Navigation_Fragments.edit_popup;
import com.example.project_impact.Navigation_Fragments.user_settings;
import com.example.project_impact.R;


public class ngo_Profile_fragment extends Fragment {


    View top_view;
    ImageView user_pfp, edit_pfp, edit_email, edit_location, edit_job, edit_phone, app_settings;

    Button update;
    TextView user_email , user_name, user_location, user_job, user_phone;

    private static final int REQUEST_CODE_FOR_POPUP = 1;

    int SELECT_PICTURE = 200;
    TextView edit_place;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode ==REQUEST_CODE_FOR_POPUP){
                edit_place.setText(data.getStringExtra("data"));
            }

            else if(requestCode == SELECT_PICTURE){
                Uri selectedImageUri = data.getData();
                user_pfp.setImageURI(selectedImageUri);
            }

            update.setVisibility(top_view.VISIBLE);
            update.setEnabled(true);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        user_pfp = (ImageView) view.findViewById(R.id.user_pfp);
        user_email = (TextView) view.findViewById(R.id.user_email);
        user_job = (TextView) view.findViewById(R.id.user_job);
        user_name = (TextView) view.findViewById(R.id.user_name);
        user_location = (TextView) view.findViewById(R.id.user_location);
        user_phone = (TextView) view.findViewById(R.id.user_phone);

        edit_email = (ImageView) view.findViewById(R.id.edit_email);
        edit_job = (ImageView) view.findViewById(R.id.edit_job);
        edit_location = (ImageView) view.findViewById(R.id.edit_location);
        edit_pfp  = (ImageView) view.findViewById(R.id.edit_pfp);
        edit_phone = (ImageView) view.findViewById(R.id.edit_phone);
        app_settings = (ImageView) view.findViewById(R.id.app_settings_vol);

        update = (Button) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"click",Toast.LENGTH_SHORT).show();
            }
        });
        update.setVisibility(view.INVISIBLE);
        update.setEnabled(false);

        edit_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "location");
                bundle.putString("current", String.valueOf(user_location.getText()));
                edit_place = user_location;
                popup_action(bundle);
            }
        });



        app_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), user_settings.class);
                startActivity(intent);
            }
        });

        edit_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "job");
                bundle.putString("current", String.valueOf(user_job.getText()));
                edit_place = user_job;
                popup_action(bundle);
            }
        });


        edit_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "email");bundle.putString("current", String.valueOf(user_email.getText()));
                edit_place = user_email;
                popup_action(bundle);
            }
        });

        edit_pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        edit_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "phone");
                bundle.putString("current", String.valueOf(user_phone.getText()));
                edit_place = user_phone;
                popup_action(bundle);
            }
        });

        return view;
    }


    public void popup_action(Bundle bundle){

        Intent intent = new Intent(getActivity(), edit_popup.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE_FOR_POPUP);

    }

    public void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
}