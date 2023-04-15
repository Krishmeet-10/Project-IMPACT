package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class volunteerDetails extends AppCompatActivity {
    Button nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);

        nextActivity = findViewById(R.id.volunPass);
    }

    public void setNextActivity(View view){
        Intent intent = new Intent(this,volunteerPassword.class);
        startActivity(intent);
    }

}