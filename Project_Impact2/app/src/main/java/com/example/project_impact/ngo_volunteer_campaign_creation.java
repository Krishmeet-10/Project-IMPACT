package com.example.project_impact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class ngo_volunteer_campaign_creation extends AppCompatActivity {

    ImageView img;
    Button img_btn;
    EditText c_name;
    EditText details;
    Button cr_camp;

    private final int GALLERY_REQ_CODE = 1;

    private DatabaseReference mDatabase;
    private StorageReference mStorage;
    private Uri mImageUri;

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
                String title = c_name.getText().toString();
                String description = details.getText().toString();

                // Get Firebase references
                mDatabase = FirebaseDatabase.getInstance().getReference("camps");
                mStorage = FirebaseStorage.getInstance().getReference("camps");

                // Generate a unique camp ID using push() method
                String campId = mDatabase.child("camps").push().getKey();

                // Upload the image to Firebase Storage and get its download URL
                StorageReference imageRef = mStorage.child("camps").child(campId).child("image");
                imageRef.putFile(mImageUri).continueWithTask(task -> {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return imageRef.getDownloadUrl();
                }).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Image uploaded successfully, get the download URL
                        Uri downloadUrl = task.getResult();

                        // Create a HashMap with the camp data
                        HashMap<String, String> campMap = new HashMap<>();
                        campMap.put("campId", campId);
                        campMap.put("title", title);
                        campMap.put("description", description);
                        campMap.put("imageUrl", downloadUrl.toString());

                        // Save the camp data to Firebase Realtime Database
                        mDatabase.child("camps").child(campId).setValue(campMap);
                    } else {
                        // Handle errors uploading the image
                        Toast.makeText(ngo_volunteer_campaign_creation.this, "Error uploading image", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                img.setImageURI(data.getData());
                mImageUri = data.getData();
            }
        }
    }
}