package com.example.evaa;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnItemSearch, btnEnvironment, btnHelp, btnSettings;
    TextView tvTitle;
    ImageView ivLogo;
    RelativeLayout rLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnItemSearch = findViewById(R.id.btnItemSearch);
        btnEnvironment = findViewById(R.id.btnEnvironment);
        btnHelp = findViewById(R.id.btnHelp);
        btnSettings = findViewById(R.id.btnSettings);
        ivLogo = findViewById(R.id.ivLogo);
        rLayout = findViewById(R.id.rLayout);
        tvTitle = findViewById(R.id.tvTitle);

        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        final boolean helpLaunch = sp.getBoolean("helpLaunch", true);

        if (helpLaunch) {
            btnItemSearch.setBackgroundResource(R.drawable.custom_button_false);
            btnSettings.setBackgroundResource(R.drawable.custom_button_settings_false);
            btnEnvironment.setBackgroundResource(R.drawable.custom_button_false);
            tvTitle.setText(R.string.tutorialStatement);
        } else {
            rLayout.setBackgroundResource(R.drawable.ic_background_true);
            tvTitle.setText(R.string.welcomeStatement);
        }

        animateObjs();

        btnItemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (helpLaunch) {
                } else {
                    btnItemSearch.setBackgroundResource(R.drawable.custom_button_true);
                    Intent intent = new Intent(MainActivity.this, NavActivity.class);
                    intent.putExtra("instruction", "search");
                    startActivity(intent);
                }
            }
        });

        btnEnvironment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (helpLaunch) {
                } else {
                    btnEnvironment.setBackgroundResource(R.drawable.custom_button_true);
                    Intent intent = new Intent(MainActivity.this, NavActivity.class);
                    intent.putExtra("instruction", "environment");
                    startActivity(intent);
                }
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("helpLaunch", false);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                intent.putExtra("instruction", "help");
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (helpLaunch) {
                } else {
                    btnSettings.setBackgroundResource(R.drawable.custom_button_settings_true);
                    Intent intent = new Intent(MainActivity.this, NavActivity.class);
                    intent.putExtra("instruction", "settings");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    public void animateObjs() {
        final Animation animF = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        tvTitle.startAnimation(animF);

        Interpolator interpolator = new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return getPowIn(v,2);   //add getPowIn(v,3); for more down animation
            }
            private float getPowIn(float elapsedTimeRate, double pow) {
                return (float) Math.pow(elapsedTimeRate, pow);
            }
        };

        ObjectAnimator animator = ObjectAnimator.ofFloat(ivLogo, "translationY", 0, 25, 0);
        animator.setInterpolator(interpolator);
        animator.setStartDelay(200);
        animator.setDuration(800);
        animator.setRepeatCount(-1);
        animator.start();
    }

}


