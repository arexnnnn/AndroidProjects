package com.hxruchiyo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtAnim;
    Button btnTranslate, btnRotate, btnScale, btnAlpha;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnim = findViewById(R.id.txtAnim);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnScale = findViewById(R.id.btnScale);
        btnTranslate = findViewById(R.id.btnTranslate);
        btnRotate = findViewById(R.id.btnRotate);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                txtAnim.startAnimation(alpha);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                txtAnim.startAnimation(scale);
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                txtAnim.startAnimation(move);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                txtAnim.startAnimation(rotate);
            }
        });
    }
}