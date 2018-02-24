package com.dsmp.android.womenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class AdvanceSearch extends AppCompatActivity {

    Button  ButtonSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search);

        ButtonSearch = (Button) findViewById(R.id.buttonSearch);
    }
}
