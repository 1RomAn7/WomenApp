package com.dsmp.android.womenapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by vipul.
 */


public class AddServices extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<Void> {

    Button buttonAddService;
    EditText etxServiceName,etxServiceInfo,etxMinAge,etxServiceState,etxServiceCaste;
    DatabaseReference serviceDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);
        getSupportActionBar().setTitle(R.string.AddActivity);



        serviceDatabase = FirebaseDatabase.getInstance().getReference();
        etxServiceName =findViewById(R.id.etxServiceName);
        etxServiceInfo=findViewById(R.id.etxServiceInfo);
        etxMinAge=findViewById(R.id.etxMinAge);

        etxServiceState=findViewById(R.id.etxState);
        etxServiceCaste=findViewById(R.id.etxCaste);

        buttonAddService =findViewById(R.id.buttonAddService);

        buttonAddService.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String serviceName=etxServiceName.getText().toString();
        String serviceInfo=etxServiceInfo.getText().toString();
        String serviceState=etxServiceState.getText().toString();
        String serviceCaste=etxServiceCaste.getText().toString();
        String minAge=etxMinAge.getText().toString();


        if(serviceName.isEmpty() || serviceInfo.isEmpty() || serviceState.isEmpty() || serviceCaste.isEmpty() || minAge.isEmpty()){


            Toast.makeText(this,R.string.addserviceToast,Toast.LENGTH_LONG).show();


        }else{


            String id = serviceDatabase.push().getKey();

            Service service =new Service(id,serviceName,serviceInfo,serviceState,minAge,serviceCaste);

            serviceDatabase.child(id).setValue(service).addOnCompleteListener(this);


        }




    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {

        if(task.isSuccessful()) {


            Toast.makeText(this, R.string.addserviceToast1, Toast.LENGTH_LONG).show();

            etxServiceName.setText("");
            etxMinAge.setText("");

            etxServiceCaste.setText("");
            etxServiceInfo.setText("");
            etxServiceState.setText("");

        }else {

            Toast.makeText(this, R.string.addserviceToast2, Toast.LENGTH_LONG).show();

        }
    }
}
