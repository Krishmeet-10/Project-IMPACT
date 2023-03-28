package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class volunteerPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_password);
        Toast.makeText(this, "we're here", Toast.LENGTH_SHORT).show();
    }

//        public void createAccount(View view) {
//            Intent intent= new Intent(this, volunteerPassword.class);
//            startActivity(intent);
//        }
}