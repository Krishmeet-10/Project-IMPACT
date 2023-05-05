package com.example.project_impact.Navigation_Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_impact.R;

public class edit_popup extends Activity {



    TextView cancel_tv;

    TextView heading;
    EditText editText;
    Button confirm;

    public String type;
    public  String current;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.6),(int)(height*0.6));

        cancel_tv = (TextView) findViewById(R.id.cancel_tv);
        editText = (EditText) findViewById(R.id.poup_edit_text);
        confirm = (Button) findViewById(R.id.edit_popup_confirm);
        heading = (TextView) findViewById(R.id.edit_popup_heading);

        Bundle extra = getIntent().getExtras();
        type = extra.getString("key");
        current = extra.getString("current");
        heading.setText(heading.getText()  + extra.getString("key"));

        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_out = String.valueOf(editText.getText());

                if(checker(edit_out,v)) {
                    Intent intent = new Intent();
                    intent.putExtra("data",edit_out);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

    public boolean checker(String edit_out, View v){



        if(type.equals("email") ){

            //Toast.makeText(v.getContext(),type,Toast.LENGTH_SHORT).show();

            if(!edit_out.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]+")){
                Toast.makeText(v.getContext(),"Improper email format",Toast.LENGTH_SHORT).show();
                return false;
            }

            else if(edit_out.equals(current)){
                Toast.makeText(v.getContext(),"Input can not be same as before",Toast.LENGTH_SHORT).show();
                return false;
            }

            else {
                return true;
            }
        }


        else if(type.equals("phone")){
            //Toast.makeText(v.getContext(),type,Toast.LENGTH_SHORT).show();


            if(!edit_out.matches("\\d{10}")){
                Toast.makeText(v.getContext(),"Improper phone number format",Toast.LENGTH_SHORT).show();
                return false;
            }

            else if(edit_out.equals(current)){
                Toast.makeText(v.getContext(),"Input can not be same as before",Toast.LENGTH_SHORT).show();
                return false;
            }

            else {
                return true;
            }

        }


        else{

            //Toast.makeText(v.getContext(),type,Toast.LENGTH_SHORT).show();
            edit_out.trim();
            if(edit_out.isEmpty()){
                Toast.makeText(v.getContext(),"Input can not be Empty",Toast.LENGTH_SHORT).show();
                return false;
            }

            else if(edit_out.equals(current)){
                Toast.makeText(v.getContext(),"Input can not be same as before",Toast.LENGTH_SHORT).show();
                return false;
            }

            else{
                return true;
            }
        }

    }

}
