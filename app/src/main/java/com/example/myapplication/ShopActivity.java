package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ShopActivity extends AppCompatActivity {

    private AppCompatButton userInfo;
    private AppCompatButton registerItem;
    private Context context;
    int cnt;
    String userInfoMessage;


    String userId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        userId = getIntent().getStringExtra("userId");
        Log.d("userId", userId);


        context = this;
        SharedPreferences pref = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        String name = pref.getString("userName" + userId, "");
        String phone = pref.getString("userPhone" + userId, "");
        String address = pref.getString("userAddress" + userId, "");
        String id = pref.getString("userId" + userId, "");
        String password = pref.getString("userPassword" + userId, "");
        userInfoMessage = "유저 정보 \n이름 = " + name + ", 전화번호 : " + phone + ", 주소 : " + address + ", 아이디 : " + id;

        userInfo = (AppCompatButton) findViewById(R.id.btn_user_info);
        registerItem = (AppCompatButton) findViewById(R.id.btn_register);


        userInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserInfoHandler(view);
            }
        });

        registerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerItem(view);
            }
        });
    }

    private void showUserInfoHandler(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("회원 정보");
        if(userId.equals("-1")) {
            builder.setMessage("회원가입을 하시겠습니까?");
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                    finish();
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("아니오",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            builder.show();
        } else {

            builder.setMessage(userInfoMessage);
            builder.setPositiveButton("예",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            builder.show();
        }
    }

    private void registerItem(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(userId.equals("-1")) {
            builder.setTitle("회원가입 후 사용할 수 있는 서비스 입니다.");
            builder.setMessage("회원가입을 하시겠습니까?");
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                    finish();
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("아니오",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            builder.show();
        } else {
            builder.setTitle("상품 등록하기");
            builder.setMessage("아직 준비되지 않은 서비스입니다.");
            builder.setPositiveButton("예",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            builder.show();
        }
    }

}
