package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonAllService;
    Button buttonAdvanceSearch;
    List<Service> serviceList ;

    DatabaseReference sRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference sChildRef =sRootRef.child("Services");




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAllService = findViewById(R.id.buttonAllService);
        buttonAdvanceSearch= findViewById(R.id.buttonAdvanceSerch);

        serviceList=new ArrayList<>();

        buttonAllService.setOnClickListener(this);

        buttonAdvanceSearch.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sChildRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapShot:dataSnapshot .getChildren()) {


                    Service service=postSnapShot.getValue(Service.class);

                    serviceList.add(service);
                    
                }




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
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
