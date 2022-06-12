package com.example.petboarding.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petboarding.R;
import com.example.petboarding.home.ProfileFragment;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        JobDetailsFragment jobDetailsFragment = new JobDetailsFragment();
        PostDetailsFragment postDetailsFragment = new PostDetailsFragment();

        String type = getIntent().getStringExtra("DETAIL_TYPE");

        if(type.equals("JOB")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_details, jobDetailsFragment).commit();
        }else if(type.equals("POST")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_details, postDetailsFragment).commit();
        }

    }
}