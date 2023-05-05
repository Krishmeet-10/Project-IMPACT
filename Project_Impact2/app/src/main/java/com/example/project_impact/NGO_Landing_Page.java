package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project_impact.Ngo_landing_fragments.ngo_Campaign_fragment;
import com.example.project_impact.Ngo_landing_fragments.ngo_Donation_fragment;
import com.example.project_impact.Ngo_landing_fragments.ngo_Home_fragment;
import com.example.project_impact.Ngo_landing_fragments.ngo_Profile_fragment;
import com.example.project_impact.databinding.ActivityNgoLandingPageBinding;

public class NGO_Landing_Page extends AppCompatActivity {

    ActivityNgoLandingPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityNgoLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ChangeFragment(new ngo_Home_fragment());

        binding.bnv.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home_ngo:
                    ChangeFragment(new ngo_Home_fragment());
                    break;
                case R.id.settings_ngo:
                    ChangeFragment(new ngo_Profile_fragment());
                    break;
                case R.id.donation_ngo:
                    ChangeFragment(new ngo_Donation_fragment());
                    break;
                case R.id.campaign_ngo:
                    ChangeFragment(new ngo_Campaign_fragment());
                    break;
            }

            return true;
        });
    }

    public void ChangeFragment(Fragment fragment){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout3, fragment);
        fragmentTransaction.commit();

    }
}