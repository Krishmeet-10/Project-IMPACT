package com.example.project_impact.Navigation_Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_impact.FirebaseAuthManager;
import com.example.project_impact.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class user_profile_fragment extends Fragment {

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
        View view =  inflater.inflate(R.layout.fragment_user_profile_fragment, container, false);

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

        edit_pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        app_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),user_settings.class);
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

        top_view = view;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user_email=view.findViewById(R.id.user_email);
        user_name=view.findViewById(R.id.user_name);
        user_location=view.findViewById(R.id.user_location);
        user_job=view.findViewById(R.id.user_job);
        user_phone=view.findViewById(R.id.user_phone);

        FirebaseAuth mAuth= FirebaseAuthManager.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String userId = currentUser.getUid();
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists() && snapshot.hasChildren()) {
                    String volName = snapshot.child("volName").getValue(String.class);
                    String volAge = snapshot.child("volAge").getValue(String.class);
                    String volPhone = snapshot.child("volPhone").getValue(String.class);
                    String volType = snapshot.child("volType").getValue(String.class);
                    String volEmail=currentUser.getEmail().toString();
                    System.out.println(volEmail+" "+volName+" "+volAge+" "+volType+" "+volName);
                    user_email.setText(volEmail);
                    user_name.setText(volName);
                    user_location.setText(volAge);
                    user_phone.setText(volPhone);
                    user_job.setText(volType);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the error
            }
        });

    }
}

