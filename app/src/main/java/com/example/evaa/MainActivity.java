package com.example.evaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnItemSearch, btnEnvironment, btnHelp, btnSettings;
    ImageView ivLogo;
    RelativeLayout rLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnItemSearch = findViewById(R.id.btnItemSearch);
        btnEnvironment = findViewById(R.id.btnEnvironment);
        btnHelp = findViewById(R.id.btnHelp);
        btnSettings = findViewById(R.id.btnSettings);
        ivLogo = findViewById(R.id.ivLogo);
        rLayout = findViewById(R.id.rLayout);

        SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
        final boolean helpLaunch = sp.getBoolean("helpLaunch", true);

        if (helpLaunch) {
            btnItemSearch.setBackgroundResource(R.drawable.custom_button_false);
            btnSettings.setBackgroundResource(R.drawable.custom_button_settings_false);
            btnEnvironment.setBackgroundResource(R.drawable.custom_button_false);
        } else {
            rLayout.setBackgroundResource(R.drawable.ic_background_true);
        }


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

}


