package com.example.wojtek.kalkulator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class advCalc extends AppCompatActivity {
    private String aktualneStan = "";
    private double aktualneWynik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_calc);
    }

    private void updateScreen() {
        TextView ekran = (TextView) findViewById(R.id.Wyswietlacz);
        ekran.setText(this.aktualneStan);
    }

    protected void addNumbAdv(View view){
        if(aktualneStan == "0"){
            aktualneStan = "";
        }
        aktualneStan += ((Button)view).getText().toString();
        updateScreen();
    }

    protected void singleOprts(View view){
        Double actNumb = Double.parseDouble(aktualneStan);
        switch(((Button)view).getText().toString().toLowerCase()){
            case "sin":
                aktualneWynik = Math.sin(actNumb);
                break;
            case "cos":
                aktualneWynik = Math.cos(actNumb);
                break;
            case "tan":
                aktualneWynik = Math.tan(actNumb);
                break;
            case "sqrt":
                aktualneWynik = Math.sqrt(actNumb);
                break;
            case "log":
                aktualneWynik = Math.log(actNumb);
                break;
            case "x^2":
                aktualneWynik = Math.pow(actNumb,2);
                break;
            default:
                aktualneStan = "ERR";
                break;
        }
        aktualneStan = String.valueOf(aktualneWynik);
        updateScreen();

    }
    protected void clcCalc(){
        aktualneStan = "0";
        aktualneWynik = 0;
    }
}


