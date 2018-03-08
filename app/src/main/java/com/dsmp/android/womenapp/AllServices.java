package com.dsmp.android.womenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllServices extends AppCompatActivity {


    List<Service> serviceList;

    DatabaseReference sRootRef = FirebaseDatabase.getInstance().getReference();

    DatabaseReference sChildRef = sRootRef.child("");
    //ArrayList<Service> myList = getIntent().getParcelableExtra("Contact_list");
    ListView listViewSevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);

        serviceList = new ArrayList<Service>();
        listViewSevice = findViewById(R.id.listViewService);


    }


    protected void onStart() {
        super.onStart();
        final ValueEventListener valueEventListener = sChildRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                serviceList.clear();
                for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {


                     Service service = postSnapShot.getValue(Service.class);
                   // String service = postSnapShot.getValue(String.class);
                    serviceList.add(service);


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
        ArrayAdapter<Service> adapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,serviceList);
        listViewSevice.setAdapter(adapter);
    }
}

