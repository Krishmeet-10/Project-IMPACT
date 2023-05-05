package com.example.project_impact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_impact.databinding.ActivityVolunteerPasswordBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class volunteerDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);
        EditText editVolName=findViewById(R.id.editVolName);
EditText editVolAge=findViewById(R.id.editVolAge);
EditText editVolPhone=findViewById(R.id.editVolPhone);
EditText editVolType=findViewById(R.id.editVolType);
        Button nextButton=findViewById(R.id.btnVolDetailsNext);

nextButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String volName=editVolName.getText().toString().trim();
        String volAge=editVolAge.getText().toString().trim();
        String volPhone=editVolPhone.getText().toString().trim();
        String volType=editVolType.getText().toString().trim();
        if (volName.isEmpty() || volAge.isEmpty() || volPhone.isEmpty() || volType.isEmpty()){
            Toast.makeText(getApplicationContext(),"Alert, all fields are mandatory.",Toast.LENGTH_SHORT).show();
        }
        else {
            setNextActivity(volName,volAge,volPhone,volType);
        }
    }
});
    }

    public void setNextActivity(String volName, String volAge, String volPhone, String volType){
        Intent intent = new Intent(getApplicationContext(), volunteerPassword.class);
        String[] volData={volName,volAge,volPhone,volType};
        intent.putExtra("volData",volData);
        startActivity(intent);
    }
}

