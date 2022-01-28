package com.ynov.tp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ynov.tp.R;

public class FindCitiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cities);
        //ActivityShowCitiesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_housings);
    }
}