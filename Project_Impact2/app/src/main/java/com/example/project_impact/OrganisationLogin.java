package com.example.project_impact;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OrganisationLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_login);

        EditText editEmail=findViewById(R.id.emailOEditText2);
        EditText editPassword=findViewById(R.id.passwordOEditText2);
        Button submitButton=findViewById(R.id.orgLogInButton);
        Button forgotButton=findViewById(R.id.forgotOButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editEmail.getText().toString().trim();
                String password=editPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Alert, all fields are mandatory.",Toast.LENGTH_SHORT).show();
                }
                else{
                    homepage(email,password);
                }
            }
        });

        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OrganisationLogin.this);
                builder.setTitle("Forgot Password");
                builder.setMessage("Enter your email address:");
                final EditText input = new EditText(OrganisationLogin.this);
                input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                builder.setView(input);

                builder.setPositiveButton("Reset Password", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = input.getText().toString().trim();
                        FirebaseAuth mAuth=FirebaseAuthManager.getInstance();
                        if (email.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Email can't be empty!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mAuth.sendPasswordResetEmail(email)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(OrganisationLogin.this, "Password reset email sent", Toast.LENGTH_LONG).show();
                                            } else {
                                                Toast.makeText(OrganisationLogin.this, "Failed to send password reset email", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

    }

    public void homepage(String email,String password) {
        FirebaseAuth mAuth = FirebaseAuthManager.getInstance();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("LoginStatus", "signInWithEmail:success");
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    Intent intent = new Intent(getApplicationContext(), NGO_Landing_Page.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    Log.d("LoginFailure", "Could not login");
                    Toast.makeText(getApplicationContext(), "Authentication failed! \n Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

