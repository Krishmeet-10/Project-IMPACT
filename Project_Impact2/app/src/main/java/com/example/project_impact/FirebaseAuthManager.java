package com.example.project_impact;


import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthManager {

    private static FirebaseAuth mAuth;

    private FirebaseAuthManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized FirebaseAuth getInstance() {
        if (mAuth == null) {
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }
}


