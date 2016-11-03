package com.example.my_pc.orderapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by My-PC on 03/11/2016.
 */
public class LoginActivity extends AppCompatActivity {
    // Email, password edittext
    EditText txtUsername, txtPassword;
    // isi Shared Preferences
    private final String NAMA = "Belajar Sessions";
    private final String EMAIL = "email@gmail.com";
    // Username dan password
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    // login button
    Button btnLogin;
    // Session Manager Class
    SessionManager session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);


        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0)
                {
                    if(username.equals(USERNAME) && password.equals(PASSWORD)){

                        session.createLoginSession(NAMA, EMAIL);
                        Intent i = new Intent(getApplicationContext(),
                                MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{

                        Toast.makeText(getApplicationContext(), "Wrong Username or Password!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Insert Username and Password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}