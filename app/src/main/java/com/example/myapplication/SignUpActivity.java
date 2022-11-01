package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

public class SignUpActivity extends Activity {

    private Context context;

    private ImageButton buttonBack;

    private EditText getName;
    private EditText getPhoneNumber;
    private EditText getAddress;
    private EditText getId;
    private EditText getPassword;

    private RadioButton getAgree;
    private RadioButton getDisagree;

    private AppCompatButton buttonSubmit;

    private boolean submitValid = false;

    int cnt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        context = this;

        SharedPreferences pref = context.getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        cnt = pref.getInt("count", 0);



        buttonBack = (ImageButton) findViewById(R.id.btn_back);

        getName = (EditText) findViewById(R.id.get_name);
        getPhoneNumber = (EditText) findViewById(R.id.get_phone_number);
        getAddress = (EditText) findViewById(R.id.get_address);
        getId = (EditText) findViewById(R.id.get_id);
        getPassword = (EditText) findViewById(R.id.get_password);

        getAgree = (RadioButton) findViewById(R.id.agree);
        getDisagree = (RadioButton) findViewById(R.id.disagree);

        buttonSubmit = (AppCompatButton) findViewById(R.id.btn_submit);



        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitValid = true;
                buttonSubmit.setBackgroundDrawable(getDrawable(R.drawable.button_valid));
            }
        });

        getDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitValid = false;
                buttonSubmit.setBackgroundDrawable(getDrawable(R.drawable.button_basic));
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (submitValid) {
                    String name = getName.getText().toString();
                    String phone = getPhoneNumber.getText().toString();
                    String address = getAddress.getText().toString();
                    String id = getId.getText().toString();
                    String password = getPassword.getText().toString();
                    cnt += 1;
                    Log.d("cnt", "cnt : " + cnt);
                    editor.putInt("count", cnt);
                    editor.putString("userName" + cnt, name);
                    editor.putString("userPhone" + cnt, phone);
                    editor.putString("userAddress" + cnt, address);
                    editor.putString("userId" + cnt, id);
                    editor.putString("userPassword" + cnt, password);

                    editor.commit();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"빈 칸 없이 입력하고, 개인 정보 이용에 동의해 주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
