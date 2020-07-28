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

        mImageUrls.add(R.drawable.ic_shampoo_bottle);
        mNames.add("Conditioner Bottle");
        mAlternative.add("Conditioner bars");
        mDisposal.add("Fully utilize conditioner mixture. Bottle can be recycled if made from #1 plastic(PET) or #2 plastic(HDPE), which are accepted by most curbside recycling programs. Most recycling programs ask for rinsed bottles before recycling. Check with your local program whether or not caps should be kept on the bottle. Leaving the label on should be ok.");

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

        mImageUrls.add(R.drawable.ic_garden_hose);
        mNames.add("Garden Hose");
        mAlternative.add("Choose natural rubber hoses instead of synthetic ones made from toxic PVC (Polyvinyl Chloride) that contain toxic chemicals and don’t break down well. There are also stainless steel garden hoses available that won’t kink and tangle. Remember not to leave your rubber garden hose out in the sun even for a couple of hours, as not only will it head the water, but it will also accelerate photodegradation.");
        mDisposal.add("Put this item in your trash.");

        mImageUrls.add(R.drawable.ic_gas_car);
        mNames.add("Gas-Fueled Cars");
        mAlternative.add("Hybrid cars, Electric cars, Public transportation, Bike");
        mDisposal.add("Trade it in, donate it, sell it.");

        mImageUrls.add(R.drawable.ic_gift_card);
        mNames.add("Gift Cards");
        mAlternative.add("Online credits, biodegradable paper gift cards, wood gift cards");
        mDisposal.add("These cannot be recycled in curbside recycling. Find a drop-off location or mail-in program, which usually accepts PVC-made (Polyvinyl chloride) gift cards.");

        mImageUrls.add(R.drawable.ic_gift_wrapping);
        mNames.add("Gift Wrapping/Wrapping Paper");
        mAlternative.add("Reusable fabric (tenugui cloth)");
        mDisposal.add("Wrapping paper without additives (i.e. glitter or plastics) can often be recycled through your local curbside program.");

        mImageUrls.add(R.drawable.ic_glass_of_water);
        mNames.add("Glass");
        mAlternative.add("Glass is a great alternative to plastic, as it is 100% recyclable. Consider reusing purchased glass jars, e.g pasta sauce jars, rather than purchasing a set. ");
        mDisposal.add("Broken glass are hazardous and should be wrapped in newspaper or a plastic bag, then disposed of in the trash. Glassware and Pyrex should be placed in the trash due to their high melting points. Glass jars should be separated from their lids and recycled separately. Be sure to clean jars before disposing of them.");

        mImageUrls.add(R.drawable.ic_greeting_cards);
        mNames.add("Greeting Cards");
        mAlternative.add("Send E-Cards, make your own card from scrap material, or pick from a selection of sustainable greeting card brands. For example, Seedy Cards sells plantable greeting cards that produce wild flowers.");
        mDisposal.add("Musical greeting cards contain button batteries and circuit boards. Remove the button battery and circuit board card and recycle the card (do not bag your home recyclables). Donate unused greeting cards to secondhand stores. Cards are great to reuse for crafts around the holidays: cut to make gift tags, use the front part as a postcard greeting card, and more.");

        mImageUrls.add(R.drawable.ic_gum);
        mNames.add("Gum");
        mAlternative.add("Chicle-based gum which is compostable,  Gum wrapped in paper or biodegradable packaging");
        mDisposal.add("Blister packs and foil wrappers cannot be recycled and should be disposed of in trash. Plastic gum containers can be reused. If the container is labeled #2, it can be recycled, otherwise, dispose of in trash.");

        mImageUrls.add(R.drawable.ic_hair_dryer);
        mNames.add("Hair Dryer");
        mAlternative.add("Air dry hair");
        mDisposal.add("Drop off at a local scrap metal recycling center.");

        mImageUrls.add(R.drawable.ic_hair_products);
        mNames.add("Hair Products");
        mAlternative.add("Looks for brands that operate sustainably in some way. Try to avoid single use plastic. If that is not possible buying the extra large sizes or opting into the refill system can help cut your waster further.");
        mDisposal.add("Bring liquid products and aerosol cans to The Recycling Zone. Dry product can go in the trash. Empty bottles can go in your home recycling cart.");

        mImageUrls.add(R.drawable.ic_headphones);
        mNames.add("Headphones/Earbuds");
        mAlternative.add("Invest in quality headphones to prevent early breakage and frequent disposal.");
        mDisposal.add("If your headphones are beyond repair, reach out to local recycling facilities for proper disposal or reach out to electronic stores for possible trade-ins or recycling programs.");

        mImageUrls.add(R.drawable.ic_kitchen_oil);
        mNames.add("Kitchen Grease/Cooking Oil");
        mAlternative.add("not available");
        mDisposal.add("Small amount: let the oil cool in the pan, wipe up with paper towel and discard in trash. Large amount: pour the grease into a can or jar and let it cool, once filled, seal it as best as possible and dispose of in trash.");

        mImageUrls.add(R.drawable.ic_lip_balm);
        mNames.add("Lip Balm/ChapStick");
        mAlternative.add("Find zero waste lip balm or make your own lip balm in a reusable container.");
        mDisposal.add("Keep the container and refill it with homemade lipblam or check if the lipbalm company has a recycling take back program. If neither of these apply, contact your local waste management agency to see if they accept this item.");

        mImageUrls.add(R.drawable.ic_lithium_battery);
        mNames.add("Lithium Batteries");
        mAlternative.add("not available");
        mDisposal.add("Any type of lithium battery should not be put in the trash. Please bring to a household hazardous waste (HHW) collection in your area.");

        mImageUrls.add(R.drawable.ic_lotion);
        mNames.add("Lotion");
        mAlternative.add("Aloe vera, shea butter, cocoa butter, olive oil");
        mDisposal.add("Go online and contact your local disposal center to see if they accept cosmetics as hazardous waste. Else, clean out the product as much as you can and then you can recycle the item.");

        mImageUrls.add(R.drawable.ic_mascara_wand);
        mNames.add("Mascara Wand");
        mAlternative.add("not available");
        mDisposal.add("Clean the wand with Dawn liquid soap. Place into a Ziploc bag and mail to a Wildlife Refuge Accepting donations.");

        mImageUrls.add(R.drawable.ic_mechanical_pencil);
        mNames.add("Mechanical Pencil");
        mAlternative.add("Wooden pencils, typing");
        mDisposal.add("Send to Terracycle's Pens, Pencils and Markers Zero Waste Box program or look for other programs that recycle.");

        mImageUrls.add(R.drawable.ic_medical_mask);
        mNames.add("Medical Face Masks");
        mAlternative.add("Unless the face masks are for medical purposes, purchase or create your own reusable cloth masks.");
        mDisposal.add("Surgical masks should be folded inwards so that the inside is no longer exposed, then placed in tissue paper or a bag. N95 respirator masks should simply be placed in a plastic bag. Both should be disposed of in the trash. Be sure to wash your hands before and after handling masks.");

        mImageUrls.add(R.drawable.ic_medications);
        mNames.add("Medications (prescription & over-the-counter)");
        mAlternative.add("not available");
        mDisposal.add("Do not pour medications down the sink or flush down the toilet. Find a medication drop-off station near you. Drop-off is safe and anonymous. Keep medicine in it's original container (sealed). Cross your name off the container.");

        mImageUrls.add(R.drawable.ic_microwave);
        mNames.add("Microwave");
        mAlternative.add("Look for a microwave that will stand the test of time. If possible find a microwave that combines other appliances, like an oven. Also, keep in mind whether this is an essential appliance for you. Some brands to look at are Miele microwave, Smeg build-in microwave, Swan microwave, and Belling microwaves.");
        mDisposal.add("If it is in working condition, donate it. Otherwise, find a place to drop if off (trash companies, recycling/drop-off buildings).");

        mImageUrls.add(R.drawable.ic_mouthwash);
        mNames.add("Mouthwash");
        mAlternative.add("Make your own baking soda mouthwash (combine 2 ounces of water with 1/4 teaspoon of baking soda, 1 drop of pure pepperment oil, and 1 drop of tea tree oil in a reusable container) or herbal antibacterial mouthwash (first place 1 ounce of cloves or powdered myrrh or 2 to 4 ounces of goldenseal or rosemary in a pint-sized jar). You can also try plastic free tablet mouthwash or liquid mouthwash in a glass bottle.");
        mDisposal.add("Rinse the mouthwash bottle and place it in recycling.");

        mImageUrls.add(R.drawable.ic_newspaper);
        mNames.add("Newspaper");
        mAlternative.add("When possible, go digital.");
        mDisposal.add("Newspaper can be recycled or composted as long as it is clean.");

        mImageUrls.add(R.drawable.ic_nonrechargeable_household_battery);
        mNames.add("Non-Rechargeable Alkaline & Zinc Carbon Batteries");
        mAlternative.add("not available");
        mDisposal.add("These batteries are not hazardous and can be disposed of in regular trash (but recycling can be available).");

        mImageUrls.add(R.drawable.ic_notebook);
        mNames.add("Notebooks");
        mAlternative.add("Digital note taking");
        mDisposal.add("Ensure notebook is not stained in any way, then proceed to put in recycling container.");

        mImageUrls.add(R.drawable.ic_paper);
        mNames.add("Paper");
        mAlternative.add("When possible, go digital, Reuse old paper for crafts or scratch-work.");
        mDisposal.add("Paper can be recycled. Avoid tearing or shredding the paper into small pieces. Paper with glitter should be disposed of in the trash.");

        mImageUrls.add(R.drawable.ic_paper_towel_napkins);
        mNames.add("Paper Towels/Napkins");
        mAlternative.add("Cloth towels/napkins");
        mDisposal.add("Food-soiled, greasy, and chemical towels should be discarded into the garbage, Clean paper towels can be composted.");

        mImageUrls.add(R.drawable.ic_photography_film);
        mNames.add("Photographs/Film");
        mAlternative.add("Go digital!");
        mDisposal.add("Cannot be recycled, Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_plastic_bread);
        mNames.add("Plastic Bread Bag");
        mAlternative.add("Beeswax bread bag");
        mDisposal.add("Join Terracycle's Program in Partnership with Bimbo Bakeries USA. Collect, print label, and ship.");

        mImageUrls.add(R.drawable.ic_plastic_cup);
        mNames.add("Plastic Cups");
        mAlternative.add("Glassware, Reusable cups, Bring your own bottle for drinks when dining out");
        mDisposal.add("If applicable, remove the lid and discard it in the trash, Rinse the cup and allow it to dry completely, If the cup is #6 rigid plastic, visit TerraCycle for a free shipping label to send your cups. If the cup is clear and soft, place in the recycling bin.");

        mImageUrls.add(R.drawable.ic_plastic_loofah);
        mNames.add("Plastic Loofah");
        mAlternative.add("Biodegradable loofah from a Luffa Gourd plant");
        mDisposal.add("Reuse it in some way or discard in the trash.");

        mImageUrls.add(R.drawable.ic_plastic_shopping_bag);
        mNames.add("Plastic Shopping Bag");
        mAlternative.add("Reusable (cotton or hemp preferred) bag, Save already-owned plastic bags for additional use");
        mDisposal.add("Recyclable: Grocery & retail bags, Newspaper bags, the outer Wrapping from Napkins, Paper Towels, Bathroom Tissue & Diapers, Bread bags, Dry cleaning bags, the outer wrapping from bulk beverages, produce bags; All clean, dry bags Labeled #2 or #4. These can be disposed of through drop-off locations at some major retailers or through curbside pick-up programs. \n" +
                "Non-recyclable: Food or cling wrap, Prepackaged food bags (including frozen food bags and pre-washed salad bags), Plastic Film That has Been Painted or has Excessive Glue Residue.");

        mImageUrls.add(R.drawable.ic_plastic_straw);
        mNames.add("Plastic Straw");
        mAlternative.add("Stainless steel, glass, silicone, or paper straws, Request for drinks without straws when dining out");
        mDisposal.add("Cannot be recycled, Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_plastic_toys);
        mNames.add("Plastic Toys");
        mAlternative.add("Purchase toys from eco-friendly brands, Take proper care to allow for long usage.");
        mDisposal.add("Remove any batteries and dispose of them as hazardous waste. Toys with electronic parts should be disposed of as e-waste. Toys in a good condition should be donated, while broken toys should be sent to programs, such as Hasbro Toy's, to be recycled properly. Otherwise, dispose of in the trash.");

        mImageUrls.add(R.drawable.ic_plastic_utensils);
        mNames.add("Plastic Utensils");
        mAlternative.add("Metal or bamboo utensils, Wash and reuse old plastic utensils");
        mDisposal.add("Cannot be recycled, Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_plastic_water_bottle);
        mNames.add("Plastic Water Bottle");
        mAlternative.add("Reusable water bottle");
        mDisposal.add("Dump water where available; Best to dump on plants. Bottle can be recycled if made from #1 plastic(PET) or #2 plastic(HDPE), which are accepted by most curbside recycling programs. Most recycling programs ask for rinsed bottles before recycling. Check with your local program whether or not caps should be kept on the bottle. Leaving the label on should be ok.");

        mImageUrls.add(R.drawable.ic_plastic_wrap);
        mNames.add("Plastic/Saran Wrap");
        mAlternative.add("Beeswax wraps");
        mDisposal.add("Cannot be recycled. Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_razor_blade_refills);
        mNames.add("Razor Blade Refills");
        mAlternative.add("Electric shaver");
        mDisposal.add("Cannot be recycled. Use an old container to safely store and dispose of used razor blades, Alternatively wrap and secure used blades in paper.");

        mImageUrls.add(R.drawable.ic_rechargable_battery);
        mNames.add("Rechargeable Batteries");
        mAlternative.add("not available");
        mDisposal.add("Recycle at participating retail collection points including most Wal-Mart and Best Buy stores.");

        mImageUrls.add(R.drawable.ic_refrigerator);
        mNames.add("Refrigerator");
        mAlternative.add("Find an eco-friendly fridge design that is made to save energy. For example, some newer fridges have the ability to adjust to the temperature outside. Some more environmental designs include LG PANORAMA French Door Refrigerator, Oceania: Fridge designed by Tez Patel, 6596 Refrigerator from Kenmore, and RF266ABPN Refrigerator from Samsung.");
        mDisposal.add("It is illegal to place major appliances in household garbage because they have components that are harmful to health and the environment. Donate/resell working appliances or contact your local waste removal service to schedule a pick-up.");

        mImageUrls.add(R.drawable.ic_shampoo_bottle);
        mNames.add("Shampoo Bottle");
        mAlternative.add("Shampoo bars");
        mDisposal.add("Fully utilize shampoo mixture. Bottle can be recycled if made from #1 plastic(PET) or #2 plastic(HDPE), which are accepted by most curbside recycling programs. Most recycling programs ask for rinsed bottles before recycling. Check with your local program whether or not caps should be kept on the bottle. Leaving the label on should be ok.");

        mImageUrls.add(R.drawable.ic_shoes);
        mNames.add("Shoes");
        mAlternative.add("Eco-friendly brands for shoes");
        mDisposal.add("Shoes can be donated to a shoe company such as Nike's Reuse a Shoe program.");

        mImageUrls.add(R.drawable.ic_soap_wrapped_in_plastic);
        mNames.add("Soap Packaged in Plastic");
        mAlternative.add("Soap bar wrapped in cardboard or paper, biodegradable soap");
        mDisposal.add("Use soap fully and recycle plastic wrapping.");

        mImageUrls.add(R.drawable.ic_stove);
        mNames.add("Stove");
        mAlternative.add("Slow cooker/crock-Pot, microwave, hot plate, convection oven");
        mDisposal.add("Sell to appliance retailers, donate to charities, or recycle via recycling/disposal programs.");

        mImageUrls.add(R.drawable.ic_styrofoam);
        mNames.add("Styrofoam");
        mAlternative.add("Mushroom material, plantable packaging, edible packing peanuts, InCycle Cups, bamboo fiber eco bowl, EarthAware biodegradable packing material, etc. ");
        mDisposal.add("Cannot be recycled. Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_teabag);
        mNames.add("Teabags");
        mAlternative.add("Loose-leaf tea, herbal teas using fresh herbs, fruit water");
        mDisposal.add("Place this item in a backyard composter. Aim for 1/3 \"green\" materials (fruits, vegetables) and 2/3 \"brown\" materials (leaves, branches). Remember to turn the compost pile regularly.");

        mImageUrls.add(R.drawable.ic_television);
        mNames.add("Television");
        mAlternative.add("Newer televisions require less energy than old ones. Look on sust-it.net for the most energy efficient electronics.");
        mDisposal.add("Donate working TVs to a local charity, take it to a recycling facility/pick up service, return it to the manufacturer, sell it, give it away for free");

        mImageUrls.add(R.drawable.ic_tire);
        mNames.add("Tire");
        mAlternative.add("Look for green manufacturing, energy efficiency, and lower cost of ownership.");
        mDisposal.add("Call transfer station to ensure that your tires are accpeted. Do not place tires in garbage or recycling cart.");

        mImageUrls.add(R.drawable.ic_tissues);
        mNames.add("Tissues/Kleenex");
        mAlternative.add("Handkerchief");
        mDisposal.add("Cannot be recycled, Dispose of in trash.");

        mImageUrls.add(R.drawable.ic_to_go_containers);
        mNames.add("To-Go Container");
        mAlternative.add("Reusable lunch box");
        mDisposal.add("This varies depending on the material your to-go container is constructed from. Before disposing of, be sure to clean and dry your container Plastic and aluminum containers can be recycled, Wax-coated paper and foam containers cannot be recycled and should be disposed of in trash.");

        mImageUrls.add(R.drawable.ic_toner);
        mNames.add("Toner/Ink Cartridge");
        mAlternative.add("not available");
        mDisposal.add("Cannot be recycled. Dispose of in trash. Alternatively, recycle them at your local office retailer.");

        mImageUrls.add(R.drawable.ic_toothbrush);
        mNames.add("Toothbrush");
        mAlternative.add("Biodegradable toothbrushes with plant-based bristles");
        mDisposal.add("Electric toothbrushes should be disposed of following e-waste guidelines, Regular toothbrushes should be cleaned and dried completely, Visit TerraCycle to download a free shipping label to ship used toothbrushes.");

        mImageUrls.add(R.drawable.ic_toothpaste_tube);
        mNames.add("Toothpaste Tube");
        mAlternative.add("Use Zero Waste Plastic Free toothpaste (i.e. chewable toothpaste, powder toothpaste, mineral toothpaste, tooth nibs/tab/tablets).");
        mDisposal.add("Put toothpaste tubes in the trash. Alternatively, send used or empty oral care products and packaging to Terracycle's Program in partnership with Colgate.");

        mImageUrls.add(R.drawable.ic_unusable_fabric);
        mNames.add("Unusable Clothing/Fabric");
        mAlternative.add("not available");
        mDisposal.add("Place clothing and fabric that cannot be reused in a bag marked \"scraps\" and put in one a donation drop box. This material will be turned into rags or insulation.");

        mImageUrls.add(R.drawable.ic_vaping_pens_e_cigarettes);
        mNames.add("Vaping Pens/E-cigarettes");
        mAlternative.add("not available");
        mDisposal.add("Remove the filler material, rinsing it under running water until all nicotine residues are removed, and then wrapping it in a scrap of biodegradable material. Turn device 'off' before dropping off at e-waste collection site (e.g. Best Buy). Do not put vaping devices in the trash and recycling. Fires have been caused by the rechargeable battery.");

        mImageUrls.add(R.drawable.ic_washer);
        mNames.add("Washer");
        mAlternative.add("Bucket, washboard bucket");
        mDisposal.add("Appliance retailers and local scrap metal recyclers will take this item off your hands. Your state's energy office, water conservation and local utility programs may also take your washer and place it into a washer recycling program.");

        mImageUrls.add(R.drawable.ic_watch_button_battery);
        mNames.add("Watch/Button Silver Oxide Batteries");
        mAlternative.add("not available");
        mDisposal.add("Many jewelry stores will recycle these batteries when you bring your watch in to have the batter replaced. If not, please bring to a household hazardous waste (HHW) collection in you area. ");

        mImageUrls.add(R.drawable.ic_wood_fireplace_ash);
        mNames.add("Wood/Fireplace Ash");
        mAlternative.add("not available");
        mDisposal.add("There are uses for wood ash and ash from the fireplace assuming you didn't use burn treated or painted wood. It can be used in your compost pile (very small amount), as an insect repellent (sprinkle small amounts around the perimeter of your garden to deter slugs and snails), or applied to your soil if you need to raise the pH. Treated or painted/stained wood should not be burned, as it emits toxins into the air and results in contaminated ash.");

        mImageUrls.add(R.drawable.ic_zinc);
        mNames.add("Zinc-Air Batteries");
        mAlternative.add("not available");
        mDisposal.add("Bring the batteries to a household hazardous waste (HHW) collection in your area.");

        mImageUrls.add(R.drawable.ic_ziploc_bag);
        mNames.add("Ziploc/Sandwich Bags");
        mAlternative.add("Storage containers, Reusable storage bags, Wash and reuse bags");
        mDisposal.add("Rinse and allow the bag to dry completely, Bring to a film plastic recycling center.");

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