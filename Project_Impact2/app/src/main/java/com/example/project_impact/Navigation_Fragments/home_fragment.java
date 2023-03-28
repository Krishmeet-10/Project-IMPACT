package com.example.project_impact.Navigation_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_impact.R;

import java.util.ArrayList;
import java.util.List;

import xute.storyview.StoryModel;
import xute.storyview.StoryView;


public class home_fragment extends Fragment {
    StoryView storyView;
    StoryView storyView2;
    RecyclerView vrv_recycler;

    List<vrv_data> items = new ArrayList<vrv_data>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));
        items.add(new vrv_data("hello",R.drawable.support_2355701_1920));


        vrv_recycler=  view.findViewById(R.id.volunteer_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        vrv_recycler.setLayoutManager(layoutManager);
        vrv_recycler.setAdapter(new vrv_Adapter(getContext(),items));

        storyView = (StoryView) view.findViewById(R.id.storyview);
        storyView2 = (StoryView) view.findViewById(R.id.storyview2);
        storyView.resetStoryVisits();

        ArrayList<StoryModel> storyModels = new ArrayList<>();

        storyModels.add(new StoryModel("https://cdn.pixabay.com/photo/2020/01/04/21/51/feeding-baby-elephants-4741820_960_720.jpg","NAME","TIME"));
        storyModels.add(new StoryModel("https://cdn.pixabay.com/photo/2016/03/18/15/21/help-1265227_960_720.jpg","NAME","TIME"));

        storyView.setImageUris(storyModels);

        ArrayList<StoryModel> storyModels2 = new ArrayList<>();

        storyModels2.add(new StoryModel("https://cdn.pixabay.com/photo/2020/01/04/21/51/feeding-baby-elephants-4741820_960_720.jpg","NAME","TIME"));
        storyModels2.add(new StoryModel("https://cdn.pixabay.com/photo/2016/03/18/15/21/help-1265227_960_720.jpg","NAME","TIME"));

        storyView2.setImageUris(storyModels2);
        return view;
    }
}