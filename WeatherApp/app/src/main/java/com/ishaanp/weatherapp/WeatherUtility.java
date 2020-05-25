package com.ishaanp.weatherapp;

public class WeatherUtility
{
    public static int weatherIcon(String weather_Condition_ID)
    {
        if(weather_Condition_ID.equals("01d")){ //clear sun
            return R.drawable.sunnyclear01d;
        }
        else if(weather_Condition_ID.equals("01n")){ //clear night
            return R.drawable.clearnight01n;
        }
        else if(weather_Condition_ID.equals("02d")){ //day cloudy few
            return R.drawable.cloudysunny02d;
        }
        else if(weather_Condition_ID.equals("02n")){ //night clouds few
            return R.drawable.cloudynight02n;
        }
        else if(weather_Condition_ID.equals("03d") || weather_Condition_ID.equals("03n") || weather_Condition_ID.equals("04d") || weather_Condition_ID.equals("04n")){ //cloudy
            return R.drawable.cloudy03d04d03n04n;
        }
        else if(weather_Condition_ID.equals("09d") || weather_Condition_ID.equals("09n")){ //raining
            return R.drawable.raining09d09n;
        }
        else if(weather_Condition_ID.equals("10d")){ //dayshowers
            return R.drawable.sunrain10d;
        }
        else if(weather_Condition_ID.equals("10n")){ //nightshowers
            return R.drawable.nightrain10n;
        }
        else if(weather_Condition_ID.equals("11d") || weather_Condition_ID.equals("11n")){ //thunderstorm
            return R.drawable.thunderstorm11d11n;
        }
        else if(weather_Condition_ID.equals("13d") || weather_Condition_ID.equals("13n")){ //snow
            return R.drawable.snow13d13n;
        }
        else if(weather_Condition_ID.equals("50d") || weather_Condition_ID.equals("50n")){ //mist, smoke, fog
            return R.drawable.foggy50d50n;
        }
        else{
            return R.drawable.sunnyclear01d;
        }




    }

}
