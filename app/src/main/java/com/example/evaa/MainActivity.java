package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout llTap;
    ImageView ivEarth;
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llTap = findViewById(R.id.llTap);
        ivEarth = findViewById(R.id.ivEarth);
        tvWelcome = findViewById(R.id.tvWelcome);

        llTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        com.example.evaa.MainActivity2.class);

                startActivity(intent);

            }
        });

    }
}