package com.example.project_impact.Navigation_Fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_impact.R;

public class vrv_ViewHolder extends RecyclerView.ViewHolder {
    ImageView vrv_img;
    TextView vrv_text;

    public vrv_ViewHolder(@NonNull View itemView) {
        super(itemView);
        vrv_img = itemView.findViewById(R.id.imagevrv);
        vrv_text = itemView.findViewById(R.id.VolunteerText);
    }
}
