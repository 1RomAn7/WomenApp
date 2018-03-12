package com.dsmp.android.womenapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdvanceSearchResultActivity extends AppCompatActivity {

    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";


    public String serviceIdExtra;

    String displayServiceName,displayServiceInfo,displayServiceAge,displayServiceState,displayServiceCaste;


    public final static String AGE = "com.dsmp.android.womenapp.age";
    public static String ageExtra="";

    public final static String STATE="com.dsmp.android.womenapp.State";
    public static String stateExtra="";

    public static final String CASTE="com.dsmp.android.womenapp.Caste";
    public static String casteExtra="";

    List<String> searchResult;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search_result);

        listView=findViewById(R.id.list_view);

        searchResult=new ArrayList<>();


        Intent intent =getIntent();

        ageExtra=intent.getStringExtra(AGE);
        stateExtra=intent.getStringExtra(STATE);
        casteExtra=intent.getStringExtra(CASTE);





            SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

            String query = "SELECT "+serviceNameColumn+","+serviceCasteColumn+","+serviceStateColumn+","+serviceInfoColumn+","+serviceAgeColumn+" FROM Services WHERE "+serviceCasteColumn+"=";
            query+="\""+casteExtra+"\" OR "+serviceStateColumn+"=\""+stateExtra+"\" OR "+serviceAgeColumn+"=\""+ageExtra+"\"";



            Cursor cursor = database.rawQuery(query, null);

            while (cursor.moveToNext()) {

                displayServiceName= cursor.getString(0);


                displayServiceCaste = cursor.getString( 1);

                displayServiceState =cursor.getString(2);

                displayServiceInfo=cursor.getString(3);

                displayServiceAge=cursor.getString(4);

                searchResult.add(displayServiceName+"\n"+displayServiceCaste +"|||"+ displayServiceState +"|||"+ displayServiceAge);

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















