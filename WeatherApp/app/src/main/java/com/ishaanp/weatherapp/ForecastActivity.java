package com.ishaanp.weatherapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ForecastActivity extends AppCompatActivity {


    String json_string;

    JSONObject jsonObject;
    JSONArray jsonArray;

    ForecastAdapter mForecastAdapter;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        mListView = (ListView) findViewById(R.id.forecast_list);
        mForecastAdapter = new ForecastAdapter(this, R.layout.forecast_row);
        mListView.setAdapter(mForecastAdapter);
        json_string = getIntent().getExtras().getString("json_data");

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("list");

            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject currentWeatherData = jsonArray.getJSONObject(i);
                int time_zone_shift = jsonObject.getJSONObject("city").getInt("timezone");
                String date = convertDate(currentWeatherData.getLong("dt"), time_zone_shift);
                double temperature = KelvinToCelcius(currentWeatherData.getJSONObject("main").getDouble("temp"));
                double feels = KelvinToCelcius(currentWeatherData.getJSONObject("main").getDouble("feels_like"));
                String condit = currentWeatherData.getJSONArray("weather").getJSONObject(0).getString("main");
                String conditDescription = currentWeatherData.getJSONArray("weather").getJSONObject(0).getString("description");
                double windVal = currentWeatherData.getJSONObject("wind").getDouble("speed") * 3.6;
                double humidityVal = currentWeatherData.getJSONObject("main").getDouble("humidity");
                double pressureVal = currentWeatherData.getJSONObject("main").getDouble("pressure")/10;
                String forecastICON = currentWeatherData.getJSONArray("weather").getJSONObject(0).getString("icon");

                ForecastModel forecastModel = new ForecastModel(date, temperature, feels, condit, conditDescription, windVal, humidityVal, pressureVal, forecastICON);
                mForecastAdapter.add(forecastModel);
            }




        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }


    }

    //utility timestamp to date
    public String convertDate(long unixTimeStamp, int time_offset) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d, h:mm aaa");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));


        return (dateFormat.format(new Date(unixTimeStamp * 1000L + time_offset * 1000L)));
    }

    public int KelvinToCelcius(double temp){
        double celcius = temp - 273.15;
        return (int) Math.round(celcius);
    }







}
