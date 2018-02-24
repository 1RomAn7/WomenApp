package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdvanceSearchActivity extends AppCompatActivity implements View.OnClickListener {

    Button  buttonSearch;
    EditText   etxServiceName,etxAge,etxState,etxCaste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search);


        etxServiceName=(EditText)findViewById(R.id.etxServiceName);
        etxAge=(EditText)findViewById(R.id.etxAge);
        etxState=(EditText)findViewById(R.id.etxState);
        etxCaste=(EditText)findViewById(R.id.etxCaste);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);


        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent  intent=new Intent(this,AdvanceSearchActivity.class);
        startActivity(intent);

    }
}
