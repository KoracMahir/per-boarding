package com.example.petboarding.jobs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petboarding.R;

import java.util.List;

public class JobAdapter extends BaseAdapter {

    private List<Job> jobList;
    private Context context;

    public JobAdapter(Context context, List<Job> jobList){
        this.context = context;
        this.jobList = jobList;
    }

    @Override
    public int getCount() {
        return jobList.size();
    }

    @Override
    public Object getItem(int i) {
        return jobList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return jobList.indexOf(jobList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.job_layout_item, viewGroup, false);
        Job job = (Job) getItem(i);

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
