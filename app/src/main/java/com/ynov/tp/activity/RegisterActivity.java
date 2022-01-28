package com.ynov.tp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ynov.tp.R;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onLoginClick(View v){
        Intent intentToFindCities = new Intent(this, FindCitiesActivity.class);
        startActivity(intentToFindCities);
    }
}