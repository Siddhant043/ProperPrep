package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.properprepapp.databinding.ActivityQuizBinding;
import com.example.properprepapp.databinding.ActivityTestMainBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TestMainActivity extends AppCompatActivity {
    ActivityTestMainBinding binding;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String testId = getIntent().getStringExtra("testId");



        db.collection("tests").document(testId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                TestModel model = documentSnapshot.toObject(TestModel.class);
                binding.mainHeading.setText(model.getTestName());
                binding.hostedByMain.setText(model.getHostedBy());
                binding.difficultyLevelMain.setText(model.getDifficultyLevel());
                binding.numberOfQuestionsMain.setText(model.getNoOfQuestions());
                binding.testDescriptionMain.setText(model.getTestDescription());
            }
        });




        binding.startMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, QuizActivity.class);
                intent.putExtra("categoryId", "test");
                startActivity(intent);
            }
        });


    }
}