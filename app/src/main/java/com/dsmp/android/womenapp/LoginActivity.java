package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogin;
    TextView txtLogin,txtSignUp;
    EditText etxPassowrd,etxEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin= findViewById(R.id.txtLogin);
        txtSignUp=findViewById(R.id.txtSignUp);

        buttonLogin =findViewById(R.id.etxPassword);

        etxEmail=findViewById(R.id.etxEmail);
        etxPassowrd=findViewById(R.id.etxPassword);


        buttonLogin.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(txtSignUp.getId()==view.getId()) {

            Intent intent =new Intent(this,RegistorNewUser.class);
            startActivity(intent);
        }

        if(buttonLogin.getId()==view.getId()) {

            Intent intent = new Intent(this ,AddServices.class);
            startActivity(intent);


        }

    }
}
