package com.doubtech.openweathermapservice;

import com.doubtech.openweathermapservice.data.Forecast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Aaron Jackson on 10/10/14.
 *
 * http://api.openweathermap.org/data/2.5/weather?lat=38.880&lon=-94.8031&units=imperial
 */
public class WeatherForecastBuilder {
    public static interface WeatherForecastService {
        @GET("/data/2.5/weather")
        Forecast getForecast(@Query("lat") float lat, @Query("lon") float lon, @Query("units") String units);
        @GET("/data/2.5/weather")
        Forecast getForecast(@Query("q") String city, @Query("units") String units);

        @GET("/data/2.5/weather")
        void getForecast(@Query("lat") float lat, @Query("lon") float lon, @Query("units") String units, Callback<Forecast> cb);
        @GET("/data/2.5/weather")
        void getForecast(@Query("q") String city, @Query("units") String units, Callback<Forecast> cb);
    }

    public static WeatherForecastService build() {
        Gson gson = new GsonBuilder()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org")
                .setConverter(new GsonConverter(gson))
                .build();

        return restAdapter.create(WeatherForecastService.class);
    }
}
