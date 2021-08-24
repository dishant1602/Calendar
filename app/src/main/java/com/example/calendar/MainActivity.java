package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView textView;
    Button button,button1;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView3);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd/M/yyyy");
        value = simpleDateFormat.format(calendar.getTime());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                value = dayOfMonth + "/" + (month+1) + "/" + year;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Date",value);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,MainActivity3.class);
                intent3.putExtra("Date",value);
                startActivity(intent3);
            }
        });
    }
}