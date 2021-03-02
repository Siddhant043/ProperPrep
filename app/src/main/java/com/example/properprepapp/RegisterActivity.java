package com.example.properprepapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailText, passwordText, confirmPasswordText;
    private Button submitSignupButton;
    private FirebaseAuth mAuth; //declared firebase instance

    public void onLogin(View view) {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailText = findViewById(R.id.emailTextSingup);
        passwordText = findViewById(R.id.passwordTextSignup);
        confirmPasswordText = findViewById(R.id.confirmPasswordTextSignup);
        submitSignupButton = findViewById(R.id.submitSignupButton);
        mAuth = FirebaseAuth.getInstance(); //initialized firebase instance
        submitSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }

    // function to create a user
    private void createUser() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();
        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.equals(confirmPassword)) {
            if (!password.isEmpty()) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "SignUp Successful!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(RegisterActivity.this, SignoutActivity.class));
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                passwordText.setError("Empty fields are not allowed.");
            }
        } else if (email.isEmpty()) {
            emailText.setError("Empty fields are not allowed.");
        } else if (!password.equals(confirmPassword)) {
            confirmPasswordText.setError("Password does not match Confirm password");
        } else {
            emailText.setError("Please enter correct email.");
        }
    }


}