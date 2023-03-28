package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class logInSignInOrganization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_sign_in_organization);
    }

    public void launchOSignUp(View view) {
        Intent intent=new Intent(this, organizationDetails.class);
        startActivity(intent);
    }

    public void launchOLogIn(View view) {
        Intent intent2=new Intent(this, OrganisationLogin.class);
        startActivity(intent2);
    }


}