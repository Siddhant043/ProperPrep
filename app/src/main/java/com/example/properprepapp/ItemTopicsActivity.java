package com.example.properprepapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.properprepapp.databinding.ActivityItemTopicsBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ItemTopicsActivity extends AppCompatActivity {

    ActivityItemTopicsBinding binding;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_topics);
        binding = ActivityItemTopicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();

        //getting the extra items passed from previous activity

        String categoryId = getIntent().getStringExtra("categoryId");



        //creating arrayList for particular categories based on their headings
        ArrayList<ItemTopicsModel> itemTopics = new ArrayList<>();
        ItemTopicsAdapter adapter = new ItemTopicsAdapter(this, itemTopics);

        switch (categoryId) {
            case "1":
                binding.itemTopicHeading.setText("Physics");
                db.collection("categories/1/topics").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        itemTopics.clear();
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            ItemTopicsModel model = snapshot.toObject(ItemTopicsModel.class);
                            model.setTopicId(snapshot.getId());
                            model.setBelongsCategory(categoryId);
                            itemTopics.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
            case "2":
                binding.itemTopicHeading.setText("Chemistry");
                db.collection("categories/2/topics").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        itemTopics.clear();
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            ItemTopicsModel model = snapshot.toObject(ItemTopicsModel.class);
                            model.setTopicId(snapshot.getId());
                            model.setBelongsCategory(categoryId);
                            itemTopics.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
            case "3":
                binding.itemTopicHeading.setText("Mathematics");
                db.collection("categories/3/topics").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        itemTopics.clear();
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            ItemTopicsModel model = snapshot.toObject(ItemTopicsModel.class);
                            model.setTopicId(snapshot.getId());
                            model.setBelongsCategory(categoryId);
                            itemTopics.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
            case "4":
                binding.itemTopicHeading.setText("Biology");
                db.collection("categories/4/topics").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        itemTopics.clear();
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            ItemTopicsModel model = snapshot.toObject(ItemTopicsModel.class);
                            model.setTopicId(snapshot.getId());
                            model.setBelongsCategory(categoryId);
                            itemTopics.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                break;
        }

        binding.itemTopicsList.setLayoutManager(new GridLayoutManager(this, 1));
        binding.itemTopicsList.setAdapter(adapter);

    }
}