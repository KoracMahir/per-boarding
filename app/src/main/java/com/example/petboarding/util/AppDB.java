package com.example.petboarding.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.petboarding.jobs.Job;
import com.example.petboarding.jobs.JobDao;
import com.example.petboarding.posts.Post;
import com.example.petboarding.posts.PostDao;
import com.example.petboarding.user.User;
import com.example.petboarding.user.UserDao;

@Database(entities={User.class, Job.class, Post.class},version=1,exportSchema = false)
public abstract class AppDB extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract JobDao jobDao();
    public abstract PostDao postDao();

    public static AppDB INSTANCE = null;

    public static AppDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDB.class, "appdb1").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
