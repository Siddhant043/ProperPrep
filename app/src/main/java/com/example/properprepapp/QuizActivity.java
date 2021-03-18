package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.properprepapp.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Questions> questions;
    FirebaseFirestore db;
    Questions question;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();

        questions.add(new Questions("", "An electron of mass me, initially at rest, moves through a certain distance in a uniform electric field in time tr A proton of mass mp) also initially at rest, takes time t2 to move through an equal distance in this uniform electric field. Neglecting the effect of gravity, the ratio of t, /1, is nearly equal to:", "1", "(mp/me)^1/2", "(me/mp)^1/2", "1832", "(mp/me)^1/2"));

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
                binding.firstOptionView.setClickable(true);
                binding.secondOptionView.setClickable(true);
                binding.thirdOptionView.setClickable(true);
                binding.fourthOptionView.setClickable(true);

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