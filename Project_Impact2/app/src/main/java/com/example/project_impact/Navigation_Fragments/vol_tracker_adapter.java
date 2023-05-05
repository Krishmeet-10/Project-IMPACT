package com.example.project_impact.Navigation_Fragments;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_impact.R;

import java.util.ArrayList;

public class vol_tracker_adapter extends RecyclerView.Adapter<vol_tracker_adapter.myviewhlder> {

    ArrayList<model_vol_tracker> tracker_dataholder;

    public vol_tracker_adapter(ArrayList<model_vol_tracker> tracker_dataholder) {
        this.tracker_dataholder = tracker_dataholder;
    }

    @NonNull
    @Override
    public myviewhlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vol_tracker_unit, parent, false);
        return new myviewhlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewhlder holder, int position) {
        holder.tracker_title.setText(tracker_dataholder.get(position).title);
        holder.tracker_org.setText(tracker_dataholder.get(position).org);
        holder.tracker_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tracker_dataholder.size();
    }

    class myviewhlder extends RecyclerView.ViewHolder{

        TextView tracker_org, tracker_title;
        CardView tracker_card;

        public myviewhlder(@NonNull View itemView) {
            super(itemView);
            tracker_org = (TextView) itemView.findViewById(R.id.vol_tracker_org);
            tracker_title = (TextView) itemView.findViewById(R.id.vol_tracker_title);
            tracker_card = (CardView) itemView.findViewById(R.id.vol_tracker_card);

        }
    }
}
