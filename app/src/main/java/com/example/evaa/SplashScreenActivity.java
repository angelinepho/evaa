package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#EAECEE"))
                .withHeaderText("Header")
                .withFooterText("Footer")
                .withBeforeLogoText("Before Logo Text")
                .withAfterLogoText("After Logo Text")
                .withLogo(R.drawable.ic_baseline_landscape_24);

        config.getHeaderTextView().setTextColor(Color.parseColor("#808B96"));
        config.getFooterTextView().setTextColor(Color.parseColor("#808B96"));
        config.getBeforeLogoTextView().setTextColor(Color.parseColor("#808B96"));
        config.getAfterLogoTextView().setTextColor(Color.parseColor("#808B96"));

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}