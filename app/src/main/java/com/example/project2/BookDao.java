package com.example.project2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Query("select count(*) from books")
    int count();

    @Insert
    long addBook(Book book);

    @Insert
    long[] insertBooks(Book... books);


    @Query("SELECT * FROM books")
    List <Book> getAllBooks();

    @Query("SELECT * FROM books WHERE genre = :genre")
    List<Book> findByGenre(String genre);

    @Query("SELECT * FROM books where title = :title")
    List<Book> findByTitle(String title);
}

