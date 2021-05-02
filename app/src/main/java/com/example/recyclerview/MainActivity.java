package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview.ModelClasses.ImageModel;
import com.example.recyclerview.ModelClasses.SimpleText_Model;
import com.example.recyclerview.MyAdapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Object> objectItemsList;
    RecyclerView objectRecyclerView;

    MyAdapter objectMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeValues();
        addData();

        objectMyAdapter = new MyAdapter(objectItemsList, this);
        objectRecyclerView.setAdapter(objectMyAdapter);

        objectRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initializeValues(){
        try {
            objectItemsList = new ArrayList<>();
            objectRecyclerView = findViewById(R.id.RV);
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void addData(){
        try {
            for (int cout = 0; cout < 5; cout++){
                objectItemsList.add(new SimpleText_Model("user name: " + cout, "email" + cout + "@email.com"));
                objectItemsList.add(new ImageModel(R.drawable.home));
            }
        } catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}