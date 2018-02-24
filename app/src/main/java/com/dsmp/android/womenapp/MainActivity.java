package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonAllService;
    Button buttonAdvanceSearch;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAllService = findViewById(R.id.buttonAllService);
        buttonAdvanceSearch= findViewById(R.id.buttonAdvanceSerch);

        buttonAllService.setOnClickListener(this);

        buttonAdvanceSearch.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(buttonAllService.getId()==view.getId())
        {

            Intent intent =new Intent(this,AllServices.class);
            startActivity(intent);

        }

        if(buttonAdvanceSearch.getId()==view.getId())
        {

            Intent intent;
            intent = new Intent(this,AdvanceSearchActivity.class);
            startActivity(intent);

        }

    }



}
