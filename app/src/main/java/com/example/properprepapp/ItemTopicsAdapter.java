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

public class ItemTopicsAdapter extends RecyclerView.Adapter<ItemTopicsAdapter.ItemTopicViewHolder>{
    Context context;
    ArrayList<ItemTopicsModel> itemTopicsModels;

    public ItemTopicsAdapter(Context context, ArrayList<ItemTopicsModel> itemTopicsModels){
        this.context = context;
        this.itemTopicsModels = itemTopicsModels;
    }

    @NonNull
    @Override
    public ItemTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic,null);
        return new ItemTopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTopicViewHolder holder, int position) {
        ItemTopicsModel model = itemTopicsModels.get(position);
        holder.itemTopicView.setText(model.getItemTopicView());
        holder.questionSolvedView.setText(model.getQuestionSolvedView());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra("topicId", model.getTopicId());
                intent.putExtra("categoryId", model.getBelongsCategory());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemTopicsModels.size();
    }

    public class ItemTopicViewHolder extends RecyclerView.ViewHolder{
        TextView itemTopicView, questionSolvedView;
        public ItemTopicViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTopicView = itemView.findViewById(R.id.topicNameView);
            questionSolvedView = itemView.findViewById(R.id.questionSolvedView);
        }
    }
}
