package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class LoggedList extends AppCompatActivity {

    private ImageButton btnExit;
    ListView listLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_list);
        btnExit = findViewById(R.id.btnExit);
        listLogged = findViewById(R.id.listLogged);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoggedList.this,
                        Environment.class);
                startActivity(intent);
            }
        });
    }
}