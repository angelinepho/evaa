package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ItemsPage extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_page);

        initImageBitmaps();
    }

    private void initImageBitmaps() {
        mImageUrls.add("https://joneschips.com/wp-content/uploads/2017/02/1oz-bag-resized-1.png");
        mNames.add("Chip Bag");

        mImageUrls.add("https://marketresearchbiz-ikwnsbmbizhvmufcjx.netdna-ssl.com/wp-content/uploads/2019/03/adult-diapers-market.png");
        mNames.add("Diapers");

        mImageUrls.add("https://www.orbitgum.com/images/flavor-boxes/white-spearmint.png");
        mNames.add("Gum");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}