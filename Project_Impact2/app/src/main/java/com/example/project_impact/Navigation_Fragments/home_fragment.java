package com.example.project_impact.Navigation_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.project_impact.R;

import java.util.ArrayList;
import java.util.List;

import xute.storyview.StoryModel;
import xute.storyview.StoryView;


public class home_fragment extends Fragment {
    StoryView storyView;
    StoryView storyView2;
    RecyclerView vrv_recycler;
    RecyclerView story_review;
    ArrayList<story_model> Story_model_al;
    List<vrv_data> items = new ArrayList<vrv_data>();



    public void story_handel(){

        int story_count = 0;
        int image_count = 0;

        for(int i = 0; i < story_count; i++){

            story_model s = new story_model(new StoryModel("url","name","time"), "name");
            if(image_count < 1) {
                for (int j = 0; j < image_count - 1; j++) {
                    s.add_extra_pages(new StoryModel("url", "name", "time"));
                }
            }
            Story_model_al.add(s);
        }
    }

    public void camp_handle(){
        int camp_count = 0;

        for(int i = 0; i < camp_count; i++){
            items.add(new vrv_data("name", "url"));
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        //////
        items.add(new vrv_data("hello","data:image/jpeg;base64,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"));
        items.add(new vrv_data("hello","https://i.pinimg.com/736x/97/d0/2a/97d02ad83bbf9161f2a4d73ff8b95195.jpg"));
        //////camp_login()

        vrv_recycler=  view.findViewById(R.id.volunteer_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        vrv_recycler.setLayoutManager(layoutManager);
        vrv_recycler.setAdapter(new vrv_Adapter(getContext(),items));

        story_review = (RecyclerView) view.findViewById(R.id.story_review);
        LinearLayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        story_review.setLayoutManager(layout);
        Story_model_al = new ArrayList<>();
        ///// ca


        //////
        story_model sm1 = new story_model(new StoryModel("https://www.newshub.co.nz/home/lifestyle/2019/08/the-top-five-cat-memes-of-all-time-rated/_jcr_content/par/video/image.dynimg.full.q75.jpg",
                "SAD GATO",
                "SAD GATO Hours"),"SAD GATO org");


        Story_model_al.add(sm1);
        /////story(handel)


        story_review.setAdapter(new story_adapter(Story_model_al));
        return view;
    }
}