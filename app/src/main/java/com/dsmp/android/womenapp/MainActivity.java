

package com.dsmp.android.womenapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipul on 2/20/2018.
 */

public class MainActivity extends AppCompatActivity{


    CardView allService, advanceSearch;


    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";




    DatabaseReference sRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference sChildRef = sRootRef.child("");

    String serviceName,serviceInfo,serviceAge,serviceid,serviceState,serviceCaste;

    Service service;

    List<Service> serviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       allService=findViewById(R.id.allServices);
       advanceSearch =findViewById(R.id.advanceSerach);

        serviceList = new ArrayList<>();


       allService.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent =new Intent(MainActivity.this,AllServices.class);

               startActivity(intent);

           }
       });

       advanceSearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,AdvanceSearchActivity.class);
               startActivity(intent);


           }
       });




    }


    protected void onStart() {
        super.onStart();
        final ValueEventListener valueEventListener = sChildRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                serviceList.clear();

                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {


                    service = postSnapShot.getValue(Service.class);

                        serviceName = service.getServiceName();
                        serviceCaste = service.getServiceCaste();
                        serviceAge = service.getServiceMinAge();
                        serviceState = service.getServiceState();
                        serviceid = service.getId();
                        serviceInfo = service.getServiceInfo();


                    SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

                    String query = "CREATE TABLE IF NOT EXISTS Services("+serviceIdColumn+" VARCHAR PRIMARY KEY ,"+serviceNameColumn+" VARCHAR ,"+serviceCasteColumn+" VARCHAR ,"+serviceStateColumn+" VARCHAR ,"+serviceInfoColumn+" VARCHAR ,"+serviceAgeColumn+" VARCHAR)";


                    database.execSQL(query);

                    String insert = "INSERT OR REPLACE INTO Services("+serviceIdColumn+","+serviceNameColumn+","+serviceCasteColumn+","+serviceStateColumn+","+serviceInfoColumn+","+serviceAgeColumn+")";
                    insert+=" VALUES('"+serviceid+"','"+serviceName+"','"+serviceCaste+"','"+serviceState+"','"+serviceInfo+"','"+serviceAge+"')";

                    database.execSQL(insert);


                }





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.bookmarkedServices){

            Intent intent =new Intent(this,BookmarkActivity.class);
            startActivity(intent);


        } else if(id==R.id.changeLang){

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings");
            startActivity(intent);

        }else if(id==R.id.loginPage) {

            Intent intent =new Intent(this,LoginActivity.class);
            startActivity(intent);

        }


        return true;
    }
}
