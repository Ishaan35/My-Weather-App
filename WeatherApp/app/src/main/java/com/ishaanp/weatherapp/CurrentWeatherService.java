package com.ishaanp.weatherapp;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentWeatherService {

    private static final String TAG = CurrentWeatherService.class.getSimpleName();


    private static final String URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String CURRENTWEATHERTAG = "CURRENT_WEATHER";
    private static final String API_KEY = "bb00213d944109bd91bf93b6f10fb3d2";

    private RequestQueue queue;

    public CurrentWeatherService(@NonNull final Activity activity){
        queue = Volley.newRequestQueue(activity.getApplicationContext());
    }

    public interface CurrentWeatherCallback{
        void onCurrentWeather(@NonNull final CurrentWeather currentWeather);

        void onError(@Nullable Exception e);
    }

    public void getWeatherCurrent(final String locationName, final CurrentWeatherCallback callback)
    {


        final StringBuilder url = new StringBuilder(URL);
        url.append("?q=").append(locationName).append("&appid=").append(API_KEY);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            final JSONObject currentWeatherJSONObject = new JSONObject(response); //- entire response
                            final JSONArray weather = currentWeatherJSONObject.getJSONArray("weather"); //array in response called - "weather"
                            final JSONObject weatherCondition = weather.getJSONObject(0); //the only index in the weather array. info enclosed in {}
                            final String LocationName = currentWeatherJSONObject.getString("name"); //lets describe it as a "global" property in the json
                            final String conditionID = weatherCondition.getString("icon");// info tagged inside the weathercondition object, which is inside the weather array
                            final String conditionName = weatherCondition.getString("main"); //same location as conditionID
                            final String description = weatherCondition.getString("description");
                            final double tempKelvin = currentWeatherJSONObject.getJSONObject("main").getDouble("temp"); //temperature is in the 'main' object tagged as 'temp'

                            final double feels_Like = currentWeatherJSONObject.getJSONObject("main").getDouble("feels_like");
                            final double windSpeed = Math.round(currentWeatherJSONObject.getJSONObject("wind").getDouble("speed") * 3.6);
                            final double humidity = currentWeatherJSONObject.getJSONObject("main").getDouble("humidity");
                            final int visibility = (int)Math.round(currentWeatherJSONObject.getDouble("visibility")/1000);
                            final double pressure = currentWeatherJSONObject.getJSONObject("main").getDouble("pressure")/10;
                            final CurrentWeather currentWeather = new CurrentWeather(LocationName, conditionID, conditionName,description, tempKelvin,feels_Like, windSpeed, humidity, visibility, pressure);
                            callback.onCurrentWeather(currentWeather);

                        }catch(JSONException e){
                            callback.onError(e);
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                callback.onError(error);
            }
        });
        stringRequest.setTag(CURRENTWEATHERTAG);
        queue.add(stringRequest);
    }

    //find my location on start
    public void findWeatherCurrentAuto(double latitude, double longitude, final CurrentWeatherCallback callback) {

        final StringBuilder url = new StringBuilder(URL);
        url.append("?lat=").append(latitude).append("&lon=").append(longitude).append("&appid=").append(API_KEY);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            final JSONObject currentWeatherJSONObject = new JSONObject(response); //- entire response
                            final JSONArray weather = currentWeatherJSONObject.getJSONArray("weather"); //array in response called - "weather"
                            final JSONObject weatherCondition = weather.getJSONObject(0); //the only index in the weather array. info enclosed in {}
                            final String LocationName = currentWeatherJSONObject.getString("name"); //lets describe it as a "global" property in the json
                            final String conditionID = weatherCondition.getString("icon");// info tagged inside the weathercondition object, which is inside the weather array
                            final String conditionName = weatherCondition.getString("main"); //same location as conditionID
                            final String description = weatherCondition.getString("description");
                            final double tempKelvin = currentWeatherJSONObject.getJSONObject("main").getDouble("temp"); //temperature is in the 'main' object tagged as 'temp'

                            final double feels_Like = currentWeatherJSONObject.getJSONObject("main").getDouble("feels_like");
                            final double windSpeed = Math.round(currentWeatherJSONObject.getJSONObject("wind").getDouble("speed") * 3.6);
                            final double humidity = currentWeatherJSONObject.getJSONObject("main").getDouble("humidity");
                            final int visibility = (int)Math.round(currentWeatherJSONObject.getDouble("visibility")/1000);
                            final double pressure = currentWeatherJSONObject.getJSONObject("main").getDouble("pressure")/10;
                            final CurrentWeather currentWeather = new CurrentWeather(LocationName, conditionID, conditionName,description, tempKelvin,feels_Like, windSpeed, humidity, visibility, pressure);
                            callback.onCurrentWeather(currentWeather);

                        }catch(JSONException e){
                            callback.onError(e);
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                callback.onError(error);
            }
        });
        stringRequest.setTag(CURRENTWEATHERTAG);
        queue.add(stringRequest);

    }

    public void cancel()
    {
        queue.cancelAll(CURRENTWEATHERTAG);
    }


}
