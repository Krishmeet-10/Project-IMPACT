package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class logInAs extends AppCompatActivity {
    String userType;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_as);
    }

    public void Volunteer(View view) {
        userType="v";
        Intent intent= new Intent(this, log_sign_in.class);
        //intent.putExtra("userType", userType);
        startActivity(intent);
    }

    public void Organization(View view) {
        userType="o";
        Intent intent2= new Intent(this, logInSignInOrganization.class);
        //intent.putExtra("userType", userType);
        startActivity(intent2);
    }

}
