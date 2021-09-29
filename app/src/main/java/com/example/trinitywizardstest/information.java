    package com.example.trinitywizardstest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class information extends AppCompatActivity {

    EditText firstName,lastName, email, phoneNum;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        firstName = findViewById(R.id.if_firstname);
        lastName = findViewById(R.id.if_lastName);
        email = findViewById(R.id.if_email);
        phoneNum = findViewById(R.id.if_phone);
        edit = findViewById(R.id.btn_edit);

        firstName.setText(getIntent().getStringExtra("first_name"));
        lastName.setText(getIntent().getStringExtra("last_name"));
        email.setText(getIntent().getStringExtra("email"));
        phoneNum.setText(getIntent().getStringExtra("phone_num"));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstName.setEnabled(true);
                lastName.setEnabled(true);
                email.setEnabled(true);
                phoneNum.setEnabled(true);

                firstName.requestFocus();
                firstName.setSelection(firstName.getText().length(), firstName.length());
                firstName.setNextFocusForwardId(R.id.if_lastName);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

                lastName.setSelection(lastName.getText().length(), lastName.length());
                lastName.setNextFocusForwardId(R.id.if_email);

                email.setSelection(email.getText().length(), email.length());
                email.setNextFocusForwardId(R.id.if_phone);

                phoneNum.setSelection(phoneNum.getText().length(), phoneNum.length());

            }
        });

    }
}