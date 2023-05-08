package com.example.project_impact.Navigation_Fragments;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project_impact.R;
import com.example.project_impact.User_Landing_Page;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Razorpay_passthrough extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razorpay_passthrough);

        Checkout.preload(this);

        startPayment();
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment error: " + s, Toast.LENGTH_SHORT).show();
    }
    public void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_tgE3Us5EWfozOi");

        Razorpay_passthrough donateFragment;

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

}