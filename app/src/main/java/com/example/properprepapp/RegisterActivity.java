package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailText, passwordText, confirmPasswordText;
    private Button submitSignupButton;
    private DatabaseHelper myDB; //declaring database instance

    public void onBack(View view){
        finish();
    }

    public void onLogin(View view){
        finish();
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailText = findViewById(R.id.emailTextSingup);
        passwordText = findViewById(R.id.passwordTextSignup);
        confirmPasswordText = findViewById(R.id.confirmPasswordTextSignup);
        submitSignupButton = findViewById(R.id.submitSignupButton);
        myDB = new DatabaseHelper(this); //initializing database
        insertUser();
    }

    //function to register the user in database
    private void insertUser(){
        submitSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordText.getText().toString().equals(confirmPasswordText.getText().toString())){
                    boolean var = myDB.registerUser(emailText.getText().toString(), passwordText.getText().toString());
                    if(var){
                        Toast.makeText(RegisterActivity.this, "SignUp Successful!", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(RegisterActivity.this, SignoutActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "SignUp failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}