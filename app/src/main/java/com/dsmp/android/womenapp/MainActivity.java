package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Service service ;
    Button buttonAllService;
    Button buttonAdvanceSearch;



    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAllService =(Button) findViewById(R.id.buttonAllService);
        buttonAdvanceSearch=(Button)findViewById(R.id.buttonAdvanceSerch);


        buttonAllService.setOnClickListener(this);



        buttonAdvanceSearch.setOnClickListener(this);

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

            Intent intent =new Intent(this,AllServices.class);
            startActivity(intent);

        }





    }



}
