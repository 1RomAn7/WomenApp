package com.dsmp.android.womenapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vipul .
 */


public class ServiceDetailsActivity extends AppCompatActivity {



    String displayServiceName,displayServiceInfo,displayServiceAge,displayServiceState,displayServiceCaste;

    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";

    TextView serviceName,serviceInfo,serviceCaste,serviceState,serviceAge;

    FloatingActionButton fab;

    CheckBox bookmark;

    public static  String serviceIdExtra="";
    public static  String serviceIdExtraName="com.dsmp.android.womenapp.serviceId";
    public static  String serviceNameExtra="com.dsmp.android.womenapp.serviceName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);

        getSupportActionBar().setTitle("Service Details");

        bookmark=findViewById(R.id.bookmark);
        serviceName=findViewById(R.id.serviceName);
        serviceCaste=findViewById(R.id.serviceCaste);
        serviceState=findViewById(R.id.serviceState);
        serviceAge=findViewById(R.id.serviceAge);
        serviceInfo=findViewById(R.id.serviceInfo);

        Intent intent =getIntent();

        fab =findViewById(R.id.fab);

        serviceIdExtra=intent.getStringExtra(serviceIdExtraName);



        SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

        String query = "SELECT "+serviceNameColumn+","+serviceCasteColumn+","+serviceStateColumn+","+serviceInfoColumn+","+serviceAgeColumn+" FROM Services WHERE "+serviceIdColumn+"=";
        query+="\""+serviceIdExtra+"\"";

        Cursor cursor=database.rawQuery(query,null);

        while(cursor.moveToNext()) {



            displayServiceName= cursor.getString(0);


            displayServiceCaste = cursor.getString( 1);

            displayServiceState =cursor.getString(2);

            displayServiceInfo=cursor.getString(3);

            displayServiceAge=cursor.getString(4);
        }

        cursor.close();


        serviceName.setText(displayServiceName);
        serviceCaste.setText(displayServiceCaste);
        serviceState.setText(displayServiceState);
        serviceAge.setText(displayServiceAge);
        serviceInfo.setText("\t\t\t\t\t"+displayServiceInfo);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ServiceDetailsActivity.this, "Kindly Select G mail", Toast.LENGTH_SHORT).show();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");

                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out Service \n"+serviceName.getText());
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "ServiceName : "+serviceName.getText()+
                        "\n"+"Age : "+serviceAge.getText()+"\n"
                        +"State : "+serviceState.getText()+"\n"
                        +"Caste : "+serviceCaste.getText()+"\n"
                        +"Information : "+serviceInfo.getText()+"\n");
                startActivity(emailIntent);
            }
        });



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
