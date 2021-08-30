package com.example.project2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select count(*) from users")
    int count();

    @Insert
    long addUser(User user);

    @Insert
    long[] insertUser(User... users);

    @Query("SELECT * FROM users")
    List <User> getAllUsers();

    @Query("SELECT * FROM users WHERE username = :user")
    List<User> findByUser(String user);

}
