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
    public enum dzialania{
        brak,
        dodawanie,
        odejmowanie,
        mnozenie,
        dzielenie
    };
    private dzialania aktDzialanie = dzialania.brak;
    private dzialania lastDzialanie = dzialania.brak;
    private double actNumb = 0;
    private double lastNumb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_calc);
    }

    private void updateScreen() {
        TextView ekran = (TextView) findViewById(R.id.Wyswietlacz);
        ekran.setText(this.aktualneStan);
    }

    public void addNumbAdv(View view){
        if(aktualneStan == "0"){
            aktualneStan = "";
        }
        aktualneStan += ((Button)view).getText().toString();
        updateScreen();
    }

    public void singleOprts(View view){
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

    public void operacjeAdv(View view){
        actNumb = Double.parseDouble(aktualneStan);
        switch(aktDzialanie){     //odpalamy ostatnie dzialanie
            case brak:
                aktualneWynik +=actNumb;
                break;
            case dodawanie:
                aktualneWynik += actNumb;
                lastDzialanie = dzialania.dodawanie;
                break;
            case odejmowanie:
                aktualneWynik -= actNumb;
                lastDzialanie = dzialania.odejmowanie;
                break;
            case mnozenie:
                aktualneWynik *=actNumb;
                lastDzialanie = dzialania.mnozenie;
                break;
            case dzielenie:
                aktualneWynik /= actNumb;
                lastDzialanie = dzialania.dzielenie;
                break;
            default:
                aktualneStan = "ERROR, USE C button";
                break;
        }
        switch(((Button)view).getText().toString().toLowerCase()){
            case "+":
                aktDzialanie = dzialania.dodawanie;
                break;
            case "-":
                aktDzialanie = dzialania.odejmowanie;
                break;
            case "*":
                aktDzialanie = dzialania.mnozenie;
                break;
            case "/":
                aktDzialanie = dzialania.dzielenie;
                break;
            case "=":
                aktualneStan = String.valueOf(aktualneWynik);
                updateScreen();
                aktDzialanie = dzialania.brak;
                break;
            default:
                aktualneStan = "ERROR, USE C button";
                break;
        }
        aktualneStan = "0";
        lastNumb = actNumb;
    }

    public void clcCalc(){
        aktualneWynik = 0;
        aktualneStan = "0";
        aktDzialanie = dzialania.brak;
        lastDzialanie = dzialania.brak;
        actNumb = 0;
        lastNumb = 0;
    }
    public void delMethod(View v){
        if(((Button)v).getText().toString().toLowerCase() =="c"){
            clcCalc();
        }
        else if(aktualneStan != "0" && aktualneStan.length() >1){
            aktualneStan = aktualneStan.substring(0,aktualneStan.length()-1);
        } else {
            clcCalc();
        }
        updateScreen();
    }
}


