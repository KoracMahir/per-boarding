package com.example.petboarding.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.petboarding.R;
import com.example.petboarding.jobs.Job;
import com.example.petboarding.util.AppDB;

public class JobDetailsFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_details, container, false);

        int id = getActivity().getIntent().getIntExtra("ID",-1);

        Job job = AppDB.getInstance(getContext()).jobDao().getJobByID(id);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView owner = view.findViewById(R.id.jobOwner);
        TextView price = view.findViewById(R.id.jobPrice);

        title.setText(job.getJobTitle());
        description.setText(job.getJobDescription());
        owner.setText(job.getJobOwner());
        price.setText("Price per hour: "+job.getPricePerHour());

        return view;
    }
}