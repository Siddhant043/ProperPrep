package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.properprepapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("", "Mathematics", " "));
        categories.add(new CategoryModel("", "Physics", " "));
        categories.add(new CategoryModel("", "Chemistry", " "));
        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        binding.pacticeCategoryList.setLayoutManager(new GridLayoutManager(this, 1));
        binding.pacticeCategoryList.setAdapter(adapter);
    }
}