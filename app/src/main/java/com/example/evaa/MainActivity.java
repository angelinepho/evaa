package com.example.evaa;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnItemSearch, btnEnvironment, btnHelp, btnSettings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnItemSearch = findViewById(R.id.btnItemSearch);
        btnEnvironment = findViewById(R.id.btnEnvironment);
        btnHelp = findViewById(R.id.btnHelp);
        btnSettings = findViewById(R.id.btnSettings);

        btnItemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                intent.putExtra("instruction", "search");
                startActivity(intent);
            }
        });

        btnEnvironment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                intent.putExtra("instruction", "environment");
                startActivity(intent);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                intent.putExtra("instruction", "help");
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavActivity.class);
                intent.putExtra("instruction", "settings");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}


