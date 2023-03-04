package com.example.mvcactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import customClasses.customAdapter;
import modelData.profile;

public class MainActivity extends AppCompatActivity {

    ListView list;
    private static customAdapter adapter;
    ArrayList<profile> profileData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.profileList);
        adapter = new customAdapter(profileData, getApplicationContext());
        list.setAdapter(adapter);

    }


}