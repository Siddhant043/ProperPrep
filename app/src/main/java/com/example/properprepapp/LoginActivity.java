package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText emailText, passwordText;
    private Button submitLoginButton;
    private DatabaseHelper myDB; //declaring instance

    public void onBack(View view){
        finish();
    }

    public void onRegister(View view){
        finish();
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.emailTextLogin);
        passwordText = findViewById(R.id.passwordTextLogin);
        submitLoginButton = findViewById(R.id.submitLoginButton);
        myDB = new DatabaseHelper(this); //initializing instance
        checkUser();
    }

    //function to check the user in database
    private void checkUser(){
        submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.checkUser(emailText.getText().toString(), passwordText.getText().toString());
                if(var){
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(LoginActivity.this, SignoutActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect email/password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}