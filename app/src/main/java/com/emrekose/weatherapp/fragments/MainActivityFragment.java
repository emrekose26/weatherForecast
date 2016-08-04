package com.emrekose.weatherapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.adapters.ViewPagerAdapter;

/**
 * Created by emrekose on 4.08.2016.
 */

public class MainActivityFragment extends Fragment {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private ImageView indicator1, indicator2, indicator3;

    public MainActivityFragment() {}

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();
        setTab();
        onCircleButtonClick();
    }

    private void onCircleButtonClick() {
        indicator1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indicator1.setImageResource(R.drawable.fill_circle);
                mViewPager.setCurrentItem(0);
            }
        });

        indicator2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indicator2.setImageResource(R.drawable.fill_circle);
                mViewPager.setCurrentItem(1);
            }
        });

        indicator3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indicator3.setImageResource(R.drawable.fill_circle);
                mViewPager.setCurrentItem(2);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void setTab() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator1.setImageResource(R.drawable.holo_circle);
                indicator2.setImageResource(R.drawable.holo_circle);
                indicator3.setImageResource(R.drawable.holo_circle);
                indicatorAction(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void indicatorAction(int position) {
        switch (position){
            case 0:
                indicator1.setImageResource(R.drawable.fill_circle);
                break;
            case 1:
                indicator2.setImageResource(R.drawable.fill_circle);
                break;
            case 2:
                indicator3.setImageResource(R.drawable.fill_circle);
                break;
        }
    }

    private void setupView() {
        mViewPager = (ViewPager)getView().findViewById(R.id.viewPager);
        mAdapter = new ViewPagerAdapter(getActivity(),getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        initButton();
    }

    private void initButton() {
        indicator1 = (ImageView)getView().findViewById(R.id.indicator1);
        indicator2 = (ImageView)getView().findViewById(R.id.indicator2);
        indicator3 = (ImageView)getView().findViewById(R.id.indicator3);

        indicator1.setImageResource(R.drawable.fill_circle);
    }


}
