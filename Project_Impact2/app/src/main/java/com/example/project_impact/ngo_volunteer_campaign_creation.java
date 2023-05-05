package com.example.project_impact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ngo_volunteer_campaign_creation extends AppCompatActivity {

    ImageView img;
    Button img_btn;
    EditText c_name;
    EditText details;
    Button cr_camp;

    private final int GALLERY_REQ_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_volunteer_campaign_creation);

        img = findViewById(R.id.img_voln_cover);
        img_btn = findViewById(R.id.cover_btn);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });

        c_name = findViewById(R.id.camp_name);
        details = findViewById(R.id.campaign_det);
        cr_camp = findViewById(R.id.create_camp);

        cr_camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ngo_volunteer_campaign_creation.this, "Campaign Created", Toast.LENGTH_SHORT).show();
                img.getResources();
                c_name.getText();
                details.getText();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                img.setImageURI(data.getData());
            }
        }
    }
}