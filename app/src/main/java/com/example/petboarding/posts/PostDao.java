package com.example.petboarding.posts;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.petboarding.jobs.Job;

import java.util.List;

@Dao
public interface PostDao {

    @Insert
    public void addPost(Post post);

    @Query("SELECT * FROM posts WHERE id=(:id) LIMIT 1")
    Post getPostByID(int id);

    @Query("SELECT * FROM posts")
    List<Post> getAll();

    @Query("UPDATE posts SET upVotes=(:newUpvotes) WHERE id=(:id)")
    public void updateUpVotes(int newUpvotes, int id);
}
