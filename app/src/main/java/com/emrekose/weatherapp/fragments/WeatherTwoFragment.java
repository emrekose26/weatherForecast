package com.emrekose.weatherapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.model.ForecastResponse;
import com.emrekose.weatherapp.rest.ApiClient;
import com.emrekose.weatherapp.rest.ApiInterface;
import com.emrekose.weatherapp.utils.Constants;
import com.emrekose.weatherapp.utils.DateUtils;
import com.emrekose.weatherapp.utils.Font;
import com.emrekose.weatherapp.utils.SharedPrefUtils;
import com.emrekose.weatherapp.utils.WeatherCalc;
import com.emrekose.weatherapp.utils.WeatherUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherTwoFragment extends Fragment {

    private TextView tempFragmentTextView3, tempFragmentTextView4 ,dayThreeTextView, dayFourTextView;
    private ImageView fragment3ImageView, fragment4ImageView;


    public WeatherTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_two, container, false);

        tempFragmentTextView3 = (TextView)view.findViewById(R.id.tempFragmentTextView3);
        tempFragmentTextView4 = (TextView)view.findViewById(R.id.tempFragmentTextView4);

        Font.change(getContext(),tempFragmentTextView3,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(getContext(),tempFragmentTextView4,Font.OPEN_SANS_COND_BOLD_PATH);

        dayThreeTextView = (TextView)view.findViewById(R.id.dayThreeTextView);
        dayFourTextView = (TextView)view.findViewById(R.id.dayFourTextView);

        Font.change(getContext(),dayThreeTextView,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(getContext(),dayFourTextView,Font.OPEN_SANS_COND_BOLD_PATH);

        fragment3ImageView = (ImageView)view.findViewById(R.id.fragment3ImageView);
        fragment4ImageView = (ImageView)view.findViewById(R.id.fragment4ImageView);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ForecastResponse> forecastResponseCall = apiService.getFiveDaysDatas(SharedPrefUtils.getCityName(getContext()), Constants.API_KEY);
        forecastResponseCall.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                tempFragmentTextView3.setText(WeatherCalc.kelvinToCelcius(response.body().getLists().get(24).getForecastMain().getTemp()));
                dayThreeTextView.setText(DateUtils.getDayName(response.body().getLists().get(24).getDtTxt()));

                tempFragmentTextView4.setText(WeatherCalc.kelvinToCelcius(response.body().getLists().get(32).getForecastMain().getTemp()));
                dayFourTextView.setText(DateUtils.getDayName(response.body().getLists().get(32).getDtTxt()));

                WeatherUtils.setFragmentWeatherIcon(fragment3ImageView,response.body().getLists().get(24).getForecastWeatherList().get(0).getIcon());
                WeatherUtils.setFragmentWeatherIcon(fragment4ImageView,response.body().getLists().get(32).getForecastWeatherList().get(0).getIcon());
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Log.e("FRAGMENT_ERROR", "onFailure: " + t.toString() );
            }
        });

        return view;
    }

}
