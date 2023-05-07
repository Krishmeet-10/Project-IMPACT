package com.example.project_impact.Navigation_Fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.project_impact.R;

public class activity_campinfo extends AppCompatActivity {

    TextView title, description, org;
    ImageView cover;
    Button join;


    public void setting(){
        title.setText("");
        org.setText("");
        description.setText("");
        Glide.with(this).load("").into(cover);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campinfo);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.desc);
        cover = (ImageView) findViewById(R.id.cover);
        org = (TextView) findViewById(R.id.org);
        join = (Button) findViewById(R.id.join);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
