package com.zeomawer.demoq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegisterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        getSupportActionBar().setTitle("Registration Form");
    }
}