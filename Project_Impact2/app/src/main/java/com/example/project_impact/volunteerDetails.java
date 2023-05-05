package com.example.project_impact;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        FirebaseAuth mAuth=FirebaseAuthManager.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if (currentUser!=null){
            String uerId=currentUser.getUid();
            DatabaseReference usersRef= FirebaseDatabase.getInstance().getReference("users");
            Map<String,String> user=new HashMap<>();
            user.put("volName",volName);
            user.put("volAge",volAge);
            user.put("volPhone",volPhone);
            user.put("volType",volType);
usersRef.child(userId).setValue(user);

        }
    }
}

