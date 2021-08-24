package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView9,textView10,textView11,textView12;
    GifImageView chef;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent3 = getIntent();
        String p = intent3.getStringExtra("Date");
        setContentView(R.layout.activity_main3);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        chef = findViewById(R.id.chef);
        List<String> listwo = new ArrayList<>();
        verifier alpha = new verifier(MainActivity3.this);
        String s = alpha.outputdata(p);
        textView9.setVisibility(View.GONE);
        textView10.setVisibility(View.GONE);
        textView11.setVisibility(View.GONE);
        textView12.setVisibility(View.GONE);
        chef.setVisibility(View.GONE);
        if(s.equals("y")){
            textView12.setVisibility(View.VISIBLE);
            textView12.setText("No events available on this date");
            chef.setVisibility(View.VISIBLE);
        }
        else{
            String str[] = s.split(",");
            for(int i=0;i<str.length;i++){
                listwo.add(str[i]);
            }
            textView9.setVisibility(View.VISIBLE);
            textView10.setVisibility(View.VISIBLE);
            textView11.setVisibility(View.VISIBLE);
            textView9.setText(listwo.get(0));
            textView10.setText(listwo.get(1));
            textView11.setText(listwo.get(2));

        }
    }
}