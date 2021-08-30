package com.example.project2;

//Book.java
//The purpose of this class is to store book titles and authors into a database.
//Jamielle Maniulit
//12-16-2020

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int bookId;

    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name="author")
    private String author;

    @ColumnInfo(name="genre")
    private String genre;

    public Book(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    @Override
    public String toString() {
        return title + ", " + author ;
    }
}
