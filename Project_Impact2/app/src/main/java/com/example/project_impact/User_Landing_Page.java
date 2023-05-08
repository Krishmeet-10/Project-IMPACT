package com.example.project_impact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.project_impact.Navigation_Fragments.donate_fragment;
import com.example.project_impact.Navigation_Fragments.home_fragment;
import com.example.project_impact.Navigation_Fragments.search_fragment;
import com.example.project_impact.Navigation_Fragments.user_profile_fragment;
import com.example.project_impact.Navigation_Fragments.volunteer_User_Fragment;
import com.example.project_impact.databinding.ActivityUserLandingPageBinding;

public class User_Landing_Page extends AppCompatActivity {

    ActivityUserLandingPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ChangeFragment(new home_fragment());

        binding.bottomMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home_icon:
                    ChangeFragment(new home_fragment());
                    break;

                case R.id.Search_icon:
                    ChangeFragment(new search_fragment());
                    break;

                case R.id.Donate_icon:
                    ChangeFragment(new donate_fragment());
                    break;

                case R.id.Volunteer_icon:
                    ChangeFragment(new volunteer_User_Fragment());
                    break;

                case R.id.Profile_icon:
                    ChangeFragment(new user_profile_fragment());
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

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }
}