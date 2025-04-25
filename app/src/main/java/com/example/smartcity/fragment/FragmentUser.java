package com.example.smartcity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.smartcity.R;
import com.example.smartcity.utils.Data;
import com.example.smartcity.utils.Utils;
import com.example.smartcity.utils.gson.UserInfoGson;
import com.google.gson.Gson;

import org.json.JSONObject;

public class FragmentUser extends Fragment {

    LinearLayout linearLayout;

    void  init(View view){
        linearLayout = view.findViewById(R.id.user_ll1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_user,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);


    }
void getData(){
        if (Data.userInfoGson!=null){

        }else {
            Utils utils = new Utils();
            utils.PostHttp(Utils.homeUrl + Utils.userInfo, new JSONObject(), new Utils.MyCallBAck() {
                @Override
                public void getBody(String body) {
                    Data.userInfoGson = new Gson().fromJson(body, UserInfoGson.class);


                }
            });

        }
}
void setData{

    }
}
