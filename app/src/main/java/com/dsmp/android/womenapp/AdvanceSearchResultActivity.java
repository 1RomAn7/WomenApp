package com.dsmp.android.womenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdvanceSearchResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static  String getAge="";
    public static  String getCaste="";
    public static  String getState="";
    TextView etxAge,etxStae,etxCaste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search_result);


        etxStae=findViewById(R.id.etxState);
        etxCaste=findViewById(R.id.etxCaste);
        etxAge=findViewById(R.id.etxAge);

        etxAge.setText(getAge);
        etxCaste.setText(getCaste);
        etxStae.setText(getState);

    }

    @Override
    public void onClick(View view) {

    }
}
