package com.emrekose.weatherapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.utils.SharedPrefUtils;

public class CitiesActivity extends AppCompatActivity {

    private ListView listView;
    private String[] citiesList;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        if(SharedPrefUtils.getCityName(CitiesActivity.this).isEmpty()){

            toolbar = (Toolbar)findViewById(R.id.citiesToolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setTitle("İl Seçiniz");

            listView = (ListView)findViewById(R.id.citiesListView);

            citiesList = getResources().getStringArray(R.array.cities);

            adapter = new ArrayAdapter<String>(CitiesActivity.this,android.R.layout.simple_list_item_1,citiesList);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView textView = (TextView)view;
                    SharedPrefUtils.setCityName(CitiesActivity.this,textView.getText().toString());
                    startActivity(new Intent(CitiesActivity.this,MainActivity.class));
                    finish();
                }
            });
        }else {
            startActivity(new Intent(CitiesActivity.this,MainActivity.class));
        }


    }
}
