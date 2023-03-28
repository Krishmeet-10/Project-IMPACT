package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class volunteerLogInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_log_in_page);
    }

    public void homepage(View view) {
        Intent intent = new Intent(this,User_Landing_Page.class);
        startActivity(intent);
    }
}