package com.example.trinitywizardstest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        login = findViewById(R.id.login_btn);
//        login.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Login.class)));

    }
}