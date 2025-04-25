package com.example.smartcity.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Utils {
    public static final MediaType JSON = MediaType.get("application/json;setchar=utf-8");
    Handler handler = new Handler(Looper.getMainLooper());
    private static final String Han = "authorization";
    public static String Token = "";

    public static final String homeUrl = "http://192.168.47.57";
    public static final String regsiUrl = "/rest/account/registAccount";
    public static final String loginUrl = "/rest/account/login";
    public static final String userInfo = "/rest/account/accountInfo";


    public interface MyCallBAck {
        void getBody(String body);
    }

    public void PostHttp(String url, JSONObject jsonObject, MyCallBAck callBAck) {
        RequestBody body = RequestBody.create(jsonObject.toString(), JSON);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header(Han, Token)
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("post错误", url, e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String body = response.body().string();
                handler.post(()->{
                    
                });
                handler.post(() -> callBAck.getBody(body));
            }
        });
    }



}
