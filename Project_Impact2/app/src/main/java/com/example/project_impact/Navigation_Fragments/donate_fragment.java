package com.example.project_impact.Navigation_Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.project_impact.R;
import com.example.project_impact.User_Landing_Page;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class donate_fragment extends Fragment implements PaymentResultListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_donate_fragment, container, false);

        Checkout.preload(getContext());

        Button btnPayNow = view.findViewById(R.id.donateButton);
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });

        return view;
    }
    public void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_tgE3Us5EWfozOi");

        User_Landing_Page donateFragment;

        //checkout.setImage(R.drawable.logo);
        try {
            JSONObject options = new JSONObject();
            options.put("name", "ABC Foundation");
            options.put("description", "Test payment");
            options.put("currency", "INR");
            options.put("amount", "1000");
           //  checkout.open(donateFragment, options);
        }

        catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getContext(), "Payment successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getContext(), "Payment error: " + s, Toast.LENGTH_SHORT).show();
    }

}