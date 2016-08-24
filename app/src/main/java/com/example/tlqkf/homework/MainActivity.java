package com.example.tlqkf.homework;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    int a = 0 ;
    Button start,quit,yes,no;
    RelativeLayout ask;
    @Override
    public void onBackPressed(){
        if (a == 1){
            ask.setVisibility(View.GONE);
            start.setVisibility(View.VISIBLE);
            quit.setVisibility(View.VISIBLE);
            a = 0 ;
            yes.setClickable(false);
            no.setClickable(false);
        }else{
            ask.setVisibility(View.VISIBLE);
        start.setVisibility(View.GONE);
        quit.setVisibility(View.GONE);
            yes.setClickable(true);
            no.setClickable(true);
        a = 1 ;}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.button);
        quit = (Button)findViewById(R.id.button3);
        ask = (RelativeLayout)findViewById(R.id.ask);
        yes = (Button)findViewById(R.id.finish);
        no = (Button)findViewById(R.id.no);
    }
    public void onclick(View v){
        Intent game = new Intent(this,game.class);
        switch (v.getId()) {
            case R.id.button:
                finish();
                overridePendingTransition(R.anim.gone,R.anim.go);
                startActivity(game);
                break;
            case R.id.button3:
                ask.setVisibility(View.VISIBLE);
                start.setVisibility(View.GONE);
                quit.setVisibility(View.GONE);
                yes.setClickable(true);
                no.setClickable(true);

                a = 1;
                break;
            case R.id.finish:
                finish();
                break;
            case R.id.no:
                ask.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                quit.setVisibility(View.VISIBLE);
                a = 0;
                yes.setClickable(false);
                no.setClickable(false);
                break;
        }
    }
}
