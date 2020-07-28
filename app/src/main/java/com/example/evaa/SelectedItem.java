package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;


public class SelectedItem extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private TextView image_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_item);

        btnAdd = findViewById(R.id.btnAdd);
        mDatabaseHelper = new DatabaseHelper(this);
        image_description = findViewById(R.id.image_description);

        getIncomingIntent();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = image_description.getText().toString();
                if (name.length() != 0) {
                    AddData(name);
                } else {
                    Toasty.warning(SelectedItem.this, "No Item to Log", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            Toasty.success(SelectedItem.this, "Log Success", Toast.LENGTH_SHORT, true).show();
        } else {
            Toasty.error(SelectedItem.this, "Log Error", Toast.LENGTH_SHORT, true).show();
        }
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") &&
                getIntent().hasExtra("image_alternative") && getIntent().hasExtra("image_disposal")) {

            Integer imageUrl = getIntent().getIntExtra("image_url", 0);
            String imageName = getIntent().getStringExtra("image_name");
            String imageAlternative = getIntent().getStringExtra("image_alternative");
            String imageDisposal = getIntent().getStringExtra("image_disposal");

            setImage(imageUrl, imageName, imageAlternative, imageDisposal);
        }
    }

    private void setImage(Integer imageUrl, String imageName, String imageAlternative, String imageDisposal) {
        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(imageUrl);

        TextView alternative = findViewById(R.id.image_alternative);
        alternative.setText(imageAlternative);

        TextView disposal = findViewById(R.id.image_disposal);
        disposal.setText(imageDisposal);
    }

}