package com.dsmp.android.womenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddServices extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddService;
    EditText etxServiceName,etxServiceInfo,etxMinAge,etxMaxAge,etxServiceState,etxServiceCaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);

        etxServiceName =findViewById(R.id.etxServiceName);
        etxServiceInfo=findViewById(R.id.etxServiceInfo);
        etxMinAge=findViewById(R.id.etxMinAge);
        etxMaxAge=findViewById(R.id.etxMaxAge);
        etxServiceState=findViewById(R.id.etxState);
        etxServiceCaste=findViewById(R.id.etxCaste);

        buttonAddService =findViewById(R.id.buttonAddService);

        buttonAddService.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        


    }
}
