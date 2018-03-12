package com.dsmp.android.womenapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllServices extends AppCompatActivity  {

    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";


    public String serviceIdExtra;

    String serviceName,serviceInfo,serviceAge,serviceid,serviceState,serviceCaste;

    Service service;
    List<Service> serviceList;

    List<String> serviceNameList;
    DatabaseReference sRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference sChildRef = sRootRef.child("");

    ListView listViewService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        serviceNameList=new ArrayList<>();
        serviceList = new ArrayList<Service>();
        listViewService = findViewById(R.id.listViewService);

        initialize();

        listViewService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String getServiceName = (String) adapterView.getItemAtPosition(i);

                SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

                String query = "SELECT * FROM Services WHERE "+serviceNameColumn+"=";
                query+="\""+getServiceName+"\"";

                Cursor cursor = database.rawQuery(query, null);

                while (cursor.moveToNext()) {

                     serviceIdExtra=cursor.getString(0);

                }


                Intent intent =new Intent(AllServices.this,ServiceDetailsActivity.class);
                intent.putExtra(ServiceDetailsActivity.serviceIdExtraName,serviceIdExtra);
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
                serviceNameList.clear();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {


                     service = postSnapShot.getValue(Service.class);
                   // String service = postSnapShot.getValue(String.class);

                    serviceNameList.add(service.getServiceName());


                    serviceName=service.getServiceName();
                    serviceCaste=service.getServiceCaste();
                    serviceAge=service.getServiceMinAge();
                    serviceState=service.getServiceState();
                    serviceid=service.getId();
                    serviceInfo=service.getServiceInfo();


                    SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

                    String query = "CREATE TABLE IF NOT EXISTS Services("+serviceIdColumn+" VARCHAR PRIMARY KEY ,"+serviceNameColumn+" VARCHAR ,"+serviceCasteColumn+" VARCHAR ,"+serviceStateColumn+" VARCHAR ,"+serviceInfoColumn+" VARCHAR ,"+serviceAgeColumn+" VARCHAR)";


                    database.execSQL(query);

                    String insert = "INSERT OR REPLACE INTO Services("+serviceIdColumn+","+serviceNameColumn+","+serviceCasteColumn+","+serviceStateColumn+","+serviceInfoColumn+","+serviceAgeColumn+")";
                    insert+=" VALUES('"+serviceid+"','"+serviceName+"','"+serviceCaste+"','"+serviceState+"','"+serviceInfo+"','"+serviceAge+"')";

                    database.execSQL(insert);


                }


                initialize();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }



    private void initialize() {
        //serviceList.add();
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,serviceNameList);
        listViewService.setAdapter(adapter);


    }






}

