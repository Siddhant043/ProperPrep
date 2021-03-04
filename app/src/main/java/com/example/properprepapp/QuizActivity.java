package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.properprepapp.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Questions> questions;
    Questions question;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();

        questions.add(new Questions("", "Three charges +Q, q, +Q are placed  respectively, at distance 0, d/2 and d  from the origin, on the x-axis. If the net  force experienced by +Q placed at x = 0  is zero, then value of q is", "+Q/4", "–Q/2", "+Q/2", "-Q/4", "-Q/4"));
        questions.add(new Questions("", "What is earth?", "Planet", "Human", "Country", "Animal", "Planet"));

        setNextQuestion();


    }

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


    void setNextQuestion() {
        if (index < questions.size()) {
            binding.questionNumber.setText(String.format("%d/%d", (index+1), questions.size()));
            question = questions.get(index);
            binding.quizQuestion.setText(question.getQuestionText());
            binding.optionOne.setText(question.getOptionOne());
            binding.optionTwo.setText(question.getOptionTwo());
            binding.optionThree.setText(question.getOptionThree());
            binding.optionFour.setText(question.getOptionFour());
        }
    }

    void checkAnswer(TextView textView, View view) {
        String selectedAnswer = textView.getText().toString();
        if (selectedAnswer.equals(question.getCorrectAnswer())) {
            view.setBackground(getResources().getDrawable(R.drawable.green_background));
        } else {
            showAnswer();
            view.setBackground(getResources().getDrawable(R.drawable.red_background));
        }
    }

    void reset(){
        binding.firstOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
        binding.secondOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
        binding.thirdOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
        binding.fourthOptionView.setBackground(getResources().getDrawable(R.drawable.white_background));
    }

    public void onClick(View view) {
        switch (view.getId()) {
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


            case R.id.nextQuestion:
                if (index < questions.size()) {
                    index++;
                    setNextQuestion();
                    reset();
                } else {
                    Toast.makeText(this, "No more questions.", Toast.LENGTH_SHORT).show();
                }
                break;
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