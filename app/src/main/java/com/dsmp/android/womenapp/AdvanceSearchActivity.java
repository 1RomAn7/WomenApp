package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdvanceSearchActivity extends AppCompatActivity implements View.OnClickListener {

    Button  buttonSearch;
    EditText  etxAge,etxState,etxCaste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search);



        etxAge= findViewById(R.id.etxAge);
        etxState= findViewById(R.id.etxState);
        etxCaste= findViewById(R.id.etxCaste);

        buttonSearch = findViewById(R.id.buttonSearch);


        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent  intent=new Intent(this,AdvanceSearchResultActivity.class);
        startActivity(intent);

    }
}
