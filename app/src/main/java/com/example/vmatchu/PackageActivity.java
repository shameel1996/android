package com.example.vmatchu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.example.vmatchu.Adpaters.PropertyAdapter;
import com.example.vmatchu.Adpaters.packageAdapter;
import com.example.vmatchu.Classes.PackageDetails;

import java.util.ArrayList;

public class PackageActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<PackageDetails> packagResponse;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);





        recyclerView = (RecyclerView) findViewById(R.id.recyclePackage);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PackageActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new packageAdapter(arrayAdapter, PackageActivity.this, packagResponse);
        recyclerView.setAdapter(adapter);

    }
}
