package com.example.petboarding.user;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    public void addUser(User user);

    @Update
    public void updateUser(User user);

    @Query("SELECT users.id FROM users WHERE username=(:username) LIMIT 1")
    int getUserIdByUsername(String username);

    @Query("SELECT * FROM users WHERE id=(:id) LIMIT 1")
    User getUserIdByID(int id);

    @Query("SELECT * FROM users WHERE email=(:email) AND password=(:password) LIMIT 1")
    User checkLogin(String email, String password);


}
