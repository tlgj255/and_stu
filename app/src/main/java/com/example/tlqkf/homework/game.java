package com.example.tlqkf.homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tlqkf on 2016-08-17.
 */

public class game extends AppCompatActivity {

    int a = 0,e = 0,Random,Random2,Random3,b[] = new int[3],c = 0,d = 0,f = 0;
    TextView n_f1,n_f2,n_f3;
    Button n_1, n_2, n_3, n_4, n_5, n_6, n_7, n_8, n_9, menu, yes, no;
    RelativeLayout ask;

    @Override
    public void onBackPressed(){
        if (a == 1){
            ask.setVisibility(View.GONE);
            n_1.setVisibility(View.VISIBLE);
                    n_2.setVisibility(View.VISIBLE);
            n_3.setVisibility(View.VISIBLE);
                    n_4.setVisibility(View.VISIBLE);
            n_5.setVisibility(View.VISIBLE);
                    n_6.setVisibility(View.VISIBLE);
            n_7.setVisibility(View.VISIBLE);
                    n_8.setVisibility(View.VISIBLE);
            n_9.setVisibility(View.VISIBLE);
                    menu.setVisibility(View.VISIBLE);
            a = 0 ;
            n_f1.setVisibility(View.VISIBLE);
                    n_f2.setVisibility(View.VISIBLE);
            n_f3.setVisibility(View.VISIBLE);
            yes.setClickable(false);
            no.setClickable(false);
        }else{
            ask.setVisibility(View.VISIBLE);
            n_1.setVisibility(View.GONE);
            n_f1.setVisibility(View.GONE);
                    n_f2.setVisibility(View.GONE);
            n_f3.setVisibility(View.GONE);
                    n_2.setVisibility(View.GONE);
            n_3.setVisibility(View.GONE);
                    n_4.setVisibility(View.GONE);
            n_5.setVisibility(View.GONE);
                    n_6.setVisibility(View.GONE);
            n_7.setVisibility(View.GONE);
                    n_8.setVisibility(View.GONE);
            n_9.setVisibility(View.GONE);
                    menu.setVisibility(View.GONE);
            yes.setClickable(true);
            no.setClickable(true);
            a = 1 ;}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        n_f1 = (TextView) findViewById(R.id.f_n1);
        n_f2 = (TextView) findViewById(R.id.f_n2);
        n_f3 = (TextView) findViewById(R.id.f_n3);
        n_1 = (Button) findViewById(R.id.button6);
        n_2 = (Button) findViewById(R.id.button4);
        n_3 = (Button) findViewById(R.id.button7);
        n_4 = (Button) findViewById(R.id.button5);
        n_5 = (Button) findViewById(R.id.button8);
        n_6 = (Button) findViewById(R.id.button9);
        n_7 = (Button) findViewById(R.id.button10);
        n_8 = (Button) findViewById(R.id.button11);
        n_9 = (Button) findViewById(R.id.button12);
        menu = (Button) findViewById(R.id.button13);
        ask = (RelativeLayout) findViewById(R.id.ask);
        yes = (Button) findViewById(R.id.finish);
        no = (Button) findViewById(R.id.no);
    }
    public void onclick(View v) {
        Random = (int) (Math.random() * 10);
        Random2 = (int) (Math.random() * 10);
        Random3 = (int) (Math.random() * 10);
        while (true) {
            if (Random == Random2 || Random == Random3 || Random2 == Random3) {
                Random = (int) (Math.random() * 10);
                Random2 = (int) (Math.random() * 10);
                Random3 = (int) (Math.random() * 10);
            } else {
                break;
            }
        }
        Intent I = new Intent(this, MainActivity.class);
        switch (v.getId()){
            case R.id.button13:
                ask.setVisibility(View.VISIBLE);
                n_1.setVisibility(View.GONE);
                n_2.setVisibility(View.GONE);
                n_3.setVisibility(View.GONE);
                n_4.setVisibility(View.GONE);
                n_5.setVisibility(View.GONE);
                n_6.setVisibility(View.GONE);
                n_7.setVisibility(View.GONE);
                n_8.setVisibility(View.GONE);
                n_9.setVisibility(View.GONE);
                menu.setVisibility(View.GONE);
                n_f1.setVisibility(View.GONE);
                n_f2.setVisibility(View.GONE);
                n_f3.setVisibility(View.GONE);
                yes.setClickable(true);
                no.setClickable(true);
                a = 1;
                break;
            case R.id.finish:
                c = 0;
                startActivity(I);
                this.finish();
                break;
            case R.id.no:
                ask.setVisibility(View.GONE);
                n_1.setVisibility(View.VISIBLE);
                n_2.setVisibility(View.VISIBLE);
                n_3.setVisibility(View.VISIBLE);
                n_4.setVisibility(View.VISIBLE);
                n_5.setVisibility(View.VISIBLE);
                n_6.setVisibility(View.VISIBLE);
                n_7.setVisibility(View.VISIBLE);
                n_8.setVisibility(View.VISIBLE);
                n_9.setVisibility(View.VISIBLE);
                menu.setVisibility(View.VISIBLE);
                a = 0;
                n_f1.setVisibility(View.VISIBLE);
                n_f2.setVisibility(View.VISIBLE);
                n_f3.setVisibility(View.VISIBLE);
                yes.setClickable(false);
                no.setClickable(false);
                break;
        }
        for (c = 0; c < 3; c++) {
            switch (v.getId()) {
                case R.id.button6:
                    b[c] = 1;
                    break;
                case R.id.button4:
                    b[c] = 2;
                    break;
                case R.id.button7:
                    b[c] = 3;
                    break;
                case R.id.button5:
                    b[c] = 4;
                    break;
                case R.id.button8:
                    b[c] = 5;
                    break;
                case R.id.button9:
                    b[c] = 6;
                    break;
                case R.id.button10:
                    b[c] = 7;
                    break;
                case R.id.button11:
                    b[c] = 8;
                    break;
                case R.id.button12:
                    b[c] = 9;
                    break;
            }
        }
        e = b[0];
        n_f1.setText("" + e);
        d = b[1];
        n_f2.setText("" + d);
        f = b[2];
        n_f3.setText("" + f);
    }
}