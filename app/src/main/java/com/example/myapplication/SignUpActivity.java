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

import java.util.regex.Pattern;

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

    private boolean isAgree = false;
    private boolean isValidName = false;
    private boolean isValidPhoneNumber = false;
    private boolean isValidAddress = false;
    private boolean isValidId = false;
    private boolean isValidPassword = false;



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
                isAgree = true;
                buttonSubmit.setBackgroundDrawable(getDrawable(R.drawable.button_valid));
            }
        });

        getDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAgree = false;
                buttonSubmit.setBackgroundDrawable(getDrawable(R.drawable.button_basic));
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAgree && isValidName && isValidPhoneNumber && isValidAddress && isValidId && isValidPassword) {
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
                    Toast.makeText(getApplicationContext(),"양식에 맞게 모두 입력해 주시고, 개인 정보 이용에 동의해 주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        getName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                } else {
                    String name = getName.getText().toString();
                    name.replaceAll(" ", "");
                    if (!name.equals("")) {
                        isValidName = true;
                    } else {
                        Toast.makeText(getApplicationContext(),"이름을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        getPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                } else {
                    String phone = getPhoneNumber.getText().toString();
                    phone.replaceAll(" ", "");
                    isValidPhoneNumber = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", phone);
                }
                if (!isValidPhoneNumber) {
                    Toast.makeText(getApplicationContext(),"전화번호가 유효하지 않습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        getAddress.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                } else {
                    String address = getAddress.getText().toString();
                    address.replaceAll(" ", "");
                    if (!address.equals("")) {
                        isValidAddress = true;
                    } else {
                        Toast.makeText(getApplicationContext(),"주소를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        getId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                } else {
                    String id = getId.getText().toString();
                    id.replaceAll(" ", "");
                    boolean isRepeatId = false;
                    for (int i=1; i <= cnt; i++) {
                        if (pref.getString("userId" + i, "").equals(id)) {
                            isRepeatId = true;
                            break;
                        }
                    }
                    if (isRepeatId) {
                        Toast.makeText(getApplicationContext(),"중복된 아이디입니다. 다른 아이디를 사용해 주세요.",Toast.LENGTH_SHORT).show();
                        isValidId = false;
                    }
                    else
                        isValidId = true;
                }
            }
        });

        getPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {

                } else {
                    String password = getPassword.getText().toString();
                    isValidPassword = Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{6,15}.$", password);
                }
                if (!isValidPassword)
                    Toast.makeText(getApplicationContext(),"올바르지 않은 비밀번호 양식입니다.",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
