package com.example.project_impact.Navigation_Fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_impact.R;

import java.util.ArrayList;

import xute.storyview.StoryModel;
import xute.storyview.StoryView;




public class story_adapter extends  RecyclerView.Adapter<story_adapter.myViewHolder>{

    ArrayList<story_model> datalist;

    public story_adapter(ArrayList<story_model> data){
        this.datalist = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_unit,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull story_adapter.myViewHolder holder, int position) {

        holder.storyView.resetStoryVisits();
        holder.storyView.setImageUris(datalist.get(position).storyModels);
        holder.textView.setText(datalist.get(position).b_name);

    }


    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        StoryView storyView;
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            storyView = itemView.findViewById(R.id.storyView);
            textView = itemView.findViewById(R.id.bottom);

        }
    }
}
