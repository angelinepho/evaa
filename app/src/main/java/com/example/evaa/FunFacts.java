package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FunFacts extends AppCompatActivity {

    LinearLayout llTap;
    ImageView ivEarth;
    TextView tvFactTitle, tvFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun_facts);

        llTap = findViewById(R.id.llTap);
        ivEarth = findViewById(R.id.ivEarth);
        tvFactTitle = findViewById(R.id.tvFactTitle);
        tvFact = findViewById(R.id.tvFact);

        tvFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FunFacts.this,
                        Options.class);

                startActivity(intent);

            }
        });



    }
}