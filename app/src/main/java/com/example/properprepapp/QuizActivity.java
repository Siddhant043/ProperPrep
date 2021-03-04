package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.properprepapp.databinding.ActivityQuizBinding;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Questions> questions;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();

        questions.add(new Questions("1/30", "Three charges +Q, q, +Q are placed  respectively, at distance 0, d/2 and d  from the origin, on the x-axis. If the net  force experienced by +Q placed at x = 0  is zero, then value of q is", "+Q/4", "–Q/2", "+Q/2", "-Q/4", "-Q/4"));
        questions.add(new Questions("2/30", "What is earth?", "Planet", "Human", "Country", "Animal", "Planet"));

        setNextQuestion();


    }


    void setNextQuestion() {
        if (index < questions.size()) {
            Questions question = questions.get(index);
            binding.questionNumber.setText(question.getQuestionId());
            binding.quizQuestion.setText(question.getQuestionText());
            binding.optionOne.setText(question.getOptionOne());
            binding.optionTwo.setText(question.getOptionTwo());
            binding.optionThree.setText(question.getOptionThree());
            binding.optionFour.setText(question.getOptionFour());
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextQuestion:
                if (index < questions.size()) {
                    index++;
                    setNextQuestion();
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