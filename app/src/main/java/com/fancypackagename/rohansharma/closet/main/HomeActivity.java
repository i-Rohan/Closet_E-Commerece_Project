package com.fancypackagename.rohansharma.closet.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import com.fancypackagename.rohansharma.closet.R;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity {

    CarouselView customCarouselView;

    String[] sampleNetworkImageURLs = {
            "http://10.7.2.4/closet/public/images/carousel-01.png",
            "http://10.7.2.4/closet/public/images/carousel-02.png",
            "http://10.7.2.4/closet/public/images/carousel-03.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        setTitle("Home");
        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselView.setPageCount(3);

        customCarouselView.setSlideInterval(4000);
        // set ViewListener for custom view
        customCarouselView.setImageListener(imageListener);


        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }

    // To set simple images
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            Picasso.with(getApplicationContext()).load(sampleNetworkImageURLs[position]).into(imageView);

            //imageView.setImageResource(sampleImages[position]);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }


}