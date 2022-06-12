package com.example.petboarding.posts;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts")
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String postTitle;
    private String postDescription;
    private String postImageUrl;
    private int upVotes;

    @Ignore
    public Post(String postTitle, String postDescription, String postImageUrl) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImageUrl = postImageUrl;
    }


    public Post(int id, String postTitle, String postDescription, String postImageUrl, int upVotes) {
        this.id = id;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImageUrl = postImageUrl;
        this.upVotes = upVotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }
}
