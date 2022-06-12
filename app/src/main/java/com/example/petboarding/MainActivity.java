package com.example.petboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashFragment splashFragment = new SplashFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, splashFragment).commit();

    }

}