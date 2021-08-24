package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.archit.calendardaterangepicker.customviews.CalendarListener;
import com.archit.calendardaterangepicker.customviews.DateRangeCalendarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    Button button2;
    TextView textView,textView13,textView14;
    EditText editText,editText2;
    StringBuilder stringBuilder;
    int t1,t2;
    String AM_PM;
    ImageView imageView;
    DateRangeCalendarView ranger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2=findViewById(R.id.button2);
        textView=findViewById(R.id.textView8);
        editText=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName3);
        textView13=findViewById(R.id.textView13);
        textView14=findViewById(R.id.textView14);
        imageView=findViewById(R.id.imageView);
        ranger=findViewById(R.id.ranger);
        HashMap<String,String> hashMap = new HashMap<>();
        ranger.setVisibility(View.GONE);
        List<String> listone = new ArrayList<>();
        Intent intent = getIntent();
        String p = intent.getStringExtra("Date");
        String month[] = p.split("/");
        int f = Integer.parseInt(month[1]);
        if(f==1){
            month[1]="January";
        }
        else if(f==2){
            month[1]="February";
        }
        else if(f==3){
            month[1]="March";
        }
        else if(f==4){
            month[1]="April";
        }
        else if(f==5){
            month[1]="May";
        }
        else if(f==6){
            month[1]="June";
        }
        else if(f==7){
            month[1]="July";
        }
        else if(f==8){
            month[1]="August";
        }
        else if(f==9){
            month[1]="September";
        }
        else if(f==10){
            month[1]="October";
        }
        else if(f==11){
            month[1]="November";
        }
        else if(f==12){
            month[1]="December";
        }
        textView.setText(month[0]+" "+month[1]+" "+month[2]);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText.getText().toString();
                String desc = editText2.getText().toString();
                listone.add(p);
                listone.add(title);
                listone.add(desc);
                stringBuilder = new StringBuilder();
                for(String s : listone){
                    stringBuilder.append(s);
                    stringBuilder.append(",");
                }
                String f = stringBuilder.toString();
                verifier delta = new verifier(MainActivity2.this);
                delta.inpudata(p,f);
                Intent intent3 = new Intent(MainActivity2.this,MainActivity.class);
                finish();
            }
        });

        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1=hourOfDay;
                        t2=minute;
                        String x = String.format(Locale.getDefault(),"%02d:%02d",t1,t2);
                        String hr12[] = x.split(":");
                        int g = Integer.parseInt(hr12[0]);
                        if(g>12){
                            hr12[0]=Integer.toString((g-12));
                            AM_PM="PM";
                        }
                        else if(g==12){
                            AM_PM="PM";
                        }
                        else if(g==0){
                            AM_PM="AM";
                            hr12[0]=Integer.toString(12);
                        }
                        else{
                            AM_PM="AM";
                        }
                        textView13.setText(hr12[0]+":"+hr12[1]+"    "+AM_PM);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,onTimeSetListener,t1,t2,false);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1=hourOfDay;
                        t2=minute;
                        String x = String.format(Locale.getDefault(),"%02d:%02d",t1,t2);
                        String hr12[] = x.split(":");
                        int g = Integer.parseInt(hr12[0]);
                        if(g>12){
                            hr12[0]=Integer.toString((g-12));
                            AM_PM="PM";
                        }
                        else if(g==12){
                            AM_PM="PM";
                        }
                        else if(g==0){
                            AM_PM="AM";
                            hr12[0]=Integer.toString(12);
                        }
                        else{
                            AM_PM="AM";
                        }
                        textView14.setText(hr12[0]+":"+hr12[1]+"    "+AM_PM);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,onTimeSetListener,t1,t2,false);

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ranger.setVisibility(View.VISIBLE);
                ranger.setCalendarListener(new CalendarListener() {
                    @Override
                    public void onFirstDateSelected(Calendar startDate) {
                        Toast.makeText(MainActivity2.this, "Start Date: " + startDate.getTime().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
                        Toast.makeText(MainActivity2.this, "Start Date: " + startDate.getTime().toString() + " End date: " + endDate.getTime().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}