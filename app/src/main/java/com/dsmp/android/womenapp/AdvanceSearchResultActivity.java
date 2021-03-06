package com.dsmp.android.womenapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vipul.
 */


public class AdvanceSearchResultActivity extends AppCompatActivity {

    String serviceNameColumn="serviceName"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";



    public String serviceIdExtra;

    String displayServiceName;


    public final static String AGE = "com.dsmp.android.womenapp.age";
    public static String ageExtra="";

    public final static String STATE="com.dsmp.android.womenapp.State";
    public static String stateExtra="";

    public static final String CASTE="com.dsmp.android.womenapp.Caste";
    public static String casteExtra="";

    List<String> searchResult;

    ListView listView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search_result);
        getSupportActionBar().setTitle(R.string.AdvanceSearchResult);


        listView=findViewById(R.id.list_view);

        searchResult=new ArrayList<>();


        Intent intent =getIntent();

        ageExtra=intent.getStringExtra(AGE);
        stateExtra=intent.getStringExtra(STATE);
        casteExtra=intent.getStringExtra(CASTE);



        if(ageExtra.isEmpty()){



            SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

            String query = "SELECT " + serviceNameColumn + " FROM Services WHERE " + serviceCasteColumn + "=";
            query += "\"" + casteExtra + "\" AND " + serviceStateColumn + "=\"" + stateExtra + "\" ORDER BY " + serviceNameColumn + " ASC";;

            String serviceName;


            Cursor cursor = database.rawQuery(query, null);



            searchResult.clear();
            while (cursor.moveToNext()) {

                serviceName = cursor.getString(0);
                searchResult.add(serviceName);

            }

            cursor.close();



        }
        else{

            if(ageExtra.equals("2")||ageExtra.equals("3")||ageExtra.equals("4")||ageExtra.equals("5")||ageExtra.equals("6")||ageExtra.equals("7")||
                    ageExtra.equals("8")||ageExtra.equals("9")){


                Toast.makeText(this ,R.string.advanceSearchResultToast,Toast.LENGTH_SHORT ).show();


            }else {
                SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

                String query = "SELECT " + serviceNameColumn + " FROM Services WHERE " + serviceCasteColumn + "=";
                query += "\"" + casteExtra + "\" AND " + serviceStateColumn + "=\"" + stateExtra + "\" AND " + serviceAgeColumn + "<=\"" + ageExtra + "\" ORDER BY " + serviceNameColumn + " ASC";


                Cursor cursor = database.rawQuery(query, null);

                while (cursor.moveToNext()) {

                    displayServiceName = cursor.getString(0);


                    searchResult.add(displayServiceName);

                }

                cursor.close();

                if (searchResult.isEmpty()) {

                    Toast.makeText(this, R.string.advanceSearchResultToast, Toast.LENGTH_SHORT).show();

                }

            }



        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String getServiceName = (String) adapterView.getItemAtPosition(i);

                SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

                String query = "SELECT "+serviceIdColumn+" FROM Services WHERE "+serviceNameColumn+"=";
                query+="\""+getServiceName+"\"";

                Cursor cursor = database.rawQuery(query, null);

                while (cursor.moveToNext()) {

                    serviceIdExtra=cursor.getString(0);

                }


                Intent intent =new Intent(AdvanceSearchResultActivity.this,ServiceDetailsActivity.class);
                intent.putExtra(ServiceDetailsActivity.serviceIdExtraName,serviceIdExtra);
                startActivity(intent);
                cursor.close();
            }
        });




        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,searchResult);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();




    }
}















