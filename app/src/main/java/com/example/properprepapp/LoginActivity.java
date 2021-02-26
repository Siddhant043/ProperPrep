package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    public void onBack(View view){
        finish();
    }
    public void onLoginSubmit(View view){
        finish();
        Intent intent = new Intent(LoginActivity.this, SignoutActivity.class);
        startActivity(intent);
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
    }
}