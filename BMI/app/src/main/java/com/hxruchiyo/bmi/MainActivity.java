package com.hxruchiyo.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightF, edtHeightI;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout ll;

        // R.id = resource ki id ke andar

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightF = findViewById(R.id.edtHeightF);
        edtHeightI = findViewById(R.id.edtHeightI);
        btnCalculate = findViewById(R.id.btnCalculateBMI);
        txtResult = findViewById(R.id.txtResult);
        ll = findViewById(R.id.ll);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightF.getText().toString());
                int in = Integer.parseInt(edtHeightI.getText().toString());

                int totalIn = ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You're Overweight");
                    ll.setBackgroundColor(getResources().getColor(R.color.OW));
                } else if(bmi<18){
                    txtResult.setText("You're Underweight");
                    ll.setBackgroundColor(getResources().getColor(R.color.UW));
                } else {
                    txtResult.setText("You're Healthy");
                    ll.setBackgroundColor(getResources().getColor(R.color.H));
                }
            }
        });

    }
}