package com.example.project2;

//MainActivity.java
//The purpose of this class is to serve as the homepage of the app and allow the user to choose
//click different buttons to login, checkout, or manage their system.
//Jamielle Maniulit
//12-16-2020

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View accBtn = findViewById(R.id.acc_btn);
        accBtn.setOnClickListener(this);

        View holdBtn = findViewById(R.id.hold_btn);
        holdBtn.setOnClickListener(this);

        View systemBtn = findViewById(R.id.system_btn);
        systemBtn.setOnClickListener(this);


    }

    public void onClick(View v){
        if(v.getId() == R.id.acc_btn){
            Intent i = new Intent(this, Account.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.hold_btn){
            Intent i = new Intent(this, PlaceHold.class);
            startActivity(i);
        }

    }

}