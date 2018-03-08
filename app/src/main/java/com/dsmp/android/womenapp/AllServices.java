package com.dsmp.android.womenapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllServices extends AppCompatActivity implements  AdapterView.OnItemClickListener {


    Service service;
    List<Service> serviceList;

    List<String> serviceNameList;
    DatabaseReference sRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference sChildRef = sRootRef.child("");

    ListView listViewSevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        serviceNameList=new ArrayList<>();
        serviceList = new ArrayList<Service>();
        listViewSevice = findViewById(R.id.listViewService);


        listViewSevice.setOnItemClickListener(this);

    }


    protected void onStart() {
        super.onStart();
        final ValueEventListener valueEventListener = sChildRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                serviceList.clear();
                serviceNameList.clear();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {


                     service = postSnapShot.getValue(Service.class);
                   // String service = postSnapShot.getValue(String.class);
                    serviceList.add(service);
                    serviceNameList.add(service.getServiceName());

                }


                initialize();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });
    }



    private void initialize() {
        //serviceList.add();
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,serviceNameList);
        listViewSevice.setAdapter(adapter);
    }





    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent =new Intent(this,ServiceDetailsActivity.class);
        intent.putExtra(ServiceDetailsActivity.serviceName, service);
        startActivity(intent);

    }
}

