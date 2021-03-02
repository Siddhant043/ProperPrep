package com.example.properprepapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.properprepapp.databinding.ActivityItemTopicsBinding;

import java.util.ArrayList;

public class ItemTopicsActivity extends AppCompatActivity {

    ActivityItemTopicsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_topics);
        binding = ActivityItemTopicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //getting the extra items passed from previous activity
        Bundle bn = getIntent().getExtras();
        String heading = bn.getString("heading");

        binding.itemTopicHeading.setText(heading);

        //creating arrayList for particular categories based on their headings

        if(heading.equals("Physics")){
            ArrayList<ItemTopicsModel> itemTopics = new ArrayList<>();
            itemTopics.add(new ItemTopicsModel("1. Any physics topic", "Questions solved: 0/25"));

            ItemTopicsAdapter adapter = new ItemTopicsAdapter(this, itemTopics);
            binding.itemTopicsList.setLayoutManager(new GridLayoutManager(this, 1));
            binding.itemTopicsList.setAdapter(adapter);
        }else if(heading.equals("Chemistry")){
            ArrayList<ItemTopicsModel> itemTopics = new ArrayList<>();
            itemTopics.add(new ItemTopicsModel("1. Any chemistry topic", "Questions solved: 0/25"));

            ItemTopicsAdapter adapter = new ItemTopicsAdapter(this, itemTopics);
            binding.itemTopicsList.setLayoutManager(new GridLayoutManager(this, 1));
            binding.itemTopicsList.setAdapter(adapter);
        }else if(heading.equals("Mathematics")){
            ArrayList<ItemTopicsModel> itemTopics = new ArrayList<>();
            itemTopics.add(new ItemTopicsModel("1. Any mathematics topic", "Questions solved: 0/25"));

            ItemTopicsAdapter adapter = new ItemTopicsAdapter(this, itemTopics);
            binding.itemTopicsList.setLayoutManager(new GridLayoutManager(this, 1));
            binding.itemTopicsList.setAdapter(adapter);
        }else if(heading.equals("Biology")){
            ArrayList<ItemTopicsModel> itemTopics = new ArrayList<>();
            itemTopics.add(new ItemTopicsModel("1. Any biology topic", "Questions solved: 0/25"));

            ItemTopicsAdapter adapter = new ItemTopicsAdapter(this, itemTopics);
            binding.itemTopicsList.setLayoutManager(new GridLayoutManager(this, 1));
            binding.itemTopicsList.setAdapter(adapter);
        }else {
            Log.i("ArrayList Error", "Suitable heading not found.");
        }
    }
}