package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ServiceDetailsActivity extends AppCompatActivity {

    TextView txtServiceName,txtServiceCaste,txtServiceState,txtServiceAge,txtServiceInformation;
    TextView nameResult,stateResult,casteResult,ageResult,informationResult;

    public static final String serviceName="com.dsmp.android.womenapp.serviceName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);


        nameResult=findViewById(R.id.nameResult);
        stateResult=findViewById(R.id.stateResult);
        casteResult=findViewById(R.id.casteResult);
        ageResult=findViewById(R.id.ageResult);
        informationResult=findViewById(R.id.informationResult);


        Intent intent=getIntent();
        Service service=intent.getParcelableExtra(serviceName);

        nameResult.setText(service.getServiceName());
        stateResult.setText(service.getServiceState());
        casteResult.setText(service.getServiceCaste());
        ageResult.setText(service.getServiceMaxAge());
        informationResult.setText(service.getServiceInfo());


    }


}
