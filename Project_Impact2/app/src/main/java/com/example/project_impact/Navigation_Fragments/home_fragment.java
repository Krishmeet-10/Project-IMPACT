package com.example.project_impact.Navigation_Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.project_impact.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

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

    public void camp_handle(int size, ArrayList<String> title, ArrayList<String> url , ArrayList<String> discp){
        int camp_count = size;

        for(int i = 0; i < camp_count; i++){
            items.add(new vrv_data(title.get(i), url.get(i), discp.get(i)));
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


        vrv_recycler=  view.findViewById(R.id.volunteer_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        vrv_recycler.setLayoutManager(layoutManager);
        vrv_recycler.setAdapter(new vrv_Adapter(getContext(),items));

        story_review = (RecyclerView) view.findViewById(R.id.story_review);
        LinearLayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        story_review.setLayoutManager(layout);
        Story_model_al = new ArrayList<>();
        ///// ca

        items.add(new vrv_data("title", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Paracas_National_Reserve%2C_Ica%2C_Peru-3April2011.jpg/1200px-Paracas_National_Reserve%2C_Ica%2C_Peru-3April2011.jpg", "clean the oceans"));
        items.add(new vrv_data("title","https://www.royalcaribbean.com/blog/wp-content/uploads/2021/06/iStock-1170804921-1650x1100.jpg", "save the sea"));
        //////
        story_model sm1 = new story_model(new StoryModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Shaqi_jrvej.jpg/1200px-Shaqi_jrvej.jpg",
                "Nature",
                "Nature"),"Nature");

        story_model sm2 = new story_model(new StoryModel("https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/w/o/WOPA160517_D056-resized.jpg?crop=864%2C0%2C1728%2C2304&wid=600&hei=800&scl=2.88",
                "Nature",
                "Nature"),"Nature");

        Story_model_al.add(sm2);
        Story_model_al.add(sm1);
        /////story(handel)


        story_review.setAdapter(new story_adapter(Story_model_al));
        return view;
    }


}