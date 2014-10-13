package com.doubtech.openweathermapservice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.doubtech.openweathermapservice.data.Main;
import com.doubtech.openweathermapservice.data.Forecast;
import com.google.gson.Gson;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class TestActivity extends Activity {

    private TextView mTextView;
    private WeatherForecastBuilder.WeatherForecastService mForecastService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTextView = (TextView) findViewById(R.id.text);

        mForecastService = WeatherForecastBuilder.build();
        mForecastService.getForecast(38.8808f, -94.8031f, Main.UNITS_IMPERIAL, new Callback<Forecast>() {
            @Override
            public void success(Forecast forecast, Response response) {
                Log.d("AARON", "Url: " + response.getUrl());
                Log.d("AARON", response.getBody().toString());
                mTextView.setText(response.getUrl() + "\n" + new Gson().toJson(forecast, Forecast.class));
            }

            @Override
            public void failure(RetrofitError error) {
                StringBuilder e = new StringBuilder(error.getMessage());
                e.append("\n");
                for (StackTraceElement st : error.getStackTrace()) {
                    e.append(st.toString());
                    e.append("\n");
                }
                mTextView.setText(e.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
