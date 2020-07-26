package com.example.evaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ItemsPage extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mAlternative = new ArrayList<>();
    private ArrayList<String> mDisposal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_page);

        initImageBitmaps();
    }

    private void initImageBitmaps() {
        mImageUrls.add(R.drawable.ic_aerosol_can);
        mNames.add("Aerosol Can");
        mAlternative.add("Eco-friendly spray cans or more sustainable applications, like foams or solids");
        mDisposal.add("Empty aerosol cans that once contained food can go in recycling. Cans with paint or hazardous materials need to be disposed of at a household hazardous waste (HHW) collection.");

        mImageUrls.add(R.drawable.ic_air_conditioner);
        mNames.add("Air Conditioner");
        mAlternative.add("Purchase air conditioners with higher BTUs and an Energy Star Certification. Also consider size, scheduling programs, and modification options.");
        mDisposal.add("If the air conditioner is in working condition, donate it. Otherwise, contact your local recycling coordinator, find an appliance recycling program, or contact you local utility company to see if they will accept your old air conditioner for proper disposal. Some utility companies offer rebate programs when you upgrade to a more energy efficient air cooling system.");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, mAlternative, mDisposal, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }
}