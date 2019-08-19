package com.dogssoundsanddetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final int ITEMS_PER_AD = 4;

    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544~3347511713";

    RecyclerView recyclerView;
    private List<Object> dog_names_id = new ArrayList<>();

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter1 adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_id);
//        layoutManager = new GridLayoutManager(this,2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter1 = new RecyclerAdapter1(MainActivity.this, dog_names_id);
        recyclerView.setAdapter(adapter1);



        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        addBannerAds();
        loadBannerAd();

        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));
        dog_names_id.add(new Models_Dog((R.drawable.akita_puppy_1), "Akita Puppy", (R.string.atika_details_1), (R.raw.akita_puppy_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.boxer_dog_2), "Boxer Intense", (R.string.boxer_dog_details_2), (R.raw.boxer_intense_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.cocker_spaniel_3), "Cocker Spaniel", (R.string.cocker_spaniel_details_3), (R.raw.cocker_spaniel_bark)));
        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));
        dog_names_id.add(new Models_Dog((R.drawable.doberman_4), "Doberman", (R.string.doberman_dog_details_4), (R.raw.cocker_spaniel_bark)));
        dog_names_id.add(new Models_Dog((R.drawable.german_shepherd_5), "German Shepherd", (R.string.german_shepher_details_5), (R.raw.german_shepherd_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.labrador_dog_6), "Labrador", (R.string.labrador_detalis_6), (R.raw.lab_bark)));
        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));
        dog_names_id.add(new Models_Dog((R.drawable.pomeranian_dog_7), "Pomeranian ", (R.string.pomeranian_details_7), (R.raw.pomeranian_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.sheepdog_8), "Sheep Dog", (R.string.sheep_dog_details_8), (R.raw.sheep_dog_barking_outdoors)));
        dog_names_id.add(new Models_Dog((R.drawable.siberian_husky_9), "Siberian Husky", (R.string.siberian_husky_details_9), (R.raw.siberian_husky_barking)));
        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));
        dog_names_id.add(new Models_Dog((R.drawable.pointer_dog_10), "Pointer Dog", (R.string.pointer_dog_10), (R.raw.pointer_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.bulldog_11), "BullDog", (R.string.bulldog_details_11), (R.raw.bulldog_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.pug_dog_12), "Pug Dog", (R.string.pub_dog_details_12), (R.raw.pug_dog_barking)));
        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));
        dog_names_id.add(new Models_Dog((R.drawable.american_pitbull_13), "American Pit bull", (R.string.american_pitbull_details_13), (R.raw.pitbull_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.rottweiler_dog_14), "Rottweiler", (R.string.rottweiler_details_14), (R.raw.rottweiler_barking)));
        dog_names_id.add(new Models_Dog((R.drawable.chihuahua_15), "Chihuahua Dog", (R.string.chihuahua_dog_details_15), (R.raw.chih_barking)));
        dog_names_id.add(new Models_Dog(-1, "ad", -1, -1));


    }


    private void addBannerAds() {
        // Loop through the items array and place a new banner ad in every ith position in
        // the items List.
        for (int i = 0; i < dog_names_id.size(); i += ITEMS_PER_AD) {
            final AdView adView = new AdView(MainActivity.this);
            adView.setAdSize(AdSize.SMART_BANNER);
            adView.setAdUnitId(AD_UNIT_ID);
            dog_names_id.add(i, adView);
        }
    }

    private void loadBannerAd() {

        for (int i = 0; i < dog_names_id.size(); i++) {

            Object item = dog_names_id.get(i);

            if (item instanceof AdView) {

                final AdView adView = (AdView) item;
                adView.loadAd(new AdRequest.Builder().build());
            }


        }
    }

}