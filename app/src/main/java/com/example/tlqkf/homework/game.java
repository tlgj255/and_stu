package com.example.tlqkf.homework;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


public class game extends AppCompatActivity {
    Animation check;
    int a = 0, Random, Random2, Random3, b[] = new int[3], c = 0, g = 10, s1 = 0, s2 = 0, s3 = 0, s = 0, ball = 0, dw = 0;
    TextView n_f1, n_f2, n_f3, life, count, n_f1_, n_f3_, n_f4_, n_f2_, dab, dab_, dab__, R1, R2, R3, R4, R5, R6, R7, R8, R9;
    Button n_1, n_2, n_3, n_4, n_5, n_6, n_7, n_8, n_9, menu, yes, no, ok, back, out, regame, re_, bye;
    RelativeLayout ask, clear, die;
    private Handler mHandler;

    @Override
    public void onBackPressed() {
        if (a == 1) {
        } else if (dw == 1) {

        } else if (a == 0){
            if (b[0] > 0)
                c = 0;
           if (b[1] > 0)
                c = 1;
            if (b[2] > 0)
                c = 2;
            else
                c = -1;
            n_1.setClickable(false);
            n_2.setClickable(false);
            n_3.setClickable(false);
            n_4.setClickable(false);
            n_5.setClickable(false);
            n_6.setClickable(false);
            n_7.setClickable(false);
            n_8.setClickable(false);
            n_9.setClickable(false);
            menu.setClickable(false);
            ask.setVisibility(View.VISIBLE);
            yes.setClickable(true);
            no.setClickable(true);
            R1.setTextColor(0x00000000);
            R2.setTextColor(0x00000000);
            R3.setTextColor(0x00000000);
            R4.setTextColor(0x00000000);
            R5.setTextColor(0x00000000);
            R6.setTextColor(0x00000000);
            R7.setTextColor(0x00000000);
            R8.setTextColor(0x00000000);
            R9.setTextColor(0x00000000);
            a = 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.game);
        re_ = (Button)findViewById(R.id.re);
        bye = (Button)findViewById(R.id.bye);
        die = (RelativeLayout)findViewById(R.id.die);
        check = AnimationUtils.loadAnimation(this, R.anim.check);
        check.setAnimationListener(new Animation.AnimationListener() {
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
        R1 = (TextView) findViewById(R.id.textView2);
        R2 = (TextView) findViewById(R.id.textView3);
        R3 = (TextView) findViewById(R.id.textView4);
        R4 = (TextView) findViewById(R.id.textView5);
        R5 = (TextView) findViewById(R.id.textView6);
        R6 = (TextView) findViewById(R.id.textView7);
        R7 = (TextView) findViewById(R.id.textView8);
        R8 = (TextView) findViewById(R.id.textView9);
        R9 = (TextView) findViewById(R.id.textView10);
        dab = (TextView) findViewById(R.id.f_n1__);
        dab_ = (TextView) findViewById(R.id.f_n2__);
        dab__ = (TextView) findViewById(R.id.f_n3__);
        n_f4_ = (TextView) findViewById(R.id.f_n4_);
        n_f3_ = (TextView) findViewById(R.id.f_n3_);
        n_f2_ = (TextView) findViewById(R.id.f_n2_);
        n_f1_ = (TextView) findViewById(R.id.f_n1_);
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
        Random = (int) (Math.random() * 9) + 1;
        Random2 = (int) (Math.random() * 9) + 1;
        Random3 = (int) (Math.random() * 9) + 1;
        while (true) {
            if (Random == Random2 || Random == Random3 || Random2 == Random3) {
                Random = (int) (Math.random() * 9) + 1;
                Random2 = (int) (Math.random() * 9) + 1;
                Random3 = (int) (Math.random() * 9) + 1;
            } else {
                break;
            }
        }
        Log.i("Random", "" + Random);
        Log.i("Random2", "" + Random2);
        Log.i("Random3", "" + Random3);
    }

    public void onclick(View v) {
        Log.i("b[0],b[1],b[2]",""+b[0]+" "+b[1]+" "+b[2]);
        Intent re = new Intent(this,game.class);
        Toast toast;
        toast = Toast.makeText(game.this, "숫자를 마저 입력해주세요", Toast.LENGTH_SHORT);
        Intent I = new Intent(this, MainActivity.class);
        switch (v.getId()) {
            case R.id.button13:
                a = 1;
                R1.setTextColor(0x00000000);
                R2.setTextColor(0x00000000);
                R3.setTextColor(0x00000000);
                R4.setTextColor(0x00000000);
                R5.setTextColor(0x00000000);
                R6.setTextColor(0x00000000);
                R7.setTextColor(0x00000000);
                R8.setTextColor(0x00000000);
                R9.setTextColor(0x00000000);
                n_1.setClickable(false);
                n_2.setClickable(false);
                n_3.setClickable(false);
                n_4.setClickable(false);
                n_5.setClickable(false);
                n_6.setClickable(false);
                n_7.setClickable(false);
                n_8.setClickable(false);
                n_9.setClickable(false);
                menu.setClickable(false);
                ask.setVisibility(View.VISIBLE);
                yes.setClickable(true);
                no.setClickable(true);
                break;
            case R.id.finish:
                c = 0;
                startActivity(I);
                overridePendingTransition(R.anim.gone, R.anim.go);
                this.finish();
                break;
            case R.id.no:
                a = 0;
                R1.setTextColor(0Xff000000);
                R2.setTextColor(0Xff000000);
                R3.setTextColor(0Xff000000);
                R4.setTextColor(0Xff000000);
                R5.setTextColor(0Xff000000);
                R6.setTextColor(0Xff000000);
                R7.setTextColor(0Xff000000);
                R8.setTextColor(0Xff000000);
                R9.setTextColor(0Xff000000);
                n_1.setClickable(true);
                n_2.setClickable(true);
                n_3.setClickable(true);
                n_4.setClickable(true);
                n_5.setClickable(true);
                n_6.setClickable(true);
                n_7.setClickable(true);
                n_8.setClickable(true);
                n_9.setClickable(true);
                menu.setClickable(true);
                ask.setVisibility(View.GONE);
                yes.setClickable(false);
                no.setClickable(false);
                if (b[0] > 0) c = 0;
                if (b[1] > 0) c = 1;
                if (b[2] > 0) c = 2;
                else c = -1;
                break;
            case R.id.button6:
                b[c] = 1;
                n_1.setClickable(false);
                break;
            case R.id.button4:
                b[c] = 6;
                n_2.setClickable(false);
                break;
            case R.id.button7:
                b[c] = 2;
                n_3.setClickable(false);
                break;
            case R.id.button5:
                b[c] = 7;
                n_4.setClickable(false);
                break;
            case R.id.button8:
                b[c] = 3;
                n_5.setClickable(false);
                break;
            case R.id.button9:
                b[c] = 8;
                n_6.setClickable(false);
                break;
            case R.id.button10:
                b[c] = 4;
                n_7.setClickable(false);
                break;
            case R.id.button11:
                b[c] = 9;
                n_8.setClickable(false);
                break;
            case R.id.button12:
                b[c] = 5;
                n_9.setClickable(false);
                break;
            case R.id.button14:
                if (c == 3) {
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

                    if (s == 3) {
                        R1.setTextColor(0x00000000);
                        R2.setTextColor(0x00000000);
                        R3.setTextColor(0x00000000);
                        R4.setTextColor(0x00000000);
                        R5.setTextColor(0x00000000);
                        R6.setTextColor(0x00000000);
                        R7.setTextColor(0x00000000);
                        R8.setTextColor(0x00000000);
                        R9.setTextColor(0x00000000);
                        dab.setText("" + Random);
                        dab_.setText("" + Random2);
                        dab__.setText("" + Random3);
                        n_1.setClickable(false);
                        n_2.setClickable(false);
                        n_3.setClickable(false);
                        n_4.setClickable(false);
                        n_5.setClickable(false);
                        n_6.setClickable(false);
                        n_7.setClickable(false);
                        n_8.setClickable(false);
                        n_9.setClickable(false);
                        menu.setClickable(false);
                        clear.setVisibility(View.VISIBLE);
                        count.setText(10 - g + "번만에 클리어!!");
                        dw++;
                    } else {
                        n_f4_.setVisibility(View.VISIBLE);
                        n_f4_.startAnimation(check);
                        n_f3_.setVisibility(View.VISIBLE);
                        n_f3_.startAnimation(check);
                        n_f2_.setVisibility(View.VISIBLE);
                        n_f2_.startAnimation(check);
                        n_f1_.setVisibility(View.VISIBLE);
                        n_f1_.startAnimation(check);
                        n_f4_.setText("" + s);
                        n_f2_.setText("" + ball);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                n_f4_.setVisibility(View.GONE);
                                n_f1_.setVisibility(View.GONE);
                                n_f2_.setVisibility(View.GONE);
                                n_f3_.setVisibility(View.GONE);
                                mHandler.sendEmptyMessage(0);
                            }
                        }, 2200);
                        Handler mHandler = new Handler() {
                            public void handleMessage(Message msg) {
                            }
                        };
                        if (g == 10) {
                            R1.setText("1R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R1.setVisibility(View.VISIBLE);
                        } else if (g == 9) {
                            R2.setText("2R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R2.setVisibility(View.VISIBLE);
                        } else if (g == 8) {
                            R3.setText("3R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R3.setVisibility(View.VISIBLE);
                        } else if (g == 7) {
                            R4.setText("4R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R4.setVisibility(View.VISIBLE);
                        } else if (g == 6) {
                            R5.setText("5R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R5.setVisibility(View.VISIBLE);
                        } else if (g == 5) {
                            R6.setText("6R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R6.setVisibility(View.VISIBLE);
                        } else if (g == 4) {
                            R7.setText("7R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R7.setVisibility(View.VISIBLE);
                        } else if (g == 3) {
                            R8.setText("8R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R8.setVisibility(View.VISIBLE);
                        } else if (g == 2) {
                            R9.setText("9R " + s + "S " + ball + "B\n   " + b[0] + " " + b[1] + " " + b[2]);
                            R9.setVisibility(View.VISIBLE);
                        }
                        b[0] = 0;
                        b[1] = 0;
                        b[2] = 0;
                        n_1.setClickable(true);
                        n_2.setClickable(true);
                        n_3.setClickable(true);
                        n_4.setClickable(true);
                        n_5.setClickable(true);
                        n_6.setClickable(true);
                        n_7.setClickable(true);
                        n_8.setClickable(true);
                        n_9.setClickable(true);
                        c = -1;
                        g--;
                        if(g > 0)
                        life.setText("목숨이 " + (g-1) + "번 남았습니다.");
                        if (g == 0){
                            dw = 1;
                            R1.setTextColor(0x00000000);
                            R2.setTextColor(0x00000000);
                            R3.setTextColor(0x00000000);
                            R4.setTextColor(0x00000000);
                            R5.setTextColor(0x00000000);
                            R6.setTextColor(0x00000000);
                            R7.setTextColor(0x00000000);
                            R8.setTextColor(0x00000000);
                            R9.setTextColor(0x00000000);
                            die.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    toast.setGravity(Gravity.BOTTOM, 0, 500);
                    toast.show();
                    c--;
                }
                s = 0;
                break;
            case R.id.re:
                startActivity(re);
                finish();
                overridePendingTransition(R.anim.gone, R.anim.go);
                break;
            case R.id.bye:
                overridePendingTransition(R.anim.gone, R.anim.go);
                startActivity(I);
                finish();
                break;
            case R.id.button15:
                if (c == 1) {
                    n_1.setClickable(true);
                    n_2.setClickable(true);
                    n_3.setClickable(true);
                    n_4.setClickable(true);
                    n_5.setClickable(true);
                    n_6.setClickable(true);
                    n_7.setClickable(true);
                    n_8.setClickable(true);
                    n_9.setClickable(true);
                    c = c - 2;
                    b[0] = 0;
                } else if (c == 2) {
                    if (b[1] == 1) n_1.setClickable(true);
                    if (b[1] == 2) n_3.setClickable(true);
                    if (b[1] == 3) n_5.setClickable(true);
                    if (b[1] == 4) n_7.setClickable(true);
                    if (b[1] == 5) n_9.setClickable(true);
                    if (b[1] == 6) n_2.setClickable(true);
                    if (b[1] == 7) n_4.setClickable(true);
                    if (b[1] == 8) n_6.setClickable(true);
                    if (b[1] == 9) n_8.setClickable(true);
                    b[1] = 0;
                    c = c - 2;
                } else if (c == 3) {
                    n_1.setClickable(true);
                    n_2.setClickable(true);
                    n_3.setClickable(true);
                    n_4.setClickable(true);
                    n_5.setClickable(true);
                    n_6.setClickable(true);
                    n_7.setClickable(true);
                    n_8.setClickable(true);
                    n_9.setClickable(true);
                    if (b[1] == 1) n_1.setClickable(false);
                    if (b[1] == 2) n_3.setClickable(false);
                    if (b[1] == 3) n_5.setClickable(false);
                    if (b[1] == 4) n_7.setClickable(false);
                    if (b[1] == 5) n_9.setClickable(false);
                    if (b[1] == 6) n_2.setClickable(false);
                    if (b[1] == 7) n_4.setClickable(false);
                    if (b[1] == 8) n_6.setClickable(false);
                    if (b[1] == 9) n_8.setClickable(false);
                    if (b[0] == 1)n_1.setClickable(false);
                    if (b[0] == 2)n_3.setClickable(false);
                    if (b[0] == 3)n_5.setClickable(false);
                    if (b[0] == 4)n_7.setClickable(false);
                    if (b[0] == 5)n_9.setClickable(false);
                    if (b[0] == 6)n_2.setClickable(false);
                    if (b[0] == 7)n_4.setClickable(false);
                    if (b[0] == 8)n_6.setClickable(false);
                    if (b[0] == 9)n_8.setClickable(false);
                    b[2] = 0;
                    c = c - 2;
                } else
                    c--;
                break;
            case R.id.out:
                overridePendingTransition(R.anim.gone, R.anim.go);
                startActivity(I);
                finish();
                break;
            case R.id.regame:
               startActivity(re);
                finish();
                overridePendingTransition(R.anim.gone, R.anim.go);
                break;
        }
        n_f1.setText("" + b[0]);
        n_f2.setText("" + b[1]);
        n_f3.setText("" + b[2]);
        Log.i("c", "" + c);
        c++;
        if (c == 3) {
            n_1.setClickable(false);
            n_2.setClickable(false);
            n_3.setClickable(false);
            n_4.setClickable(false);
            n_5.setClickable(false);
            n_6.setClickable(false);
            n_7.setClickable(false);
            n_8.setClickable(false);
            n_9.setClickable(false);
        }
    }
}