package com.emrekose.weatherapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.emrekose.weatherapp.fragments.WeatherOneFragment;
import com.emrekose.weatherapp.fragments.WeatherThreeFragment;
import com.emrekose.weatherapp.fragments.WeatherTwoFragment;

/**
 * Created by emrekose on 4.08.2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    public static int total_page = 3;

    public ViewPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new Fragment();
        switch (position){
            case 0 :
                fragment = new WeatherOneFragment();
                break;
            case 1 :
                fragment = new WeatherTwoFragment();
                break;
            case 2 :
                fragment = new WeatherThreeFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return total_page;
    }
}
