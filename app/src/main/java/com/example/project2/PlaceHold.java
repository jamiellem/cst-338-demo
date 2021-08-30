package com.example.project2;

//PlaceHold.java
//The purpose of this class is to output the different genres using a drop down menu, showcasing
//different books, and allowing the user to checkout those books.
//Jamielle Maniulit
//12-16-2020


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class PlaceHold extends AppCompatActivity implements View.OnClickListener {
    private LibraryDb db;
    private static final String TAG="Placehold";

    private ListView bookListView;
    private List<Book> bookList;

    private ArrayAdapter<Book> genreAdapter;
    private ArrayAdapter<Book> bookAdapter;

    private Spinner genreSpinner;
    private String selectedGenre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold);

        View checkoutBtn = findViewById(R.id.checkout_btn);
        checkoutBtn.setOnClickListener(this);

        db = LibraryDb.getInstance(this);
        bookList = db.book().getAllBooks();

        genreSpinner = findViewById(R.id.genre_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genre_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genreSpinner.setAdapter(adapter);
        genreSpinner.setSelection(0,false);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGenre = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG,selectedGenre);
                bookList = db.book().findByGenre(selectedGenre);
                Log.d(TAG, bookList.toString());
                bookListView = findViewById(R.id.list_books);
                updateUI(selectedGenre);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });

    }

    private void updateUI(String genre) {
        bookList = db.book().getAllBooks();
        if (bookAdapter == null) {
            bookAdapter = new ArrayAdapter<>(this, R.layout.item_book,
                    R.id.book_title, bookList); bookListView.setAdapter(bookAdapter);
        } else {
            bookAdapter.clear();
            bookAdapter.addAll(bookList);
            bookAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onClick(View v) {

        final EditText username = new EditText(this);
        final EditText password = new EditText(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");

        final View customLayout = getLayoutInflater().inflate(R.layout.custom_alert, null);
        builder.setView(customLayout);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                Log.d(TAG, "ok");
            };

        });

        AlertDialog loginDialog = builder.create();
        loginDialog.show();
    }
}