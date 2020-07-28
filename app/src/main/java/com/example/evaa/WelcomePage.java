package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    private LinearLayout llTap;
    private ImageView ivEarth;
    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        llTap = findViewById(R.id.llTap);
        ivEarth = findViewById(R.id.ivEarth);
        tvWelcome = findViewById(R.id.tvWelcome);
        final Typeface typeface = ResourcesCompat.getFont(this, R.font.oswald);
        tvWelcome.setTypeface(typeface);

        llTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideTransition();
            }
        });
    }

    public void slideTransition() {
        llTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomePage.this, Options.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slidein_bottom, R.anim.slideout_top);
            }
        });
    }
}