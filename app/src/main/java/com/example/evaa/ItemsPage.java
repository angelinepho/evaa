package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsPage extends AppCompatActivity {

    TextView etItem;
    Button btnSubmit;
    RecyclerView rvItems;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    private static final String TAG = "ItemsPage";
    ArrayList<String> mItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_page);

        etItem = findViewById(R.id.etItem);
        btnSubmit = findViewById(R.id.btnSubmit);
        rvItems = findViewById(R.id.rvItems);

        mItems = new ArrayList<>();
        mItems.add("Gum");
        mItems.add("Chip bags");

        for (int i = 0; i < 30; i++) {
            mItems.add("Floss");
        }

        rvItems.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 3);
        mAdapter = new MainAdapter(mItems);
        rvItems.setLayoutManager(mLayoutManager);
        rvItems.setAdapter(mAdapter);

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