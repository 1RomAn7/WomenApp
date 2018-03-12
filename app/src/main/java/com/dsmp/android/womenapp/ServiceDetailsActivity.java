package com.dsmp.android.womenapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceDetailsActivity extends AppCompatActivity {

    Service service;
    TextView txtServiceName,txtServiceCaste,txtServiceState,txtServiceAge,txtServiceInformation;
    TextView nameResult,stateResult,casteResult,ageResult,informationResult;
    public static  final String serviceId="com.dsmp.android.womenapp.serviceId";
    public static final String serviceName="com.dsmp.android.womenapp.serviceName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);


       /* nameResult=findViewById(R.id.nameResult);
        stateResult=findViewById(R.id.stateResult);
        casteResult=findViewById(R.id.casteResult);
        ageResult=findViewById(R.id.ageResult);
        informationResult=findViewById(R.id.informationResult);


       Intent intent=getIntent();
        service=intent.getParcelableExtra(serviceName);

        nameResult.setText(service.getServiceName());
        stateResult.setText(service.getServiceState());
        casteResult.setText(service.getServiceCaste());
        ageResult.setText(service.getServiceMaxAge());
        informationResult.setText(service.getServiceInfo());


        */
        ListView listView =findViewById(R.id.listview);
        SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

        String query = "SELECT serviceName ,serviceCaste FROM Services";

        Cursor cursor=database.rawQuery(query,null);

        ArrayList<String> data =new ArrayList<String>();

        data.clear();

        while(cursor.moveToNext()) {



            String serviceName= cursor.getString(0);

            String serviceCaste = cursor.getString( 1);

            data.add(serviceName + " - "+serviceCaste);


        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       /* nameResult.setText("");
        stateResult.setText("");
        casteResult.setText("");
        ageResult.setText("");
        informationResult.setText("");

        */
    }


}
