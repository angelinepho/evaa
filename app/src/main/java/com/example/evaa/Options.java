package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.evaa.ItemsPage;

public class Options extends AppCompatActivity {

    TextView tvInstruction;
    Button btnItemSearch, btnEnvironment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        tvInstruction = findViewById(R.id.tvInstruction);
        btnItemSearch = findViewById(R.id.btnItemSearch);
        btnEnvironment = findViewById(R.id.btnEnvironment);

        btnItemSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Options.this,
                        ItemsPage.class);
                startActivity(intent);
            }
        });
        btnEnvironment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Options.this,
                        Environment.class);
                startActivity(intent);
            }
        });

        openDialog();
    }

    public void openDialog() {
        FunFactDialog dialog = new FunFactDialog();
        dialog.show(getSupportFragmentManager(), "This is openDialog()");
    }



}