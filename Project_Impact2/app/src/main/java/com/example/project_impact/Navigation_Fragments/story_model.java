package com.example.project_impact.Navigation_Fragments;
import java.util.ArrayList;

import xute.storyview.StoryModel;



public class story_model {

    public String b_name;
    public ArrayList<StoryModel> storyModels = new ArrayList<>();

    public  story_model(StoryModel storymodel, String _b_name){

        b_name = _b_name;

        storyModels.add(storymodel);
    }

    public void add_extra_pages(StoryModel storymodel){
        storyModels.add(storymodel);
    }


}
