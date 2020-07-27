package com.example.evaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;


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

        mImageUrls.add(R.drawable.ic_camera);
        mNames.add("Camera (digital)");
        mAlternative.add("Purchase a camera with shutter counts ranging anywhere from 50,000 shutters to 1,000,000 or more. This will ensure a long lifespan for the camera.");
        mDisposal.add("Major retailers with electronics recycling programs, including Best Buy and Staples, will take them off your hands at no charge.");

        mImageUrls.add(R.drawable.ic_candy);
        mNames.add("Candy Wrappers");
        mAlternative.add("Buy candy in bulk and choose candies with bio-based packaging, like M&Ms. Consider using the wrapper to make something.");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_cardboard);
        mNames.add("Cardboard");
        mAlternative.add("Large plastic tubs can replace cardboard boxes if needed");
        mDisposal.add("Shiny and regular cardboard can be recycled, while waxed cardboard should be disposed of in the trash. When applicable, remove all tape, break down and flatten the box, and remove any contaminated pieces.");

        mImageUrls.add(R.drawable.ic_cartons);
        mNames.add("Cartons");
        mAlternative.add("Look for sustainable packaging, like reusable glass jugs.");
        mDisposal.add("Remove all liquid, leave caps on container, and put this item in your home recycling (do not bag your recyclables).");

        mImageUrls.add(R.drawable.ic_chip_bags);
        mNames.add("Chip Bags");
        mAlternative.add("Find 100% compostable chip bags.");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_christmas_tree_artificial);
        mNames.add("Christmas Tree (artificial)");
        mAlternative.add("Rent a tree, decorate a plant or tree you already have, ladder christmas tree, drift wood trees, buy second hand, book christmas tree, etc. (get creative)");
        mDisposal.add("Donate if in reusable condition. Trees that cannot be reused may be placed in the trash. Metal poles can be recycled as scrap metal.");

        mImageUrls.add(R.drawable.ic_christmas_tree_natural);
        mNames.add("Christmas Tree (natural)");
        mAlternative.add("Rent a tree, decorate a plant or tree you already have, ladder christmas tree, drift wood trees, buy second hand, book christmas tree, etc. (get creative)");
        mDisposal.add("It is illegal to place yard waste like Christmas trees in the trash. Remove all tinsel, lights, decorations, tree stands, and plastic bags from Christmas trees prior to collection. Leave out for garbage hauler to pick-up, but some haulers require residents to schedule a pick-up time (call them for details).");

        mImageUrls.add(R.drawable.ic_clothes);
        mNames.add("Clothes");
        mAlternative.add("Avoid buying unnecessary clothing. If that is not possible, buy second hand or from sustainable companies (i.e. Patagonia, Reformation, etc.). Also look for eco-friendly fibers, like linen, hemp, bamboo, lyocell, alpaca, organic wool, and silk).");
        mDisposal.add("If reuse or donation is not an option, place clothing and shoes in the garbage.");

        mImageUrls.add(R.drawable.ic_coal_ash);
        mNames.add("Coal Ash");
        mAlternative.add("Gas grills are more energy efficient than charcoal grills. Or consider logs and wood pellets.");
        mDisposal.add("If you heat your home with coal, you should put the ash in a bag and dispose of it in your trash. Be aware that the ash can still brun for 4-6 weeks after they've been removed.");

        mImageUrls.add(R.drawable.ic_coat_hanger);
        mNames.add("Coat Hangers");
        mAlternative.add("Reduce your consumption by not bringing home hangers from stores. Bring your own hangers to the dry cleaners to reduce their usage.");
        mDisposal.add("All types of coat hangers cannot be recycled, Either dispose of in trash, or donate to thrift stores or dry cleaners.");

        mImageUrls.add(R.drawable.ic_coffee_grounds_filter);
        mNames.add("Coffee Grounds/Filters");
        mAlternative.add("Find sustainable local coffee roasters or brands that uphold ethical practices. Use reusable coffee filters (i.e. Keurig's My K-Cup filters, stainless steel filters, and reusable organic hemp coffee filter)");
        mDisposal.add("Place this item in a backyard composter. Aim for 1/3 \"green\" materials (fruits, vegetables) and 2/3 \"brown\" materials (leaves, branches). Remember to turn the compost pile regularly.");

        mImageUrls.add(R.drawable.ic_cosmetic);
        mNames.add("Cosmetic Products");
        mAlternative.add("Purchase makeup from eco-friendly brands. Research and read reviews beforehand to limit the amount of products you purchase. Avoid single-use products, such as cotton pads and makeup-remover wipes, by looking into alternatives.");
        mDisposal.add("Various programs, such as TerraCycle and Return to Origins, accept makeup containers and will recycle them for you. Alternatively, look into reusing empty containers and products.");

        mImageUrls.add(R.drawable.ic_cotton_balls_rounds);
        mNames.add("Cotton Balls/Rounds");
        mAlternative.add("Reusable cloth pads");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_cotton_swabs);
        mNames.add("Cotton Swabs (Q-tips)");
        mAlternative.add("Steer clear of cotton swabs with plastic stems. An even better options would be biodegradable swabs or reusable swabs (e.g. LastSwab, Bamboo ear picks).");
        mDisposal.add("Swabs with paper stems (white) should go into a compost bin. Swabs with plastic (colorful) stems should go into the trash.");

        mImageUrls.add(R.drawable.ic_crayons);
        mNames.add("Crayons");
        mAlternative.add("Crayons made from soy or beeswax");
        mDisposal.add("Small crayon pieces can be melted and turned into new crayons. Organizations, like the National Crayon Recycle Program or Crayola ColorCycle, accept and upcycle old crayons into new crayons.");

        mImageUrls.add(R.drawable.ic_deodorant);
        mNames.add("Deodorant");
        mAlternative.add("Natural deodorants");
        mDisposal.add("Research what plastics are used in the making of your deodorant. Disassemble the deodorant to obtain the plastics that are recyclable.");

        mImageUrls.add(R.drawable.ic_detergent_bottles);
        mNames.add("Detergent Bottles");
        mAlternative.add("Baking soda, Soap nuts");
        mDisposal.add("Rinse the bottle and cap with warm water until both are cleaned, Face the bottle down and let it air dry completely, Secure the cap once dried, Removing the labels is not necessary, Place in your recycling bin, If there are no curbside programs available, visit TerraCycle to download a free shipping label to send your container.");

        mImageUrls.add(R.drawable.ic_diapers);
        mNames.add("Diapers");
        mAlternative.add("Reusable Diapers or Eco-friendly Diapers");
        mDisposal.add("Dump diaper contents into tiolet, wrap up the diaper, throw into the garbage.");

        mImageUrls.add(R.drawable.ic_dish_washer);
        mNames.add("Dish Washer");
        mAlternative.add("Manually washing dishes in the sink");
        mDisposal.add("Dish washer can be resold. It can also be recycled by Best Buy, Lowe's, and Home Depot for a fee. Lastly, you can also donate it to charities.");

        mImageUrls.add(R.drawable.ic_disposable_razor);
        mNames.add("Disposable Razors (plastic)");
        mAlternative.add("Purchase a razor handle that utilizes razor blade refills or an electric shaver.");
        mDisposal.add("Rinse and allow the razor to dry. Then, visit TerraCycle to download a free shipping label to send your razor.");

        mImageUrls.add(R.drawable.ic_dryer);
        mNames.add("Dryer");
        mAlternative.add("Air drying");
        mDisposal.add("If the dryer still works, it can be sold/donated to appliance retailers, charities, the Salvation army, etc. Otherwise, local recyclers will take it or srap metal recyclers will take it and pay you for the metal.");

        mImageUrls.add(R.drawable.ic_dryer_sheets);
        mNames.add("Dryer Sheets");
        mAlternative.add("Wool dryer balls");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_e_reader);
        mNames.add("E-reader");
        mAlternative.add("not available");
        mDisposal.add("Drop-off at electronic waste collections (e.g. Best Buy, Office Depot/Max)");

        mImageUrls.add(R.drawable.ic_fabric);
        mNames.add("Fabric Softener");
        mAlternative.add("Distilled white vinegar");
        mDisposal.add("Utilize contents fully. Rinse out container. Bottle can be recycled if made from #1 plastic(PET) or #2 plastic(HDPE), which are accepted by most curbside recycling programs. Most recycling programs ask for rinsed bottles before recycling. Check with your local program whether or not caps should be kept on the bottle. Leaving the label on should be ok. Commonly: All brands of paperboard laundry care packaging and #5 plastic laundry caps and #2 plastic laundry bottles are ok.");

        mImageUrls.add(R.drawable.ic_fan);
        mNames.add("Fan");
        mAlternative.add("Install ceiling fans, provide shade, keep windows closed during the day, plant your garden strategically, high-efficiency air conditioning unit, install blinds, insulate your attic, paint your roof, etc.");
        mDisposal.add("Consider donating fans in good condition for reuse, place fan outside in a visible location for furniture and appliance collection, small fans can be places in the trash.");

        mImageUrls.add(R.drawable.ic_feminine_hygiene_products);
        mNames.add("Feminine Hygiene Products");
        mAlternative.add("Organic cotton pads and tampons, reusable pads and tampons, diva cups, and reusable period panties");
        mDisposal.add("Cannot be recycled, Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_floss);
        mNames.add("Floss (dental)");
        mAlternative.add("Silk floss, silk floss with beeswax, silk floss with candelilla wax, and vegan floss without a plastic case");
        mDisposal.add("Put common nylon (plastic) floss in the trash.");

        mImageUrls.add(R.drawable.ic_flour_grains);
        mNames.add("Flour & Grains");
        mAlternative.add("not available");
        mDisposal.add("Place this in compost. Make sure to turn your compost regularly and aim for 1/3 \"green\" material (fruits, vegetables) and 2/3 \"brown\" material (leaves, branches).");

        mImageUrls.add(R.drawable.ic_fluorescent_tube);
        mNames.add("Fluorescent Tube (lighting)");
        mAlternative.add("LED light bulbs, LED tube lighting, natural lighting, candles, CMH lighting, and Halogen");
        mDisposal.add("Take this to a household hazardous waste disposal facility. Do not put in your home trash or recycling cart without consulting your local disposal agency.");

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
        return super.onCreateOptionsMenu(menu);
    }
}