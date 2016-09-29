package com.example.tlqkf.homework;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class game extends AppCompatActivity {
    Animation check;
    int a = 0, Random, Random2, Random3, b[] = new int[10], c = 0, g = 10, s1 = 0, s2 = 0, s3 = 0, s = 0, ball = 0, dw = 0;
    TextView n_f1, n_f2, n_f3, life, count, dab, dab_, dab__;
    Button menu, yes, no, ok, back, out, regame, re_, bye, good;
    RelativeLayout ask, clear, die, record;
    private Handler mHandler;
    EditText name;
    database db;
     MediaPlayer ppyok,pyororo,forgive;
    private TextView [] ani /*animatin*/ = new TextView[4];
    private TextView [] Rn/*round*/ = new TextView[9];
    private Button [] n = new Button[9];
    @Override
    public void onBackPressed() {
        if (a == 1) {
            a = 0;
            menu.setClickable(true);
            ask.setVisibility(View.GONE);
            yes.setClickable(false);
            no.setClickable(false);
        } else if (dw == 1) {//dw가 1일땐 뒤로가기를 눌러도 아무것도 일어나지 않음
        } else if (a == 0) {
            ask.setVisibility(View.VISIBLE);//뒤로가기를 눌렀을때 메뉴로 돌아갈건지 물어보는 레이아웃 띄우기,버튼 비활성화
            yes.setClickable(true);
            no.setClickable(true);
            a = 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ppyok = MediaPlayer.create(this,R.raw.a007);
        pyororo = MediaPlayer.create(this,R.raw.a0081);
        forgive  = MediaPlayer.create(this,R.raw.forgive);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.game);
        db = new database(this);
        re_ = (Button) findViewById(R.id.re);
        bye = (Button) findViewById(R.id.bye);
        die = (RelativeLayout) findViewById(R.id.die);
        check = AnimationUtils.loadAnimation(this, R.anim.check);
        check.setAnimationListener(new Animation.AnimationListener() {//애니매이션 선언
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mHandler = new Handler();
        record = (RelativeLayout) findViewById(R.id.record);
        good = (Button) findViewById(R.id.good);
        Rn[0] = (TextView) findViewById(R.id.textView2);
        Rn[1] = (TextView) findViewById(R.id.textView3);
        Rn[2] = (TextView) findViewById(R.id.textView4);
        Rn[3] = (TextView) findViewById(R.id.textView5);
        Rn[4] = (TextView) findViewById(R.id.textView6);
        Rn[5] = (TextView) findViewById(R.id.textView7);
        Rn[6] = (TextView) findViewById(R.id.textView8);
        Rn[7] = (TextView) findViewById(R.id.textView9);
        Rn[8] = (TextView) findViewById(R.id.textView10);
        dab = (TextView) findViewById(R.id.f_n1__);
        dab_ = (TextView) findViewById(R.id.f_n2__);
        dab__ = (TextView) findViewById(R.id.f_n3__);
       ani[0] = (TextView) findViewById(R.id.f_n4_);
       ani[1] = (TextView) findViewById(R.id.f_n3_);
       ani[2] = (TextView) findViewById(R.id.f_n2_);
       ani[3] = (TextView) findViewById(R.id.f_n1_);
        count = (TextView) findViewById(R.id.count);
        clear = (RelativeLayout) findViewById(R.id.clear);
        out = (Button) findViewById(R.id.out);
        regame = (Button) findViewById(R.id.regame);
        ok = (Button) findViewById(R.id.button14);
        back = (Button) findViewById(R.id.button15);
        life = (TextView) findViewById(R.id.life);
        n_f1 = (TextView) findViewById(R.id.f_n1);
        n_f2 = (TextView) findViewById(R.id.f_n2);
        n_f3 = (TextView) findViewById(R.id.f_n3);
        n[0] = (Button) findViewById(R.id.button6);
        n[1] = (Button) findViewById(R.id.button4);
        n[2] = (Button) findViewById(R.id.button7);
        n[3] = (Button) findViewById(R.id.button5);
        n[4] = (Button) findViewById(R.id.button8);
        n[5] = (Button) findViewById(R.id.button9);
        n[6] = (Button) findViewById(R.id.button10);
        n[7] = (Button) findViewById(R.id.button11);
        n[8] = (Button) findViewById(R.id.button12);
        menu = (Button) findViewById(R.id.button13);
        ask = (RelativeLayout) findViewById(R.id.ask);
        yes = (Button) findViewById(R.id.finish);
        no = (Button) findViewById(R.id.no);
        Random = (int) (Math.random() * 9) + 1;
        Random2 = (int) (Math.random() * 9) + 1;
        Random3 = (int) (Math.random() * 9) + 1;
        while (true) {//get random number while not duplicate that
            if (Random == Random2 || Random == Random3 || Random2 == Random3) {
                Random = (int) (Math.random() * 9) + 1;
                Random2 = (int) (Math.random() * 9) + 1;
                Random3 = (int) (Math.random() * 9) + 1;
            } else {
                break;
            }
        }//three random number
        Log.i("Random", "" + Random);
        Log.i("Random2", "" + Random2);
        Log.i("Random3", "" + Random3);

    }
    public void onclick(View v) {
        ppyok.start();
        Log.i("b[0],b[1],b[2]", "" + b[0] + " " + b[1] + " " + b[2]);
        Intent re = new Intent(this, game.class);
        Toast toast;
        toast = Toast.makeText(game.this, "숫자를 마저 입력해주세요", Toast.LENGTH_SHORT);
        Intent I = new Intent(this, MainActivity.class);
        switch (v.getId()) {
            case R.id.button13://if you press the button, show menu go MainActivity or not
                a = 1;
                ask.setVisibility(View.VISIBLE);
                yes.setClickable(true);
                no.setClickable(true);
                c--;
                break;
            case R.id.finish:
                c = 0;
                startActivity(I);
                overridePendingTransition(R.anim.gone, R.anim.go);
                this.finish();
                break;
            case R.id.no://원상태로 복귀
                a = 0;
                menu.setClickable(true);
                ask.setVisibility(View.GONE);
                yes.setClickable(false);
                no.setClickable(false);
                if (b[0] > 0) c = 0;
                if (b[1] > 0) c = 1;
                if (b[2] > 0) c = 2;
                if(b[0] == 0) c = -1;
                break;
            case R.id.button6:
                b[c] = 1;
                n[0].setClickable(false);
                break;
            case R.id.button4:
                b[c] = 6;
                n[1].setClickable(false);
                break;
            case R.id.button7:
                b[c] = 2;
                n[2].setClickable(false);
                break;
            case R.id.button5:
                b[c] = 7;
                n[3].setClickable(false);
                break;
            case R.id.button8:
                b[c] = 3;
                n[4].setClickable(false);
                break;
            case R.id.button9:
                b[c] = 8;
                n[5].setClickable(false);
                break;
            case R.id.button10:
                b[c] = 4;
                n[6].setClickable(false);
                break;
            case R.id.button11:
                b[c] = 9;
                n[7].setClickable(false);
                break;
            case R.id.button12:
                b[c] = 5;
                n[8].setClickable(false);
                break;
            case R.id.button14:
                if (c >= 3) {
                    s1 = 0;
                    s2 = 0;
                    s3 = 0;
                    ball = 0;
                    if (b[0] == Random) s1++;
                    if (b[1] == Random2) s2++;
                    if (b[2] == Random3) s3++;
                    if (b[0] == Random2 && s1 == 0 || b[0] == Random3 && s1 == 0) ball++;
                    if (b[1] == Random && s2 == 0 || b[1] == Random3 && s2 == 0) ball++;
                    if (b[2] == Random && s3 == 0 || b[2] == Random2 && s3 == 0) ball++;
                    s = s1 + s2 + s3;
                    Log.i("s1,s2,s3", "" + s1 + "," + s2 + "," + s3);
                    if (s == 3) {//게임 클리어시 클리어했다는 문구내보내기
                        dab.setText("" + Random);
                        dab_.setText("" + Random2);
                        dab__.setText("" + Random3);
                        clear.setVisibility(View.VISIBLE);
                        count.setText(11 - g + "번만에 클리어!!");
                        dw++;
                    } else {//클리어 못했을 시
                        pyororo.start();//start sound
                        for(int i = 0; i < 4; i++){
                            ani[i].setVisibility(View.VISIBLE);//애니매이션 나타내기
                            ani[i].startAnimation(check);//애니매이션 나타내기
                        }
                        ani[3].setText("" + s);
                        ani[1].setText("" + ball);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for(int i = 0; i < 4; i++)
                                ani[i].setVisibility(View.GONE);
                                mHandler.sendEmptyMessage(0);
                            }
                        }, 2200);//animation gone after 2.2s
                        Handler mHandler = new Handler() {
                            public void handleMessage(Message msg) {
                            }
                        };
                        //show round and strike and ball on interface
                            Rn[10-g].setText("1R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            Rn[10-g].setVisibility(View.VISIBLE);
                        b[0] = 0;
                        b[1] = 0;
                        b[2] = 0;
                        for(int i = 0; i < 9; i++){
                            n[i].setClickable(true);
                        }
                        c = -1;
                        g--;
                        if (g > 0)
                            life.setText("목숨이 " + (g - 1) + "번 남았습니다.");
                        if (g == 0) {//목숨이 없어졌을시 사망문구
                            forgive.start();
                            dab.setText("" + Random);
                            dab_.setText("" + Random2);
                            dab__.setText("" + Random3);
                            dw = 1;
                            die.setVisibility(View.VISIBLE);
                        }
                    }
                } else {//수를 3개보다 적게 입력했을시
                    toast.setGravity(Gravity.BOTTOM, 0, 500);
                    toast.show();
                    c--;
                }
                s = 0;
                break;
            case R.id.re://다시시작
                finish();
                startActivity(re);
                overridePendingTransition(R.anim.gone, R.anim.go);//액티비티 넘어갈때 애니매이션효과
                break;
            case R.id.bye:
                finish();
                overridePendingTransition(R.anim.gone, R.anim.go);
                startActivity(I);
                break;
            case R.id.good:
                name = (EditText) findViewById(R.id.name);
                String inputname = name.getText().toString();
                if(inputname.getBytes().length <= 0)
                    Toast.makeText(this, "이름을 마저 입력해 주세요", Toast.LENGTH_SHORT).show();
                else {
                    name.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
                    name.setGravity(Gravity.CENTER);
                    Cursor all_cursor = db.AllRows();
                    all_cursor.moveToFirst();
                    db.insert(10 - g, inputname);
                    Log.i("db들어감", "" + (10 - g) + inputname);
                    finish();
                    overridePendingTransition(R.anim.gone, R.anim.go);//메뉴로 가기
                    startActivity(I);
                }
            case R.id.button15://지우기 키를 눌렀을때 클릭이 비활성화 돼있는 것을 활성화시키는 작업
                if (c == 1) {
                    for(int i = 0; i < 9; i++){
                        n[i].setClickable(true);
                    }
                    c = c - 2;
                    b[0] = 0;
                } else if (c == 2) {
                    for(int i = 0; i < 9; i++){
                        if(b[1] == i)
                        n[i].setClickable(true);
                    }
                    b[1] = 0;
                    c = c - 2;
                } else if (c == 3) {
                    for(int i = 0; i < 9; i++){
                        n[i].setClickable(true);
                    }
                    for(int i = 0; i < 9; i++){
                        if(b[1] == i)
                            n[i].setClickable(false);
                    }
                    for(int i = 0; i < 9; i++){
                        if(b[0] == i)
                            n[i].setClickable(false);
                    }
                    b[2] = 0;
                    c = c - 2;
                } else
                    c--;
                break;
            case R.id.out://메뉴로 가기
                db.open();
                record.setVisibility(View.VISIBLE);
                break;
            case R.id.regame://게임 다시 시작
                finish();
                startActivity(re);
                overridePendingTransition(R.anim.gone, R.anim.go);
                break;
        }
        n_f1.setText("" + b[0]);
        n_f2.setText("" + b[1]);
        n_f3.setText("" + b[2]);
        Log.i("c", "" + c);
        if(c  <  4)
        c++;
        else
        c = 3;
        if (c == 3) {//숫자를 3번 입력시 클릭 비활성화
            for(int i = 0; i < 9; i++){
                    n[i].setClickable(false);
            }
        }
    }
}