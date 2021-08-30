package com.example.project2;

//User.java
//The purpose of this class is to store usernames and passwords into a user database.
//Jamielle Maniulit
//12-16-2020

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;

    @ColumnInfo(name="username")
    private String user;

    @ColumnInfo(name="password")
    private String pass;

    public User(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getUser(){
        return user;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public String getPass(){
        return pass;
    }

    @Override
    public String toString(){
        return user;
    }

}
