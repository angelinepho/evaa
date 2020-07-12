package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tvInstruction;
    Button btnItemSearch, btnEnvironment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvInstruction = findViewById(R.id.tvInstruction);
        btnItemSearch = findViewById(R.id.btnItemSearch);
        btnEnvironment = findViewById(R.id.btnEnvironment);

        btnItemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity3.this,
                        com.example.evaa.MainActivity4.class);

                startActivity(intent);
            }
        });

        btnEnvironment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity3.this,
                        com.example.evaa.MainActivity5.class);

                startActivity(intent);

            }
        });
    }
}