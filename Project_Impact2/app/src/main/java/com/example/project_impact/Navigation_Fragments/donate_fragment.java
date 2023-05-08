package com.example.project_impact.Navigation_Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.project_impact.R;

public class donate_fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_donate_fragment, container, false);
        return view;
    }

    public void rzr_pay_launch(View view) {
        Intent intent = new Intent(getContext(), Razorpay_passthrough.class);
        startActivity(intent);
    }
}