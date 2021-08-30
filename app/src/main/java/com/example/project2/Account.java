package com.example.project2;

//Account.java
//The purpose of this class is to allow the user to enter their username and password, and have verification
//of whether or not the system contains that username already.
//Jamielle Maniulit
//12-16-2020

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Account extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        View submitBtn = findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        EditText cin_user, cin_pass;

        cin_user = (EditText)findViewById(R.id.et_username);
        cin_pass =(EditText)findViewById(R.id.et_password);

        if(v.getId() == R.id.submit_btn){

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

}



