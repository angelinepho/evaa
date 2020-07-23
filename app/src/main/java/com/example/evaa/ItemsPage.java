package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemsPage extends AppCompatActivity {

    TextView etItem;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_page);

        etItem = findViewById(R.id.etItem);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = etItem.getText().toString().trim();

                Intent intent = new Intent(ItemsPage.this,
                        SelectedItem.class);

                intent.putExtra("item", item);
                startActivity(intent);
            }
        });



    }
}