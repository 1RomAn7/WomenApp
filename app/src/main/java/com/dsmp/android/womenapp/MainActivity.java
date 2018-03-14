package com.dsmp.android.womenapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{


    CardView allService,advanceSerach;

    Button login;
    //Button buttonAllService,buttonLogin;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       allService=findViewById(R.id.allServices);
       advanceSerach=findViewById(R.id.advanceSerach);
       login=findViewById(R.id.login);


       allService.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent =new Intent(MainActivity.this,AllServices.class);

               startActivity(intent);

           }
       });

       advanceSerach.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,AdvanceSearchActivity.class);
               startActivity(intent);


           }
       });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent =new Intent(MainActivity.this,LoginActivity.class);

               startActivity(intent);

           }
       });


    /*
        buttonAllService = findViewById(R.id.buttonAllService);
        buttonAdvanceSearch= findViewById(R.id.buttonAdvanceSerch);
        buttonLogin=findViewById(R.id.etxPassword);

        buttonAllService.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        buttonAdvanceSearch.setOnClickListener(this);
*/
    }


    //@Override
   /* public void onClick(View view) {

        if(buttonAllService.getId()==view.getId())
        {

            Intent intent =new Intent(this,AllServices.class);

            //intent.putExtra("Contact_list", (Parcelable) serviceList);
            startActivity(intent);
        }

        if(buttonAdvanceSearch.getId()==view.getId())
        {

            Intent intent;
            intent = new Intent(this,AdvanceSearchActivity.class);
            startActivity(intent);

        }
        if(buttonLogin.getId()==view.getId())
        {

            Intent intent =new Intent(this,LoginActivity.class);

            startActivity(intent);

        }

    }*/



}
