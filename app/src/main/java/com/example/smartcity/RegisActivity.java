package com.example.smartcity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.internal.Util;

public class RegisActivity extends AppCompatActivity {
    EditText edName, edNickName, edPhon, edEmial, edPwd, edPwd2;
    TextView btnRegis;
    ImageView backlogin;

    String strName, strNickName, strPhon, strEmial, strPwd, strPwd2;


    void init() {
        edName = findViewById(R.id.regis_name);
        edNickName = findViewById(R.id.regis_nickname);
        edPhon = findViewById(R.id.regis_phon);
        edEmial = findViewById(R.id.regis_emial);
        edPwd = findViewById(R.id.regis_pwd);
        edPwd2 = findViewById(R.id.regis_pwd2);

        btnRegis = findViewById(R.id.btn_regis);

        backlogin = findViewById(R.id.back_login);
    }

    void getData() {
        strName = edName.getText().toString();
        strNickName = edNickName.getText().toString();
        strPhon = edPhon.getText().toString();
        strEmial = edEmial.getText().toString();
        strPwd = edPwd.getText().toString();
        strPwd2 = edPwd2.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        init();

        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Utils utils = new Utils();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.putOpt("username", strName);
                    jsonObject.putOpt("password", strPwd);
                    jsonObject.putOpt("nickname", strNickName);
                    jsonObject.putOpt("email", strEmial);
                    jsonObject.putOpt("phone", strPhon);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                utils.PostHttp(Utils.homeUrl + Utils.regsiUrl, jsonObject, new Utils.MyCallBAck() {
                    @Override
                    public void getBody(String body) {
                        try {
                            JSONObject object = new JSONObject(body);
                            if (object.getString("code").equals("200")){
                                Toast.makeText(getApplicationContext(),object.getString("msg"),Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getApplicationContext(),object.getString("msg"),Toast.LENGTH_SHORT).show();
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