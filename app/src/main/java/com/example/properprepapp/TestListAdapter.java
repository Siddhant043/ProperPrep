package com.example.properprepapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestViewHolder> {
    Context context;
    ArrayList<TestModel> testListModels;
    public TestListAdapter(Context context, ArrayList<TestModel> testListModels){
    this.context = context;
    this.testListModels = testListModels;
    }
    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_test_list, null);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        TestModel model = testListModels.get(position);
        holder.heading.setText(model.getTestName());
        holder.difficultyLevel.setText(model.getDifficultyLevel());
        holder.numberOfQuestions.setText(model.getNoOfQuestions());
        holder.hostedBy.setText(model.getHostedBy());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, TestMainActivity.class);
                intent.putExtra("testId", model.getTestId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return testListModels.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        TextView heading, hostedBy, numberOfQuestions, difficultyLevel;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.headingText);
            hostedBy = itemView.findViewById(R.id.hostedByText);
            numberOfQuestions = itemView.findViewById(R.id.numberOfQuestionsText);
            difficultyLevel = itemView.findViewById(R.id.difficultyLevelText);
        }
    }
}
