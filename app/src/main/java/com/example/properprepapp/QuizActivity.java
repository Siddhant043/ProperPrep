package com.example.properprepapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.properprepapp.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Questions> questions;
    FirebaseFirestore db;
    Questions question;
    int correctAnswer = 0;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();
        String categoryId = getIntent().getStringExtra("categoryId");
        questions = new ArrayList<>();
        Log.i("Category value", categoryId);



        db.collection("categories").document(categoryId).collection("questions").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                    Questions newQuestion = snapshot.toObject(Questions.class);
                    questions.add(newQuestion);
                }
            }
        });

        setNextQuestion();





    }

    // function to show the correct answer after selection
    void showAnswer(){
        if(question.getCorrectAnswer().equals(binding.optionOne.getText().toString())){
            binding.firstOptionView.setBackground(getResources().getDrawable(R.drawable.green_background));
        }else if(question.getCorrectAnswer().equals(binding.optionTwo.getText().toString())){
            binding.secondOptionView.setBackground(getResources().getDrawable(R.drawable.green_background));
        }
        else if(question.getCorrectAnswer().equals(binding.optionThree.getText().toString())){
            binding.thirdOptionView.setBackground(getResources().getDrawable(R.drawable.green_background));
        }else if(question.getCorrectAnswer().equals(binding.optionFour.getText().toString())){
            binding.fourthOptionView.setBackground(getResources().getDrawable(R.drawable.green_background));
        }
    }

    // function to show a question based on index number
    void setNextQuestion() {
        if (index < questions.size()) {
            binding.questionNumber.setText(String.format("%d/%d", (index+1), questions.size())); // setting up the questionNumber
            question = questions.get(index);
            binding.quizQuestion.setText(question.getQuestionText());
            binding.optionOne.setText(question.getOptionOne());
            binding.optionTwo.setText(question.getOptionTwo());
            binding.optionThree.setText(question.getOptionThree());
            binding.optionFour.setText(question.getOptionFour());
        }
    }

    // function to check the user's answer
    void checkAnswer(TextView textView, View view) {
        String selectedAnswer = textView.getText().toString();
        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            correctAnswer++;
            view.setBackground(getResources().getDrawable(R.drawable.green_background));
        } else {
            showAnswer();
            view.setBackground(getResources().getDrawable(R.drawable.red_background));
        }
    }



    //function to reset the background of the options
    void reset(){

                binding.firstOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
                binding.secondOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
                binding.thirdOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
                binding.fourthOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));

    }

    //function runs when any clickable item is clicked.
    public void onClick(View view) {
        switch (view.getId()) {
            //on option selection the particular view and the text inside it is passed to check function.
            case R.id.firstOptionView:
                TextView selected1 = binding.optionOne;
                checkAnswer(selected1, view);
                break;
            case R.id.secondOptionView:
                TextView selected2 = binding.optionTwo;
                checkAnswer(selected2, view);
                break;
            case R.id.thirdOptionView:
                TextView selected3 = binding.optionThree;
                checkAnswer(selected3, view);
                break;
            case R.id.fourthOptionView:
                TextView selected4 = binding.optionFour;
                checkAnswer(selected4, view);
                break;

            //this case runs when next button is tapped
            case R.id.nextQuestion:
                if (index < questions.size()) {
                    index++;
                    setNextQuestion();
                    reset();
                } else {
                    Toast.makeText(this, "No more questions.", Toast.LENGTH_SHORT).show();
                }
                break;
            //this case runs when previous button is tapped
            case R.id.previousQuestion:
                if (index > 0) {
                    index--;
                    setNextQuestion();
                } else {
                    Toast.makeText(this, "No previous question available.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}