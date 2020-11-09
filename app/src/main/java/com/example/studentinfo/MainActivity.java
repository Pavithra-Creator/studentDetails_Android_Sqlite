package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button addpage;
    DbHelper dbHelper;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DbHelper(getApplicationContext());
        List<StudentModel> list = dbHelper.getStudentdetails();

        recyclerAdapter = new RecyclerAdapter(this, list);
        recyclerView.setAdapter(recyclerAdapter);

        Log.d("TAG", "onCreate: "+list);

        addpage = findViewById(R.id.addButton);
        addpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddDetails.class);
                startActivity(intent);
            }
        });
    }
}