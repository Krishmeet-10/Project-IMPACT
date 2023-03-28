package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class log_sign_in extends AppCompatActivity {
    String userType;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_sign_in);
//        String value = getIntent().getStringExtra("userValue");
//        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        textView=findViewById(R.id.userOutput);
        //textView.setText(value);
    }

    public void launchVInput(View view){
        Intent intent2= new Intent(this, volunteerDetails.class);
        startActivity(intent2);
    }

    public void logInVolunteer(View view) {
        Intent intent3= new Intent(this, volunteerLogInPage.class);
        startActivity(intent3);
    }


}