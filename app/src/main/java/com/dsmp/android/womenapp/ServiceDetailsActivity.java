package com.dsmp.android.womenapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vipul .
 */


public class ServiceDetailsActivity extends AppCompatActivity {


    Drawable fullStar;

    Drawable borderStar;

    String isCheckedColumn ="isCheckedColumn";

    String checkBoxValue;

    Button fav;

    String displayServiceName,displayServiceInfo,displayServiceAge,displayServiceState,displayServiceCaste;

    String serviceId;

    Menu menu;

    String serviceNameColumn="serviceName"
            ,serviceInfoColumn="serviceInfo"
            ,serviceAgeColumn="serviceAge"
            ,serviceIdColumn="serviceId"
            ,serviceStateColumn="serviceState"
            ,serviceCasteColumn="serviceCaste";

    TextView serviceName,serviceInfo,serviceCaste,serviceState,serviceAge;

    FloatingActionButton fab;

    CheckBox bookmark;

    boolean checkBookmark;

    boolean checkboxState;

    public static  String serviceIdExtra="";
    public static  String serviceIdExtraName="com.dsmp.android.womenapp.serviceId";
    public static  String serviceNameExtra="com.dsmp.android.womenapp.serviceName";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);

        fullStar = this.getResources().getDrawable(R.drawable.ic_star_full_24dp);
        borderStar = this.getResources().getDrawable(R.drawable.ic_star_border_black_24dp);

        getSupportActionBar().setTitle(R.string.ServiceDetailsActivity);

        bookmark =findViewById(R.id.bookMark);
        serviceName=findViewById(R.id.serviceName);
        serviceCaste=findViewById(R.id.serviceCaste);
        serviceState=findViewById(R.id.serviceState);
        serviceAge=findViewById(R.id.serviceAge);
        serviceInfo=findViewById(R.id.serviceInfo);


        Intent intent =getIntent();

        fab =findViewById(R.id.fab);

        serviceIdExtra=intent.getStringExtra(serviceIdExtraName);

        SQLiteDatabase database = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);

        String query = "SELECT "+serviceIdColumn+","+serviceNameColumn+","+serviceCasteColumn+","+serviceStateColumn+","+serviceInfoColumn+","+serviceAgeColumn+" FROM Services WHERE "+serviceIdColumn+"=";
        query+="\""+serviceIdExtra+"\"";

        Cursor cursor=database.rawQuery(query,null);

        while(cursor.moveToNext()) {


            serviceId=cursor.getString(0);

            displayServiceName= cursor.getString(1);

            displayServiceCaste = cursor.getString( 2);

            displayServiceState =cursor.getString(3);

            displayServiceInfo=cursor.getString(4);

            displayServiceAge=cursor.getString(5);
        }

        cursor.close();


        serviceName.setText(displayServiceName);
        serviceCaste.setText(displayServiceCaste);
        serviceState.setText(displayServiceState);
        serviceAge.setText(displayServiceAge);
        serviceInfo.setText(String.format("\t\t\t\t\t%s", displayServiceInfo));


        isBookmark();


        bookmark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(bookmark.isChecked())
                {

                    checkBookmark=true;
                    SQLiteDatabase bookmarkDB = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);


                    String query = "CREATE TABLE IF NOT EXISTS Favorites(" + serviceIdColumn + " VARCHAR PRIMARY KEY ," + serviceNameColumn +
                            " VARCHAR ," + serviceStateColumn + " VARCHAR ," + serviceCasteColumn + " VARCHAR ," + serviceInfoColumn + " VARCHAR ,"
                            + serviceAgeColumn + " VARCHAR ," + isCheckedColumn + " VARCHAR)";

                    bookmarkDB.execSQL(query);

                    String insert = "INSERT OR REPLACE INTO Favorites";

                    insert += " VALUES('" + serviceId + "','" + displayServiceName + "','" + displayServiceState + "','" + displayServiceCaste + "','" + displayServiceInfo + "','"
                            + displayServiceAge + "','" + checkBookmark + "')";

                    bookmarkDB.execSQL(insert);

                    Toast.makeText(ServiceDetailsActivity.this, R.string.ServiceDetailsActivityToast, Toast.LENGTH_SHORT).show();


                }
                else{

                    SQLiteDatabase bookmarkDB = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

                    String query = "CREATE TABLE IF NOT EXISTS Favorites(" + serviceIdColumn + " VARCHAR PRIMARY KEY ," + serviceNameColumn +
                            " VARCHAR ," + serviceStateColumn + " VARCHAR ," + serviceCasteColumn + " VARCHAR ," + serviceInfoColumn + " VARCHAR ,"
                            + serviceAgeColumn + " VARCHAR ," + isCheckedColumn + " VARCHAR)";

                    bookmarkDB.execSQL(query);

                    String delete = "DELETE FROM Favorites WHERE "+serviceIdColumn+"=\""+serviceId+"\"";

                    bookmarkDB.execSQL(delete);

                    Toast.makeText(ServiceDetailsActivity.this, R.string.ServiceDetailsActivityToast2, Toast.LENGTH_SHORT).show();



                }
            }
        });



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out Service \n"+serviceName.getText());
                intent.putExtra(android.content.Intent.EXTRA_TEXT, "ServiceName : "+serviceName.getText()+
                        "\n"+"Age : "+serviceAge.getText()+"\n"
                        +"State : "+serviceState.getText()+"\n"
                        +"Caste : "+serviceCaste.getText()+"\n"
                        +"Information : "+serviceInfo.getText()+"\n");
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });







    }

    private void isBookmark() {

        try {
            SQLiteDatabase bookmarkDB = openOrCreateDatabase("ServiceList", MODE_PRIVATE, null);

            String query = "CREATE TABLE IF NOT EXISTS Favorites(" + serviceIdColumn + " VARCHAR PRIMARY KEY ," + serviceNameColumn +
                    " VARCHAR ," + serviceStateColumn + " VARCHAR ," + serviceCasteColumn + " VARCHAR ," + serviceInfoColumn + " VARCHAR ,"
                    + serviceAgeColumn + " VARCHAR ," + isCheckedColumn + " VARCHAR)";

            bookmarkDB.execSQL(query);

            String select = "SELECT " + isCheckedColumn + " FROM Favorites WHERE " + serviceIdColumn + " = " + serviceId + "";

            Cursor cursor = bookmarkDB.rawQuery(select, null);

            if (cursor.getCount() <= 0) {

                bookmark.setChecked(false);
                cursor.close();
            } else {
                bookmark.setChecked(true);
                cursor.close();
            }
        }
        catch (Exception e)
        {

        }
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

    @Override
    protected void onStart() {
        super.onStart();

        SQLiteDatabase bookmarkDB = openOrCreateDatabase("ServiceList",MODE_PRIVATE,null);


        String query = "CREATE TABLE IF NOT EXISTS Favorites("+serviceIdColumn+" VARCHAR PRIMARY KEY ,"+serviceNameColumn+
                " VARCHAR ,"+serviceStateColumn+" VARCHAR ,"+serviceCasteColumn+" VARCHAR ,"+serviceInfoColumn+" VARCHAR ,"
                +serviceAgeColumn+" VARCHAR ,"+ isCheckedColumn +" VARCHAR)";

        bookmarkDB.execSQL(query);



    }



}
