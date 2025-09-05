package com.example.classwork_04;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;
    View line_1, line_2, line_3, line_4, line_5, line_6, line_7;
    ImageView logo;
    TextView appName;
    ProgressBar progressBar;
    Animation topAnimation, bottomAnimation, middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        line_1 = findViewById(R.id.line_1);
        line_2 = findViewById(R.id.line_2);
        line_3 = findViewById(R.id.line_3);
        line_4 = findViewById(R.id.line_4);
        line_5 = findViewById(R.id.line_5);
        line_6 = findViewById(R.id.line_6);
        line_7 = findViewById(R.id.line_7);
        progressBar = findViewById(R.id.progress_bar);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        logo.startAnimation(middleAnimation);
        appName.startAnimation(middleAnimation);
        line_1.startAnimation(topAnimation);
        line_2.startAnimation(topAnimation);
        line_3.startAnimation(topAnimation);
        line_4.startAnimation(topAnimation);
        line_5.startAnimation(topAnimation);
        line_6.startAnimation(topAnimation);
        line_7.startAnimation(topAnimation);

        progressBar.setVisibility(View.VISIBLE);
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.setDuration(SPLASH_DURATION);
        animator.addUpdateListener(animation -> {
            int progress = (int) animation.getAnimatedValue();
            progressBar.setProgress(progress);
        });
        animator.start();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);

    }
}
