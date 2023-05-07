package com.example.project_impact.Navigation_Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.project_impact.R;

public class activity_campinfo_ngo extends AppCompatActivity {

    TextView title, description, org;
    ImageView cover,edit_title, edit_cover, edit_desc;
    Button update, end_camp;

    TextView edit_place;
    private static final int REQUEST_CODE_FOR_POPUP = 1;
    int SELECT_PICTURE = 200;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode ==REQUEST_CODE_FOR_POPUP){
                edit_place.setText(data.getStringExtra("data"));
            }

            else if(requestCode == SELECT_PICTURE){
                Uri selectedImageUri = data.getData();
                cover.setImageURI(selectedImageUri);
            }

            update.setVisibility(View.VISIBLE);
            update.setEnabled(true);

        }
    }

    public void setting(){
        title.setText("");
        org.setText("");
        description.setText("");
        Glide.with(this).load("").into(cover);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campinfo_ngo);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.desc);
        cover = (ImageView) findViewById(R.id.cover);
        update = (Button) findViewById(R.id.update);
        end_camp = (Button) findViewById(R.id.end);
        edit_cover = (ImageView) findViewById(R.id.edit_cover);
        edit_title = (ImageView) findViewById(R.id.edit_title);
        edit_desc = (ImageView) findViewById(R.id.edit_desc);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        update.setVisibility(View.INVISIBLE);
        update.setEnabled(false);

        end_camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        edit_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "description");
                bundle.putString("current", String.valueOf(description.getText()));
                edit_place = description;
                popup_action(bundle);
            }
        });


        edit_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key", "title");
                bundle.putString("current", String.valueOf(description.getText()));
                edit_place = title;
                popup_action(bundle);
            }
        });

        edit_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageChooser();
            }
        });

    }



    public void popup_action(Bundle bundle){

        Intent intent = new Intent(this, edit_popup.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE_FOR_POPUP);

    }


    public void imageChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
}
