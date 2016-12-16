package com.fancypackagename.rohansharma.closet.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;
import com.fancypackagename.rohansharma.closet.main.gridview.GridViewItemObject;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    public static Context context;
    CarouselView customCarouselView;
    String[] imageNames = {
            "carousel-01.png",
            "carousel-02.png",
            "carousel-03.png"
    };
    ProgressBar progressBar;
    List<GridViewItemObject> allProducts = new ArrayList<>();

    // To set simple images
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(getApplicationContext()).load(AppCommons.PUBLIC_URL + "images/" + imageNames[position]).into(imageView);
            //imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);

        context = this;

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        customCarouselView.setPageCount(3);

        customCarouselView.setSlideInterval(4000);
        // set ViewListener for custom view
        customCarouselView.setImageListener(imageListener);

        getProductsList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    void getProductsList() {
        progressBar.setVisibility(View.VISIBLE);
        String url = AppCommons.API_URL + "get_products_list";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Home", response);

                        progressBar.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Home", "error");

                        progressBar.setVisibility(View.GONE);

                        Toast.makeText(HomeActivity.this, "Connection problem! :(",
                                Toast.LENGTH_SHORT).show();
                    }
                }) {
        };

        RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
        requestQueue.add(stringRequest);
    }
}