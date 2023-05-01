package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          mFirebaseAuth= FirebaseAuthManager.getInstance();


    }

    public void loadUser(){
        Intent intent=new Intent(this,User_Landing_Page.class);
        startActivity(intent);
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this, logInAs.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mFirebaseAuth.getCurrentUser();
if(currentUser != null){
loadUser();
}
    }
}

