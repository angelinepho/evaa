package com.example.evaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

public class ItemsPage extends AppCompatActivity {

    RecyclerViewAdapter adapter;

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
        mImageUrls.add(R.drawable.ic_bandage_band_aid);
        mNames.add("Adhesive Bandages");
        mAlternative.add("Biodegradable adhesive bandages, DIY Kombucha SCOBY remedy");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_aerosol_can);
        mNames.add("Aerosol Can");
        mAlternative.add("Eco-friendly spray cans or more sustainable applications, like foams or solids");
        mDisposal.add("Empty aerosol cans that once contained food can go in recycling. Cans with paint or hazardous materials need to be disposed of at a household hazardous waste (HHW) collection.");

        mImageUrls.add(R.drawable.ic_air_conditioner);
        mNames.add("Air Conditioner");
        mAlternative.add("Purchase air conditioners with higher BTUs and an Energy Star Certification. Also consider size, scheduling programs, and modification options.");
        mDisposal.add("If the air conditioner is in working condition, donate it. Otherwise, contact your local recycling coordinator, find an appliance recycling program, or contact you local utility company to see if they will accept your old air conditioner for proper disposal. Some utility companies offer rebate programs when you upgrade to a more energy efficient air cooling system.");

        mImageUrls.add(R.drawable.ic_aluminum_foil);
        mNames.add("Aluminum Foil");
        mAlternative.add("For food storage, try reusable silicone or glass containers. For baking, try silicone baking sheets or parchment paper. For grilling purposes, try using a reusable grill basket or grill mesh mats.");
        mDisposal.add("This item may be recyclable depending on your hauler. Please check if they accept this material.");

        mImageUrls.add(R.drawable.ic_ammunition);
        mNames.add("Ammunition");
        mAlternative.add("Biodegradable Bullets");
        mDisposal.add("Do not put ammunition in the trash! To properly dispose of old or excess ammunition, contact you local police/public safety department or state police to surrender the ammunition.");

        mImageUrls.add(R.drawable.ic_animal_bed);
        mNames.add("Animal Bedding");
        mAlternative.add("Find brands that are responsible and uphold environmental practices.");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_animal_waste);
        mNames.add("Animal Waste");
        mAlternative.add("Biodegradable poop bags, flushable poop bags, outdoor flushing, waste digester, composting, worm farming");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_antifreeze);
        mNames.add("Antifreeze");
        mAlternative.add("Vegetable Based Antifreeze");
        mDisposal.add("Antifreeze should be brought to a household hazardous waste (HHW) collection because it can pollute and harm.");

        mImageUrls.add(R.drawable.ic_art_canvas);
        mNames.add("Art Canvas");
        mAlternative.add("Recycled Canvas or Canvas made from Eco Friendly Materials (e.g. hemp, belgium linen, not cotton)");
        mDisposal.add("Donate used or unused canvases. Used canvases can be painted over, but unusable canvases should be thrown away.");

        mImageUrls.add(R.drawable.ic_art_supplies);
        mNames.add("Art Supplies");
        mAlternative.add("Clean up wisely by reusing solvents, dispose of toxic materials properly, limit waste of paint, choose green supply companies and safer materials, reuse supports and other materials, cut down on paper and recycle it, reuse packing materials, and limit energy and water consumption while creating.");
        mDisposal.add("If the art supplies can still be used for their intended purposes, consider donating to schools or charities. If the supplies can not be used, determine if they contain toxic material. If they do, they should be brought to a household hazardous waste (HHW) collection.");

        mImageUrls.add(R.drawable.ic_ash_from_charcoal_grills);
        mNames.add("Ash from Charcoal Grills");
        mAlternative.add("Gas grills are more energy efficient than charcoal grills. Or consider logs and wood pellets.");
        mDisposal.add("Ash from charcoal briquettes with or without lighter fuild should be put in a bag and disposed of with your trash.");

        mImageUrls.add(R.drawable.ic_ash_from_manufactured_logs_and_pellets);
        mNames.add("Ash from Logs and Pellets");
        mAlternative.add("not available");
        mDisposal.add("Usually manufactured logs and pellets are made form wood waste, sawdust, and waxes. Make sure the product contains natural adhesive (natural waxes and oils) vs. petroleum-based products. Products with natural adhesive should be applied to your garden, soil, or compost. Throw away ash with  petroleum-based products or unknown substances.");

        mImageUrls.add(R.drawable.ic_auto_product_bottle);
        mNames.add("Auto Product Bottles");
        mAlternative.add("not available");
        mDisposal.add("Put the item in your trash.");

        mImageUrls.add(R.drawable.ic_automotive_batteries);
        mNames.add("Automotive Batteries");
        mAlternative.add("not available");
        mDisposal.add("Return lead-acid auto batteries for recycling at retail stores that sell such batteries. Some towns accept lead-acid auto batteries at their local transfer station.");

        mImageUrls.add(R.drawable.ic_ballpen);
        mNames.add("Ballpoint Pens");
        mAlternative.add("Fountain pen");
        mDisposal.add("Send to Terracycle's Pens, Pencils and Markers Zero Waste Box program, or look for other programs that recycle.");

        mImageUrls.add(R.drawable.ic_bandage);
        mNames.add("Bandages");
        mAlternative.add("Biodegradable bandages, DIY Kombucha SCOBY remedy");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_bedding_bed_sheets);
        mNames.add("Bedding/Bed Sheets");
        mAlternative.add("Look for sustainable bedding brands that uphold environmental and ethical standards. This can include companies that practice zero waste and fair trade.");
        mDisposal.add("Donate usable bedding materials and linens. Place unusable items in the trash.");

        mImageUrls.add(R.drawable.ic_books_textbooks);
        mNames.add("Books");
        mAlternative.add("Try digital readings, support local libraries, purchase used books.");
        mDisposal.add("Donate books to local libraries, charities, and businesses.");

        mImageUrls.add(R.drawable.ic_bubble_wrap);
        mNames.add("Bubble Wrap/Air Pillows");
        mAlternative.add("Paper padding, Newspaper.");
        mDisposal.add("Dispose of at special recycling centers, Call mail stores to see if they accept donations, Otherwise, dispose of in the trash.");

//        mImageUrls.add(R.drawable.ic_);
//        mNames.add("");
//        mAlternative.add("");
//        mDisposal.add("");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(mNames, mImageUrls, mAlternative, mDisposal, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    // search bar


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }
}