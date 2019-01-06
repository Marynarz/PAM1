package com.example.wojtek.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.wojtek.kalkulator.basicCalc.dzialania.dzielenie;

public class basicCalc extends AppCompatActivity {
    private String aktualneStan ="0";
    private double aktualneWynik = 0;
    private double lastNumb = 0;
    private double actNumb =0;
    public enum dzialania{
        brak,
        dodawanie,
        odejmowanie,
        mnozenie,
        dzielenie
    };
    private dzialania aktDzialanie = dzialania.brak;
    private dzialania lastDzialanie = dzialania.brak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);
    }
    private void updateScreen(){
        TextView ekran = (TextView) findViewById(R.id.textView8);
        ekran.setText(this.aktualneStan);
    }
    public void addNumb(View view){
        if(aktualneStan == "0"){
            aktualneStan = "";
        }
        switch(view.getId()){
            case R.id.b0:
                aktualneStan +="0";
                break;
            case R.id.b1:
                aktualneStan +="1";
                        break;
            case R.id.b2:
                aktualneStan +="2";
                break;
            case R.id.b3:
                aktualneStan +="3";
                break;
            case R.id.b4:
                aktualneStan +="4";
                break;
            case R.id.b5:
                aktualneStan +="5";
                break;
            case R.id.b6:
                aktualneStan +="6";
                break;
            case R.id.b7:
                aktualneStan +="7";
                break;
            case R.id.b8:
                aktualneStan +="8";
                break;
            case R.id.b9:
                aktualneStan +="9";
                break;
            case R.id.bkrop:    //Przycisk .
                aktualneStan +=".";
                break;
            case R.id.bdel:     //przycisk DEL
                if(aktualneStan != "0" && aktualneStan.length() >1){
                    aktualneStan = aktualneStan.substring(0,aktualneStan.length()-1);
                } else {
                    clrCalc();
                }
                break;
            case R.id.bcl:  //przycisk C
                clrCalc();
                break;
                default:
                    aktualneStan = "ERROR, USE C button";
                    break;
        }
        this.updateScreen();
    }
    public void operacje(View view){
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
        switch(view.getId()){
            case R.id.bdod:
                aktDzialanie = dzialania.dodawanie;
                break;
            case R.id.bmin:
                aktDzialanie = dzialania.odejmowanie;
                break;
            case R.id.bm:
                aktDzialanie = dzialania.mnozenie;
                break;
            case R.id.bd:
                aktDzialanie = dzialania.dzielenie;
                break;
            case R.id.brow:
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
    public void clrCalc(){
        aktualneWynik = 0;
        aktualneStan = "0";
        aktDzialanie = dzialania.brak;
        lastDzialanie = dzialania.brak;
        actNumb = 0;
        lastNumb = 0;
    }
}
