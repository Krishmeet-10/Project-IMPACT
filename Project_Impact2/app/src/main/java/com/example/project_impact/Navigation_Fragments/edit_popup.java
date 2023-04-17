package com.example.project_impact.Navigation_Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project_impact.R;

public class edit_popup extends Activity {

    TextView cancel_tv;

    TextView heading;
    EditText editText;
    Button confirm;

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


    }

}
