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


public class WeatherOneFragment extends Fragment {

    private TextView tempFragmentTextView1, tempFragmentTextView2 ,dayOneTextView, dayTwoTextView;
    private ImageView fragment1ImageView, fragment2ImageView;

    public WeatherOneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_weather_one, container, false);
        tempFragmentTextView1 = (TextView)view.findViewById(R.id.tempFragmentTextView1);
        tempFragmentTextView2 = (TextView)view.findViewById(R.id.tempFragmentTextView2);

        Font.change(getContext(),tempFragmentTextView1,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(getContext(),tempFragmentTextView2,Font.OPEN_SANS_COND_BOLD_PATH);

        dayOneTextView = (TextView)view.findViewById(R.id.dayOneTextView);
        dayTwoTextView = (TextView)view.findViewById(R.id.dayTwoTextView);

        Font.change(getContext(),dayOneTextView,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(getContext(),dayTwoTextView,Font.OPEN_SANS_COND_BOLD_PATH);


        fragment1ImageView = (ImageView)view.findViewById(R.id.fragment1ImageView);
        fragment2ImageView = (ImageView)view.findViewById(R.id.fragment2ImageView);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call <ForecastResponse> forecastResponseCall = apiService.getFiveDaysDatas(SharedPrefUtils.getCityName(getContext()), Constants.API_KEY);
        forecastResponseCall.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                tempFragmentTextView1.setText(WeatherCalc.kelvinToCelcius(response.body().getLists().get(8).getForecastMain().getTemp()));
                dayOneTextView.setText(DateUtils.getDayName(response.body().getLists().get(8).getDtTxt()));

                tempFragmentTextView2.setText(WeatherCalc.kelvinToCelcius(response.body().getLists().get(16).getForecastMain().getTemp()));
                dayTwoTextView.setText(DateUtils.getDayName(response.body().getLists().get(16).getDtTxt()));

                WeatherUtils.setFragmentWeatherIcon(fragment1ImageView,response.body().getLists().get(8).getForecastWeatherList().get(0).getIcon());
                WeatherUtils.setFragmentWeatherIcon(fragment2ImageView,response.body().getLists().get(16).getForecastWeatherList().get(0).getIcon());
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Log.e("FRAGMENT_ERROR", "onFailure: " + t.toString() );
            }
        });

        return view;
    }




}
