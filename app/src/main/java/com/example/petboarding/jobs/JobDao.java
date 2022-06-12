package com.example.petboarding.jobs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.petboarding.user.User;

import java.util.List;

@Dao
public interface JobDao {

    @Insert
    public void addJob(Job job);

    @Query("SELECT * FROM jobs WHERE id=(:id) LIMIT 1")
    Job getJobByID(int id);

    @Query("SELECT * FROM jobs")
    List<Job> getAll();


}

