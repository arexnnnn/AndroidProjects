package com.hxruchiyo.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromActivity = getIntent();
        String title = fromActivity.getStringExtra("title");
        String Name = fromActivity.getStringExtra("Name");
        int standard = fromActivity.getIntExtra("Class", 0);     // Class can't be 0, always set the value that ain't possible.

        TextView txtStudentInfo;

        txtStudentInfo = findViewById(R.id.txtStudentInfo);

        txtStudentInfo.setText("Roll no: " +standard+ "Name" + Name);

        getSupportActionBar().setTitle(title);
    }
}