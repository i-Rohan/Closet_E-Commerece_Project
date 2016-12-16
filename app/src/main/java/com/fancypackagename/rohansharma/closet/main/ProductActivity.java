package com.fancypackagename.rohansharma.closet.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fancypackagename.rohansharma.closet.R;

public class ProductActivity extends AppCompatActivity {

    String productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent i = getIntent();
        if (i != null)
            productId = i.getStringExtra("productId");


    }
}
