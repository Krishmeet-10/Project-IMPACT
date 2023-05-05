package com.example.project_impact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class organizationDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_details);
        EditText orgName=findViewById(R.id.organisationNameEditText);
        EditText orgAddress=findViewById(R.id.organizationAddress);
        EditText orgType=findViewById(R.id.organizationType);
        EditText orgPhone=findViewById(R.id.organizationPhone);
        Button submitButton=findViewById(R.id.btn_org_details_submit);

submitButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
String name=orgName.getText().toString().trim();
String address=orgAddress.getText().toString().trim();
String oType=orgType.getText().toString().trim();
String phone=orgPhone.getText().toString().trim();
if (name.isEmpty() || address.isEmpty() || oType.isEmpty() || phone.isEmpty()){
    Toast.makeText(organizationDetails.this, "Alert, all fields are mandatory.", Toast.LENGTH_SHORT).show();
}
else {
    setNextOActivity(name, address, oType, phone);
}
}
});

    }

    public void setNextOActivity(String name,String address,String oType,String phone) {
        FirebaseAuth mAuth=FirebaseAuthManager.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if (currentUser!=null){
            String orgId=currentUser.getUid();
            DatabaseReference usersRef= FirebaseDatabase.getInstance().getReference("orgs");
            Map<String,String> org=new HashMap<>();
            org.put("orgName",name);
            org.put("orgAddress",address);
            org.put("orgType",oType);
            org.put("orgPhone",phone);
            usersRef.child(orgId).setValue(org);
            Intent intent=new Intent(getApplicationContext(),User_Landing_Page.class);
            startActivity(intent);
        }
else {
            Toast.makeText(getApplicationContext(), "Alert, could not load this account", Toast.LENGTH_SHORT).show();
        }
    }

}


