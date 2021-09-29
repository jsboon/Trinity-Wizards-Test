    package com.example.trinitywizardstest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

    public class information extends AppCompatActivity {

    TextView firstName, lastName, email, phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        firstName = findViewById(R.id.if_firstname);
        lastName = findViewById(R.id.if_lastName);
        email = findViewById(R.id.if_email);
        phoneNum = findViewById(R.id.if_phone);

        firstName.setText(getIntent().getStringExtra("first_name"));
        lastName.setText(getIntent().getStringExtra("last_name"));
        email.setText(getIntent().getStringExtra("email"));
        phoneNum.setText(getIntent().getStringExtra("phone_num"));


    }
}