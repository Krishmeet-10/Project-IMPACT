package com.example.project_impact;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project_impact.Navigation_Fragments.Razorpay_passthrough;
import com.example.project_impact.Ngo_landing_fragments.ngo_Profile_fragment;

public class BankDetails_NGO extends AppCompatActivity {

    Button bankDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details_ngo);
        bankDetailsButton = findViewById(R.id.btn_org_bank_details_submit);

        bankDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BankDetails_NGO.this, ngo_Profile_fragment.class);
                startActivity(intent);
            }
        });
    }

}