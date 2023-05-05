package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrganisationLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_login);


    }

    public void homepage(View view) {
        Intent intent = new Intent(this,NGO_Landing_Page.class);
        startActivity(intent);
    }
}