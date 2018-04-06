package com.dsmp.android.womenapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by vipul.
 */


public class LoginActivity extends AppCompatActivity{

    Button buttonLogin;
    TextView txtLogin;
    EditText etxPassowrd,etxEmail;
    FirebaseAuth firebaseAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(R.string.login);


        txtLogin= findViewById(R.id.txtLogin);


        buttonLogin =findViewById(R.id.buttonLogin);

        etxEmail=findViewById(R.id.etxEmail);
        etxPassowrd=findViewById(R.id.etxPassword);

        firebaseAuth=FirebaseAuth.getInstance();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }


    private void validate() {


        String Email=etxEmail.getText().toString();
        String password=etxPassowrd.getText().toString();

        if(Email.isEmpty() || password.isEmpty()){

            Toast.makeText(this,R.string.LoginActivityToast,Toast.LENGTH_LONG).show();


        }else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

            Toast.makeText(this, R.string.LoginActivityToast, Toast.LENGTH_LONG).show();


        }else{


            firebaseAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){


                        etxEmail.setText("");

                        etxPassowrd.setText("");

                        Intent intent = new Intent(LoginActivity.this, AddServices.class);
                        startActivity(intent);

                        Toast.makeText(LoginActivity.this, R.string.LoginActivityToast1, Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(LoginActivity.this, R.string.LoginActivityToast2, Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


}
