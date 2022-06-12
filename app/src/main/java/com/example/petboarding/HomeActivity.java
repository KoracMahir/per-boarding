package com.example.petboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.example.petboarding.home.HomeFragment;
import com.example.petboarding.home.PostsFragment;
import com.example.petboarding.home.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    Button home,posts,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home = findViewById(R.id.home);
        posts = findViewById(R.id.active_posts);
        profile = findViewById(R.id.profile);

        HomeFragment homeFragment = new HomeFragment();
        PostsFragment postsFragment = new PostsFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_home, homeFragment).commit();

        home.setOnClickListener(view-> {
            home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#559BD3")));
            posts.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            profile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_home, homeFragment).commit();
        });
        posts.setOnClickListener(view-> {
            home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            posts.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#559BD3")));
            profile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_home, postsFragment).commit();
        });
        profile.setOnClickListener(view-> {
            home.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            posts.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFF9B100")));
            profile.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#559BD3")));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_home, profileFragment).commit();
        });
    }
}