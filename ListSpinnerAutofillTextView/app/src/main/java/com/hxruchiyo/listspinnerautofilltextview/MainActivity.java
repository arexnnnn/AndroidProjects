package com.hxruchiyo.listspinnerautofilltextview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ListView listView;
ArrayList<String> al = new ArrayList<>();

Spinner spinner;
ArrayList<String> al2 = new ArrayList<>();

AutoCompleteTextView autoCompleteTextView;
ArrayList<String> al3 = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // List

        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");
        al.add("e");
        al.add("f");
        al.add("g");
        al.add("h");
        al.add("i");
        al.add("j");
        al.add("k");
        al.add("l");
        al.add("m");
        al.add("n");
        al.add("o");
        al.add("p");
        al.add("q");
        al.add("r");
        al.add("s");
        al.add("t");
        al.add("u");
        al.add("v");
        al.add("w");
        al.add("x");
        al.add("y");
        al.add("z");

        ArrayAdapter <String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, al);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "A is clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Spinner

        al2.add("1");
        al2.add("2");
        al2.add("3");
        al2.add("4");
        al2.add("5");
        al2.add("6");
        al2.add("7");
        al2.add("8");
        al2.add("9");
        al2.add("10");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, al2);
        spinner.setAdapter(spinnerAdapter);

        // Auto Complete TextView

        al3.add("i");
        al3.add("ii");
        al3.add("iii");
        al3.add("iv");
        al3.add("v");
        al3.add("vi");
        al3.add("vii");
        al3.add("viii");
        al3.add("ix");
        al3.add("x");

        ArrayAdapter<String> autoCompleteTextViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al3);
        autoCompleteTextView.setAdapter(autoCompleteTextViewAdapter);
        autoCompleteTextView.setThreshold(1);  // no. of words jiske bad autofill show hoga
    }
}