package com.example.petboarding.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.petboarding.R;
import com.example.petboarding.details.JobDetailsFragment;
import com.example.petboarding.details.PostDetailsFragment;
import com.example.petboarding.jobs.Job;
import com.example.petboarding.util.AppDB;

public class AddNewActivity extends AppCompatActivity {

    View save;
    EditText title,description, owner,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        title=findViewById(R.id.jobTitle);
        description=findViewById(R.id.jobDescription);
        owner=findViewById(R.id.jobOwner);
        price=findViewById(R.id.pricePerHour);
        save =findViewById(R.id.save);
        save.setOnClickListener(view1-> {
            Job newJob = new Job(
                    title.getText().toString(),
                    description.getText().toString(),
                    owner.getText().toString(),
                    "",
                    Integer.parseInt(price.getText().toString())
            );
            AppDB.getInstance(this).jobDao().addJob(newJob);
            finish();
        });
    }
}