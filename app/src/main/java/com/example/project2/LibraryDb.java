package com.example.project2;

//LibraryDb.java
//The purpose of this class is to create a library database that stores user and book information.
//Jamielle Maniulit
//12-16-2020

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Book.class, User.class}, version = 1, exportSchema = false)

public abstract class LibraryDb extends RoomDatabase{
    private static LibraryDb sInstance;

//    public BookDao book() {
//        return null;
//    }

    public abstract BookDao book();
    public abstract UserDao user();
    public abstract TransactionDao trans();


    public static synchronized LibraryDb getInstance(Context context) {
        if(sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    LibraryDb.class,
                    "library.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void seed(){
        if(book().count() == 0){
            Book b1 = new Book(
                "I Know Why the Caged Bird Sings",
                "Maya Angelou",
                "Memoir"
            );

            Book b2 = new Book(
                    "The Mythical Man-Month",
                    "Frederick Brooks",
                    "Computer Science"
            );

            Book b3 = new Book(
                    "Frankenstein",
                    "Mary Shelley",
                    "Fiction"
            );

            long[] book_ids = book().insertBooks(b1,b2,b3);

        }

        if(user().count() == 0){
            User u1 = new User(
                    "a@lice5",
                    "@csit100"
            );

            User u2 = new User(
                    "$brian7",
                    "123abc##"
            );

            User u3 = new User(
                    "!chris12!",
                    "CHRIS12!!"
            );

            long[] user_ids = user().insertUser(u1,u2,u3);
        }
    }
}
