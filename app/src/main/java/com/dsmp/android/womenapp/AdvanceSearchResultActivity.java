package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdvanceSearchResultActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String Age = "com.dsmp.android.womenapp.age";
    public static String getAge = "";
    public static String getCaste = "";
    public static String getState = "";
    TextView etxAge, etxStae, etxCaste;
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search_result);


        etxStae = findViewById(R.id.etxState);
        etxCaste = findViewById(R.id.etxCaste);
        etxAge = findViewById(R.id.etxAge);

        Intent intent =getIntent();
           String a= intent.getStringExtra(Age);
        ed=findViewById(R.id.editText);

        ed.setText(a);











  /*  private void getIntentFrom() {

        Intent intent =getIntent();

       String age = intent.getStringExtra("Age");
       String caste =intent.getStringExtra("Caste");
       String state =intent.getStringExtra("State");

       etxAge.setText(age);
       etxCaste.setText(caste);
       etxStae.setText(state);
    }*/


    }

    @Override
    public void onClick(View view) {

    }
}
