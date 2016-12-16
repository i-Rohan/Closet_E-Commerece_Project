package com.fancypackagename.rohansharma.closet.main;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.fancypackagename.rohansharma.closet.R;

/**
 * Created by RohansyN on 16-12-2016.
 */

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    public int getCount() {

        return 3;
    }

    public Object instantiateItem(View collection, int position) {

        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int resId = 0;
        switch (position) {
            case 0:
                resId = showadmin();

                break;
            case 1:
                resId = showuser();
                break;
            case 2:
                resId = showme();
                break;



        }

        View view = inflater.inflate(resId, null);
        ((ViewPager) collection).addView(view, 0);
        return view;


    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public int showadmin() {
        int r;
        r = R.layout.sponsorproduct1;
        return r;
    }

    public int showuser() {
        int r;
        r = R.layout.sponsorproduct2;
        return r;
    }
    public int showme(){
        int r;
        r=R.layout.sponsorproduct3;
        return r;
    }

//    public int showmelast() {
//
//        int r;
//        r = R.layout.about_d;
//        return r;
//    }
    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

}
