package com.ishaanp.weatherapp;

public class CurrentWeather
{
    /*
     private TextView Temperature, FeelsLikeTemperature, Location, WeatherCondition, Wind, Humidity, Visibility, Pressure;
    private ImageView weatherConditionIcon;
    private EditText LocationSearch;
    private FloatingActionButton fab;
     */
    final String location;
    final String conditionID;
    final String WeatherCondition;
    final String Description;
    final double TempKelvin, FeelsLike;
    final double WindSpeed, Humidity, Visibility, Pressure;



    private static final String TAG = "TEMPERATURE";

    public CurrentWeather(String location, String conditionID, String weatherCondition, String description, double tempKelvin,double FeelsLike, double windSpeed, double humidity, double visibility, double pressure) {
        this.location = location;
        this.conditionID = conditionID;
        WeatherCondition = weatherCondition;
        Description = description;
        TempKelvin = tempKelvin;
        this.FeelsLike = FeelsLike;
        WindSpeed = windSpeed;
        Humidity = humidity;
        Visibility = visibility;
        Pressure = pressure;
    }
    public int KelvinToCelcius() {
        return (int) Math.round(TempKelvin - 273.15);
    }
    public int FeelsLikeToCelcius()
    {
        return (int) Math.round(FeelsLike - 273.15);
    }

}
