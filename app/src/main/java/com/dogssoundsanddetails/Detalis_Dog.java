package com.dogssoundsanddetails;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Detalis_Dog extends AppCompatActivity  {

    TextView dog_name;
    TextView details_of_dog;
    ImageView imageView;
    Button play;
    private AdView mAdView1;

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detalis__dog);
        //dog_name=findViewById(R.id.dogs_name_id);
        imageView=findViewById(R.id.dogs_photo_id);
        details_of_dog=findViewById(R.id.dogs_details_id);
        play=findViewById(R.id.sound_id);
        mAdView1=findViewById(R.id.adView_id);


        MobileAds.initialize(Detalis_Dog.this,"ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);





      // dog_name.setText(getIntent().getStringExtra("image_names"));
        details_of_dog.setText(getIntent().getIntExtra("details",00));
        imageView.setImageResource(getIntent().getIntExtra("image_url",00));

         final int mp3 =getIntent().getIntExtra("sound",00);
        mMediaPlayer=MediaPlayer.create(Detalis_Dog.this,mp3);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer.isPlaying()) {

                    play.setText("Start Barking");
                    mMediaPlayer.pause();

                }else {


                        mMediaPlayer.start();
                        play.setText("Stop Barking");



                }




            }
        });


        ActionBar actionBar=getSupportActionBar();

        actionBar.setTitle((getIntent().getStringExtra("image_names")));


   /*     setSupportActionBar((getIntent().getStringExtra("image_names")));
        ActionBar ab = getActionBar();
        ab.setTitle((getIntent().getStringExtra("image_names")));

*/


    }

    @Override
    protected void onStop() {
        mMediaPlayer.stop();
        super.onStop();
    }

    public void rate_app(View view) {

        try {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));

        } catch (Exception e) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    public void share_App(View view) {

        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "DOG SOUND WITH DETAILS");

            String sAux = "\nDOG SOUNDS WITH DETAILS\n\n";

            sAux = sAux + "https://play.google.com/store/apps/details?id=" + getPackageName() + " \n\n";

            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));

        } catch (Exception e) {
            //e.toString();
        }

    }

    /* private void getIncomingIntent() {
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_names")) {

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_names");
            //Parcelable[] imageUrl=getIntent().getParcelableArrayExtra("image_url");




        }}*/
}
