package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toolbar;

/**
 * Created by vipul.
 */


public class AdvanceSearchActivity extends AppCompatActivity implements View.OnClickListener {



    Button  buttonSearch;
    EditText  etxAge;//etxState,etxCaste;
    Spinner stateSpinner,casteSpinner;

    public static String casteSpinnerExtra=""
            ,stateSpinnerExtra="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Advance Search");

        setContentView(R.layout.activity_advance_search);



        etxAge= findViewById(R.id.etxAge);
        //etxState= findViewById(R.id.etxState);
        //etxCaste= findViewById(R.id.etxCaste);

        stateSpinner=findViewById(R.id.stateSpinner);
        casteSpinner=findViewById(R.id.casteSpinner);

        ArrayAdapter<CharSequence> stateAdapter= ArrayAdapter.createFromResource(this,R.array.StatesArray,android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);






        ArrayAdapter<CharSequence> casteAdapter= ArrayAdapter.createFromResource(this,R.array.CasteArray,android.R.layout.simple_spinner_item);
        casteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        casteSpinner.setAdapter(casteAdapter);


        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                stateSpinnerExtra= adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        casteSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                casteSpinnerExtra=adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonSearch = findViewById(R.id.buttonSearch);


        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent  intent=new Intent(this,AdvanceSearchResultActivity.class);

        String age= etxAge.getText().toString();

       // String  caste =etxCaste.getText().toString();

       // String state =etxState.getText().toString();

        intent.putExtra(AdvanceSearchResultActivity.AGE,age);

        intent.putExtra(AdvanceSearchResultActivity.CASTE,casteSpinnerExtra);

        intent.putExtra(AdvanceSearchResultActivity.STATE,stateSpinnerExtra);

        startActivity(intent);

    }
}
