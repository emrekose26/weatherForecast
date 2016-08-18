package com.emrekose.weatherapp.activities;

import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.model.WeatherResponse;
import com.emrekose.weatherapp.rest.ApiClient;
import com.emrekose.weatherapp.rest.ApiInterface;
import com.emrekose.weatherapp.utils.Constants;
import com.emrekose.weatherapp.utils.Font;
import com.emrekose.weatherapp.utils.SharedPrefUtils;
import com.emrekose.weatherapp.utils.WeatherCalc;
import com.emrekose.weatherapp.utils.WeatherLocation;
import com.emrekose.weatherapp.utils.WeatherUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final int SHOW_CITIES_ACTIVITY = 1;

    private static String currentCityName;

    private TextView cityTexView, countryTextView, degreeTextView, weatherDescriptionTexView,
    timeTextView, dateTextView, maxMinTemperatureTexView, humidityTextView, windTextView;

    private ImageView weatherIconImageView;

    private LocationManager locationManager;
    private WeatherLocation weatherLocation;

    private FloatingActionsMenu floatingActionsMenu;
    private FloatingActionButton fabRefresh, fabGetGpsDatas, fabChangeCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        if(Constants.API_KEY.isEmpty()){
            Toast.makeText(MainActivity.this, "Please obtain your API KEY first from http://api.openweathermap.org/", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);


        Call <WeatherResponse> call = apiService.getCurrentDatas(SharedPrefUtils.getCityName(MainActivity.this),Constants.API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                cityTexView.setText(response.body().getName());
                countryTextView.setText(response.body().getSys().getCountry());
                degreeTextView.setText(WeatherCalc.kelvinToCelcius(response.body().getMainModel().getTemp()));
                weatherDescriptionTexView.setText(response.body().getWeatherList().get(0).getMain());
                humidityTextView.setText(" % " + String.valueOf(response.body().getMainModel().getHumidity()));
                windTextView.setText(String.valueOf(Math.floor(response.body().getWind().getDeg())) + " m/s");
                maxMinTemperatureTexView.setText(WeatherCalc.kelvinToCelcius(response.body().getMainModel().getTempMax()) + " / " + WeatherCalc.kelvinToCelcius(response.body().getMainModel().getTempMin()));

                SimpleDateFormat time = new SimpleDateFormat("HH.mm a / EEE"); // 08.45 PM / Thu
                timeTextView.setText(time.format(new Date()));

                SimpleDateFormat date = new SimpleDateFormat("dd MMM yyyy"); // 06 Ağu 2016
                dateTextView.setText(date.format(new Date()));

                WeatherUtils.setWeatherIcon(weatherIconImageView,response.body().getWeatherList().get(0).getIcon());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString() );
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(!SharedPrefUtils.getCityName(MainActivity.this).isEmpty()){
            this.finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case RESULT_OK :
                currentCityName = data.getStringExtra("cityname");
                break;
            case RESULT_CANCELED :
                Toast.makeText(MainActivity.this, "Lokasyon değiştirilmedi.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initialize(){

        // TextView initializing
        cityTexView = (TextView)findViewById(R.id.cityTextView);
        countryTextView = (TextView)findViewById(R.id.countryTextView);
        degreeTextView = (TextView)findViewById(R.id.degreeTextView);
        weatherDescriptionTexView = (TextView)findViewById(R.id.weatherDescTextView);
        timeTextView = (TextView)findViewById(R.id.timeTextView);
        dateTextView = (TextView)findViewById(R.id.dateTextView);
        maxMinTemperatureTexView = (TextView)findViewById(R.id.maxMinTemperatureTexView);
        humidityTextView = (TextView)findViewById(R.id.humidityTextView);
        windTextView = (TextView)findViewById(R.id.windTextView);

        // ImageView initializing
        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);

        // location config
        /*
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,10,new WeatherLocation(this));
        weatherLocation = new WeatherLocation(this);
        */

        // Float action buttons
        floatingActionsMenu = (FloatingActionsMenu)findViewById(R.id.floatingActionsMenu);
        fabRefresh = (FloatingActionButton)findViewById(R.id.fabRefresh);
        fabGetGpsDatas = (FloatingActionButton)findViewById(R.id.fabGetGpsDatas);
        fabChangeCity = (FloatingActionButton)findViewById(R.id.fabChangeCity);

        fabChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCityName = SharedPrefUtils.getCityName(MainActivity.this);
                Intent intent = new Intent(MainActivity.this,CitiesActivity.class);
                intent.putExtra("changeLocation",true);
                startActivityForResult(intent,SHOW_CITIES_ACTIVITY);
                finish();
            }
        });

        // all of textView is font changing
        Font.change(MainActivity.this,cityTexView, Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(MainActivity.this,countryTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,weatherDescriptionTexView,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(MainActivity.this,degreeTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,timeTextView,Font.OPEN_SANS_COND_LIGHT_ITALIC_PATH);
        Font.change(MainActivity.this,dateTextView,Font.OPEN_SANS_COND_LIGHT_ITALIC_PATH);
        Font.change(MainActivity.this,maxMinTemperatureTexView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,humidityTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,windTextView,Font.OPEN_SANS_COND_LIGHT_PATH);

    }
}
