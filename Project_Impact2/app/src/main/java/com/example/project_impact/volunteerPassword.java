package com.example.project_impact;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class volunteerPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_password);
EditText editEmail=findViewById(R.id.editText8);
       EditText editPass=findViewById(R.id.editText10);
       EditText editConPass=findViewById(R.id.editText9);
       Button submitButton=findViewById(R.id.volunPass);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editEmail.getText().toString().trim();
                String password=editPass.getText().toString().trim();
                String rePassword=editConPass.getText().toString().trim();
                if (email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
    Toast.makeText(getApplicationContext(),"Alert, all fields are mandatory.",Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals(rePassword)){
                    Toast.makeText(getApplicationContext(),"Alert, Passwords do not match. Please try again.",Toast.LENGTH_SHORT).show();
                }
                else if (password.length()<8){
                    Toast.makeText(getApplicationContext(),"Alert, password must be 8 characters long",Toast.LENGTH_SHORT).show();
                }
else {
createAccount(email,password);
                }
            }
        });
    }

        public void createAccount(String email, String password) {
            FirebaseAuth mAuth=FirebaseAuthManager.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                Intent volIntent=getIntent();
                                String[] volData=volIntent.getStringArrayExtra("volData");
                                    String uerId=currentUser.getUid();
                                    DatabaseReference usersRef= FirebaseDatabase.getInstance().getReference("users");
                                    Map<String,String> user=new HashMap<>();
                                    user.put("volName",volData[0]);
                                    user.put("volAge",volData[1]);
                                    user.put("volPhone",volData[2]);
                                    user.put("volType",volData[3]);
                                    usersRef.child(uerId).setValue(user);
Intent intent=new Intent(getApplicationContext(),User_Landing_Page.class);
intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            } else {
                                Log.i(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(),"Authentication failed! \n Please try again.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
}

