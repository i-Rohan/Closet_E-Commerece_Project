package com.fancypackagename.rohansharma.closet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        YoYo.with(Techniques.FadeIn)
                .duration(500)
                .interpolate(new AccelerateDecelerateInterpolator())
                .playOn(findViewById(R.id.imageView));
    }
}