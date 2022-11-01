package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText getId;
    private EditText getPassword;

    private AppCompatButton login;
    private AppCompatButton signUp;
    private AppCompatButton start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getId = (EditText) findViewById(R.id.get_id);
        getPassword = (EditText) findViewById(R.id.get_password);
        login = (AppCompatButton) findViewById(R.id.btn_login);
        signUp = (AppCompatButton) findViewById(R.id.btn_sign_up);
        start = (AppCompatButton) findViewById(R.id.btn_start);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState == null) {
            SharedPreferences s = getSharedPreferences("person_info", 0);
            String name = s.getString("name", "");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}