package com.example.smartcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    TextView textView, btnLogin;
    EditText edName, edPwd;
    String strName, strPwd;


    void init() {
        textView = findViewById(R.id.toRegis);
        btnLogin = findViewById(R.id.btn_login);
        edName = findViewById(R.id.login_username);
        edPwd = findViewById(R.id.login_password);
    }

    void getStrData() {
        strName = edName.getText().toString();
        strPwd = edPwd.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        init();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getStrData();
                Utils utils = new Utils();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.putOpt("username", strName);
                    jsonObject.putOpt("password", strPwd);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                utils.PostHttp(Utils.homeUrl + Utils.loginUrl, jsonObject, new Utils.MyCallBAck() {
                    @Override
                    public void getBody(String body) {
                        try {
                            JSONObject object = new JSONObject(body);
                            if (object.getString("code").equals("200")) {
                                Toast.makeText(getApplicationContext(), object.getString("msg"), Toast.LENGTH_SHORT).show();
                                JSONObject object1 = object.getJSONObject("data");
                                Utils.Token = object1.getString("token");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), object.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });

    }
}