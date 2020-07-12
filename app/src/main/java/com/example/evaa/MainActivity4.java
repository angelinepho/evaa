package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {

    TextView etItem;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        etItem = findViewById(R.id.etItem);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = etItem.getText().toString().trim();

                Intent intent = new Intent(MainActivity4.this,
                        com.example.evaa.MainActivity6.class);

                intent.putExtra("item", item);
                startActivity(intent);
            }
        });



    }
}