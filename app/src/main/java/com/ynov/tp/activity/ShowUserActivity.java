package com.ynov.tp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ynov.tp.R;
import com.ynov.tp.bo.User;
import com.ynov.tp.databinding.ActivityShowUserBinding;

public class ShowUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_user);
        User myUser = new User(
                "shrek8",
                "shrek8@swamp.com"
        );
    }
}