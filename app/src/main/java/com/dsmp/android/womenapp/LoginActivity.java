package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult> {

    Button buttonLogin;
    TextView txtLogin;
    EditText etxPassowrd,etxEmail;
    FirebaseAuth firebaseAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin= findViewById(R.id.txtLogin);


        buttonLogin =findViewById(R.id.buttonLogin);

        etxEmail=findViewById(R.id.etxEmail);
        etxPassowrd=findViewById(R.id.etxPassword);

        firebaseAuth=FirebaseAuth.getInstance();
        buttonLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(buttonLogin.getId()==view.getId()) {

          validate();
        }

    }

    private void validate() {


        String Email=etxEmail.getText().toString();
        String password=etxPassowrd.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(this);

    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful()){
            Intent intent = new Intent(this, AddServices.class);


            startActivity(intent);

            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }

    }
}
