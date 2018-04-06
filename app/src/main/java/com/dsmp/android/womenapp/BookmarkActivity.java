package com.dsmp.android.womenapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity {

    String isCheckedColumn ="isCheckedColumn";

    String displayServiceName,displayServiceInfo,displayServiceAge,displayServiceState,displayServiceCaste;

    String serviceId;

    public String serviceIdExtra;

    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";

    ListView bookmarkList;

    List<String> serviceNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);




        bookmarkList=findViewById(R.id.listViewBookmark);

        serviceNameList= new ArrayList<>();

        getSupportActionBar().setTitle("Bookmark");

        serviceNameList.clear();

        SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);


        String query = "SELECT * FROM  Favorites ORDER BY "+serviceNameColumn+" ASC";

        String serviceName;


        Cursor cursor = database.rawQuery(query, null);
        serviceNameList.clear();
        while (cursor.moveToNext()) {

            serviceName = cursor.getString(1);
            serviceNameList.add(serviceName);

        }

        cursor.close();
        initialize();



    bookmarkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String getServiceName = (String) adapterView.getItemAtPosition(i);

            SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

            String query = "SELECT * FROM Favorites WHERE "+serviceNameColumn+"=";
            query+="\""+getServiceName+"\"";

            Cursor cursor = database.rawQuery(query, null);

            while (cursor.moveToNext()) {

                serviceIdExtra=cursor.getString(0);

            }

            cursor.close();

            Intent intent =new Intent(BookmarkActivity.this,ServiceDetailsActivity.class);
            intent.putExtra(ServiceDetailsActivity.serviceIdExtraName,serviceIdExtra);
            startActivity(intent);
        }
    });

        if(serviceNameList.isEmpty()){

            Toast.makeText(this,"No Bookmarks Present",Toast.LENGTH_SHORT).show();

        }
    }


    private void initialize() {


        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,serviceNameList);
        bookmarkList.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteDatabase database = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);


        String query = "SELECT * FROM  Favorites ORDER BY "+serviceNameColumn+" ASC";

        String serviceName;


        Cursor cursor = database.rawQuery(query, null);
        serviceNameList.clear();
        while (cursor.moveToNext()) {

            serviceName = cursor.getString(1);
            serviceNameList.add(serviceName);

        }

        cursor.close();
        initialize();

        if(serviceNameList.isEmpty()){

            Toast.makeText(this,"No Bookmarks Present",Toast.LENGTH_SHORT).show();

        }

    }
}
