package com.example.properprepapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    ArrayList<CategoryModel> categoryModels;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryModels){
        this.context = context;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, null);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel model = categoryModels.get(position);
        holder.categoryItemHeading.setText(model.getCategoryName());

        //using glide to handle image input
        Glide.with(context)
                .load(model.getCategoryImage())
                .into(holder.categoryItemImage);
        holder.categoryItemPracticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), QuizActivity.class);
                intent.putExtra("categoryId", model.getCategoryId()); // passing the value of categoryItemHeading to the next activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryItemImage;
        TextView categoryItemHeading;
        Button categoryItemPracticeButton;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryItemImage = itemView.findViewById(R.id.categoryItemImage);
            categoryItemHeading = itemView.findViewById(R.id.categoryItemHeading);
            categoryItemPracticeButton = itemView.findViewById(R.id.categoryItemPracticeButton);
        }
    }
}
