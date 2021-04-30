package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.properprepapp.databinding.ActivityAnalyseProgressBinding;
import com.example.properprepapp.databinding.ActivityAnalyseTestBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class AnalyseProgressActivity extends AppCompatActivity {

    ActivityAnalyseProgressBinding binding;
    FirebaseFirestore db;
    User user;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnalyseProgressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        String id = mAuth.getUid().toString();

        db.collection("users").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
            }
        });

        //binding number of questions attempted
        binding.physicsQuestionsAtempted.setText(user.getPhysicsQuestionsAttempted());
        binding.chemistryQuestionsAtempted.setText(user.getChemistryQuestionsAttempted());
        binding.mathsQuestionsAtempted.setText(user.getMathsQuestionsAttempted());
        binding.biologyQuestionsAtempted.setText(user.getBiologyQuestionsAttempted());

        //binding score
        binding.physicsScore.setText((user.getPhysicsScore()));
        binding.chemistryScore.setText((user.getChemistryScore()));
        binding.mathsScore.setText((user.getMathsScore()));
        binding.biologyScore.setText((user.getBiologyScore()));
    }
}