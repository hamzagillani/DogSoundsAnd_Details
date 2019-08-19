package com.dogssoundsanddetails;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_VIEW_TYPE = 0;
    private static final int BANNER_AD_VIEW_TYPE = 1;
    private List<Object> recyclerItem;
    private Context context;

    public RecyclerAdapter1(Context context, List<Object> recyclerItem) {
        this.context = context;
        this.recyclerItem = recyclerItem;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        switch (viewType) {

            case ITEM_VIEW_TYPE:

                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,
                        viewGroup, false);
                return new ImageViewHolder(view);

            case BANNER_AD_VIEW_TYPE:
            default:
                View bannerAdViewv = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addmo,
                        viewGroup, false);
                return new BannerAdViewHolder(bannerAdViewv);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {

            case ITEM_VIEW_TYPE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) viewholder;
                final Models_Dog models_dog = (Models_Dog) recyclerItem.get(position);
                if (models_dog.getDog_photo_Id() != -1) {
                    imageViewHolder.dog_album.setImageResource(models_dog.getDog_photo_Id());

                    imageViewHolder.dog_names.setText(models_dog.getDog_names_id());
                } else {

                }


                imageViewHolder.dog_album.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        //code for new intent
                        Intent intent = new Intent(context, Detalis_Dog.class);

                        intent.putExtra("image_url", models_dog.getDog_photo_Id());
                        intent.putExtra("image_names", models_dog.getDog_names_id());
                        intent.putExtra("details", models_dog.getDog_details_id());
                        intent.putExtra("sound", models_dog.getSoundId());

                        context.startActivity(intent);
                    }
                });
                break;
            case BANNER_AD_VIEW_TYPE:

                final BannerAdViewHolder adViewHolder = (BannerAdViewHolder) viewholder;

                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                        .addTestDevice("ca-app-pub-3940256099942544~3347511713")  // Emulator id you will get in the LogCat verbose
                        .build();
                adViewHolder.mAdView.loadAd(adRequest);
                
                adViewHolder.mAdView.setAdListener(new AdListener(){
                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);

                        adViewHolder.mAdView.setVisibility(View.GONE);
                    }
                });
        }
    }

    @Override
    public int getItemCount() {
        return recyclerItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % MainActivity.ITEMS_PER_AD == 0) {
            return BANNER_AD_VIEW_TYPE;
        } else
            return ITEM_VIEW_TYPE;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView dog_album;
        TextView dog_names;


        public ImageViewHolder(View itemView) {
            super(itemView);

            dog_album = itemView.findViewById(R.id.dogs_album_id);
            dog_names = itemView.findViewById(R.id.dogs_title_id);

        }
    }

    public static class BannerAdViewHolder extends RecyclerView.ViewHolder {
        AdView mAdView;

        BannerAdViewHolder(View itemView) {
            super(itemView);
            mAdView = itemView.findViewById(R.id.mAdView);
        }
    }
}

