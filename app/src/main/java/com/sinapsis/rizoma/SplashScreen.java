package com.sinapsis.rizoma;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class SplashScreen extends Activity implements View.OnClickListener {


    public SplashScreen() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_screen);
            new CountDownTimer(5000, 100) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    startActivity();
                }
            }.start();
        } catch (Exception e) {
        }


    }

    private void startActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void loadNewActivity(int iAnimation) {
    }

    @Override
    public void onClick(View v) {

    }
}

