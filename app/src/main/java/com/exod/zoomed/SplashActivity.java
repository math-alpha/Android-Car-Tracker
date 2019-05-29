package com.exod.zoomed;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), IntroActivity.class));
            }
        }, 10*1000);

        progressAnimation();

    }

    public void progressAnimation(){
        ProgressBarAnimation progressBarAnimation = new ProgressBarAnimation(this, progressBar, 0f, 10f);
        progressBarAnimation.setDuration(10000);
        progressBar.setAnimation(progressBarAnimation);
    }
}
