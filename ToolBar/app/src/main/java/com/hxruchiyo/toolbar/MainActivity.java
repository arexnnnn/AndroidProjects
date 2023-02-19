package com.hxruchiyo.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");
        }

        toolbar.setSubtitle("Subtitle");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.opt_new){
            Toast.makeText(this, "Created new file", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt_open){
            Toast.makeText(this, "File open", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt_save){
            super.onBackPressed();
        }  else{
            Toast.makeText(this, "File saved", Toast.LENGTH_SHORT).show();
        }
    }
}