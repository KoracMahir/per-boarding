package com.example.petboarding.jobs;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "jobs")
public class Job {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String jobTitle;
    private String jobDescription;
    private String jobOwner;
    private String date;
    private int pricePerHour;

    @Ignore
    public Job(String jobTitle, String jobDescription, String jobOwner, String date, int pricePerHour) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobOwner = jobOwner;
        this.date = date;
        this.pricePerHour = pricePerHour;
    }

    public Job(int id, String jobTitle, String jobDescription, String jobOwner, String date, int pricePerHour) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobOwner = jobOwner;
        this.date = date;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobOwner() {
        return jobOwner;
    }

    public void setJobOwner(String jobOwner) {
        this.jobOwner = jobOwner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
