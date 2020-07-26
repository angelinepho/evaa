package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SelectedItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_item);

        getIncomingIntent();
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