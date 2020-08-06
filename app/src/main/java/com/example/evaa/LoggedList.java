package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class LoggedList extends AppCompatActivity {

    private ImageButton btnExit;
    private ListView listLogged;
    private List<String> displayList = new ArrayList();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_list);
        btnExit = findViewById(R.id.btnExit);
        listLogged = (ListView) findViewById(R.id.listLogged);

        final DatabaseHelper databaseHelper = new DatabaseHelper(LoggedList.this);
        displayList = databaseHelper.getData();

        adapter = new ArrayAdapter<String>(LoggedList.this, android.R.layout.simple_list_item_1, displayList);
        listLogged.setAdapter(adapter);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            databaseHelper.deleteAll();
//                Intent intent = new Intent(LoggedList.this,
//                        Environment.class);
//                startActivity(intent);
            }
        });
    }

}