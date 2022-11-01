package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText getId;
    private EditText getPassword;
    private Context context;

    private AppCompatButton login;
    private AppCompatButton signUp;
    private AppCompatButton start;

//    MainActivity.context;



    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        context = this;

        SharedPreferences pref = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        getId = (EditText) findViewById(R.id.get_id);
        getPassword = (EditText) findViewById(R.id.get_password);
        login = (AppCompatButton) findViewById(R.id.btn_login);
        signUp = (AppCompatButton) findViewById(R.id.btn_sign_up);
        start = (AppCompatButton) findViewById(R.id.btn_start);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt = pref.getInt("count", 0);
                String id = getId.getText().toString();
                String password = getPassword.getText().toString();
                Log.i("x", "cnt : " + cnt);
                for (int i=1; i <= cnt; i++) {
                    if (pref.getString("userId" + i, "").equals(id)) {
                        Log.i("x", "success");
                        if (pref.getString("userPassword" + i, "").equals(password)) {
                            Toast.makeText(getApplicationContext(),"로그인 되었습니다. 상품 페이지로 이동합니다.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                            intent.putExtra("userId", i+"");
                            startActivity(intent);
                            break;
                        }
                    }
                }
                Toast.makeText(getApplicationContext(),"없는 유저입니다.\n아이디와 비밀번호를 다시 한 번 확인해 주세요.",Toast.LENGTH_SHORT).show();
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
                intent.putExtra("userId", -1+"");
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