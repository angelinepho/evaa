package com.example.evaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity6 extends AppCompatActivity {

    TextView tvItemDisplay;
    ImageView ivCheck;
    int ACTIVITY4 = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tvItemDisplay = findViewById(R.id.tvItemDisplay);
        ivCheck = findViewById(R.id.ivCheck);

        Intent intent = getIntent();
        tvItemDisplay.setText(intent.getStringExtra("item"));

        ivCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ivCheck.setImageResource(R.drawable.filled_check);

                Intent intent = new Intent(MainActivity6.this,
                        com.example.evaa.MainActivity5.class);

                startActivity(intent);
            }
        });

    }
}