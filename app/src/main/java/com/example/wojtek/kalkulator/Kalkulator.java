package com.example.wojtek.kalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Kalkulator extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.wojtek.kalkultor";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
    }

    public void oMnie(View view){
        Intent intent = new Intent(this,oMnieAct.class);
        startActivity(intent);
    }
    public void egzit(View view){
        finish();
        System.exit(0);
    }
    public void basicCalc(View view){
        Intent intent = new Intent(this,advCalc.class);
        startActivity(intent);
    }
}
