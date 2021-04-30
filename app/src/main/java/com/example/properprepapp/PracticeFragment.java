package com.example.properprepapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.properprepapp.databinding.FragmentPracticeBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class PracticeFragment extends Fragment {


    public PracticeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentPracticeBinding binding;
    private FirebaseFirestore db; //declared firestore instance;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPracticeBinding.inflate(inflater, container, false);
        db = FirebaseFirestore.getInstance(); // initialized firestore instance

        ArrayList<CategoryModel> categories = new ArrayList<>();
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categories); //arraylist has been linked with the adapter(adapter adapts the data it receives and sends.)
        db.collection("categories")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        categories.clear(); //to clear old data and insert new data.
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            CategoryModel model = snapshot.toObject(CategoryModel.class); //creates Category model obj same from database
                            model.setCategoryId(snapshot.getId()); // sets the id of category
                            categories.add(model); //adds object to the arraylist
                        }
                        adapter.notifyDataSetChanged(); //helps in updating UI
                    }
                });
        binding.analyseProgressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnalyseProgressActivity.class);
                startActivity(intent);
            }
        });
        binding.pacticeCategoryList.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.pacticeCategoryList.setAdapter(adapter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}