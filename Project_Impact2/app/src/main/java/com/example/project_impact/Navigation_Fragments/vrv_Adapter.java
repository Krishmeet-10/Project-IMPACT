package com.example.project_impact.Navigation_Fragments;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_impact.R;
import com.example.project_impact.User_Landing_Page;

import java.util.List;

public class vrv_Adapter extends RecyclerView.Adapter<vrv_ViewHolder> {

    Context context;
    List<vrv_data> data;

    public vrv_Adapter(Context context, List<vrv_data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public vrv_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new vrv_ViewHolder(LayoutInflater.from(context).inflate(R.layout.volunteer_rv_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull vrv_ViewHolder holder, int position) {
        holder.vrv_text.setText(data.get(position).getName());
        Glide.with(context).load(data.get(position).getImage()).into(holder.vrv_img);

        holder.vrv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "CLICK LOGIC",Toast.LENGTH_SHORT).show();
                /* CLICK LOGIC*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}
