package com.example.tlqkf.homework;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int a = 0, temp = 0;
    Button start, quit, yes, no, ranking;
    RelativeLayout ask;
    TextView rank;
    database db;

    @Override
    public void onBackPressed() {
        if (a == 1) {
            ask.setVisibility(View.GONE);
            start.setClickable(true);
            quit.setClickable(true);
            ranking.setClickable(true);
            a = 0;
            yes.setClickable(false);
            no.setClickable(false);
        } else {
            ask.setVisibility(View.VISIBLE);
            start.setClickable(false);
            quit.setClickable(false);
            ranking.setClickable(false);
            yes.setClickable(true);
            no.setClickable(true);
            a = 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new database(this);
        db.open();
        Cursor all_cursor = db.AllRows();
        all_cursor.moveToLast();
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        rank = (TextView)findViewById(R.id.rank);
        ranking = (Button) findViewById(R.id.ranking);
        start = (Button) findViewById(R.id.button);
        quit = (Button) findViewById(R.id.button3);
        ask = (RelativeLayout) findViewById(R.id.ask);
        yes = (Button) findViewById(R.id.finish);
        no = (Button) findViewById(R.id.no);
        if(all_cursor.getCount() > 0)
        rank.setText("최근기록 \n점수 : "+(10-all_cursor.getInt(all_cursor.getColumnIndex("POINT")))+"점 닉네임 : "
                +all_cursor.getString(all_cursor.getColumnIndex("NAME")));
    }

    public void onclick(View v) {
        Intent game = new Intent(this, game.class);
        switch (v.getId()) {
            case R.id.button:
                finish();
                overridePendingTransition(R.anim.gone, R.anim.go);
                startActivity(game);
                break;
            case R.id.button3:
                ask.setVisibility(View.VISIBLE);
                start.setClickable(false);
                quit.setClickable(false);
                ranking.setClickable(false);
                a = 1;
                break;
            case R.id.finish:
                finish();
                break;
            case R.id.no:
                ask.setVisibility(View.GONE);
                start.setClickable(true);
                quit.setClickable(true);
                ranking.setClickable(true);
                yes.setClickable(true);
                no.setClickable(true);
                a = 0;
                break;
            case R.id.ranking:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.gone, R.anim.go);
              db.deleteAll();
        }
    }
}
