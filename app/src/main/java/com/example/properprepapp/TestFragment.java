package com.example.properprepapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.properprepapp.databinding.FragmentTestBinding;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class TestFragment extends Fragment {



    public TestFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentTestBinding binding;
    FirebaseFirestore db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        db = FirebaseFirestore.getInstance();
        ArrayList<TestModel> tests = new ArrayList<>();
        TestListAdapter adapter = new TestListAdapter(getContext(), tests);

        //Getting tests from database

        db.collection("tests")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        tests.clear(); //to clear old data and insert new data.
                        for(DocumentSnapshot snapshot: value.getDocuments()){
                            TestModel model = snapshot.toObject(TestModel.class); /
                            model.setTestId(snapshot.getId());
                            tests.add(model); //adds object to the arraylist
                        }
                        adapter.notifyDataSetChanged(); //helps in updating UI
                    }
                });


       

        binding.testList.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.testList.setAdapter(adapter);

        binding.analyseTestsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnalyseTest.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}