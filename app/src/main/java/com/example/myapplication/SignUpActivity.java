package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.appcompat.widget.AppCompatButton;

public class SignUpActivity extends Activity {

    private ImageButton buttonBack;

    private EditText getName;
    private EditText getPhoneNumber;
    private EditText getAddress;
    private EditText getId;
    private EditText getPassword;

    private RadioGroup getAgree;
    private AppCompatButton buttonSubmit;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        buttonBack = (ImageButton) findViewById(R.id.btn_back);

        getName = (EditText) findViewById(R.id.get_name);
        getPhoneNumber = (EditText) findViewById(R.id.get_phone_number);
        getAddress = (EditText) findViewById(R.id.get_address);
        getId = (EditText) findViewById(R.id.get_id);
        getPassword = (EditText) findViewById(R.id.get_password);

        buttonSubmit = (AppCompatButton) findViewById(R.id.btn_submit);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
