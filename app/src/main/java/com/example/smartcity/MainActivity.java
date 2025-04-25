package com.example.smartcity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.smartcity.fragment.FragmentHome;
import com.example.smartcity.fragment.FragmentMsg;
import com.example.smartcity.fragment.FragmentScene;
import com.example.smartcity.fragment.FragmentUser;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll1, ll2, ll3, ll4;
    ImageView img1, img2, img3, img4;
    Fragment fragment1, fragment2, fragment3, fragment4;

    void init() {
        ll1 = findViewById(R.id.ll_home);
        ll2 = findViewById(R.id.ll_scene);
        ll3 = findViewById(R.id.ll_msg);
        ll4 = findViewById(R.id.ll_user);

        img1 = findViewById(R.id.img_home);
        img2 = findViewById(R.id.img_scene);
        img3 = findViewById(R.id.img_msg);
        img4 = findViewById(R.id.img_user);

        fragment1 = new FragmentHome();
        fragment2 = new FragmentScene();
        fragment3 = new FragmentMsg();
        fragment4 = new FragmentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        init();

        getFragmentManager().beginTransaction().add(R.id.main_flayout, fragment1)
                .add(R.id.main_flayout, fragment2)
                .hide(fragment2)
                .add(R.id.main_flayout, fragment3)
                .hide(fragment3)
                .add(R.id.main_flayout, fragment4)
                .hide(fragment4)
                .commitAllowingStateLoss();

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().show(fragment1)
                        .hide(fragment2)
                        .hide(fragment3)
                        .hide(fragment4)
                        .commitAllowingStateLoss();

                setImg();
                img1.setImageResource(R.drawable.ic_home);
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().show(fragment2)
                        .hide(fragment1)
                        .hide(fragment3)
                        .hide(fragment4)
                        .commitAllowingStateLoss();

                setImg();
                img2.setImageResource(R.drawable.ic_scene);
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().show(fragment3)
                        .hide(fragment2)
                        .hide(fragment1)
                        .hide(fragment4)
                        .commitAllowingStateLoss();

                setImg();
                img3.setImageResource(R.drawable.ic_msg);
            }
        });
        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().show(fragment4)
                        .hide(fragment2)
                        .hide(fragment3)
                        .hide(fragment1)
                        .commitAllowingStateLoss();

                setImg();
                img4.setImageResource(R.drawable.ic_user);
            }
        });
    }

    void setImg() {
        img1.setImageResource(R.drawable.ic_home_light);
        img2.setImageResource(R.drawable.ic_scene_light);
        img3.setImageResource(R.drawable.ic_msg_light);
        img4.setImageResource(R.drawable.ic_user_light);
    }
}