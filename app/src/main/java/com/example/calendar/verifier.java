package com.example.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class verifier {

    SharedPreferences shrd;
    SharedPreferences.Editor editor;
    Context context;

    @SuppressLint("CommitPrefEdits")
    public verifier(Context _context){
        context = _context;
        shrd = _context.getSharedPreferences("dishant",Context.MODE_PRIVATE);
        editor = shrd.edit();
    }

    public void inpudata(String s, String k){
        editor.putString(s,k);
        editor.commit();
    }

    public String outputdata(String l){
        String x = shrd.getString(l, "y");
        return x;
    }

}
