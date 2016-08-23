package com.emrekose.weatherapp.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.utils.SharedPrefUtils;

public class CitiesActivity extends AppCompatActivity {

    private String cityName;

    private Bundle extras;

    private ListView listView;
    private String[] citiesList;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;

    private SearchView searchView;
    private MenuItem searchMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        Intent intent = getIntent();
        extras = intent.getExtras();

        if(extras != null){
            initialize();

            Intent returnIntent = new Intent();
            returnIntent.putExtra("cityName",cityName);
            setResult(RESULT_OK,returnIntent);
        }else{
            // check city name to first begin
            if(SharedPrefUtils.getCityName(CitiesActivity.this).isEmpty()){
                initialize();
            }else {
                startActivity(new Intent(CitiesActivity.this,MainActivity.class));
                finish();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView)searchMenuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(extras != null){
            startActivity(new Intent(CitiesActivity.this,MainActivity.class));
            finish();
        }
    }

    private void initialize(){
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
                cityName = textView.getText().toString();
                SharedPrefUtils.setCityName(CitiesActivity.this,cityName);
                startActivity(new Intent(CitiesActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
