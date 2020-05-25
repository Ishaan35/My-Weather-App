package com.ishaanp.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends ArrayAdapter {

    List mList = new ArrayList();

    public ForecastAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add( ForecastModel object) {
        super.add(object);
        mList.add(object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        ForecastHolder forecastHolder;

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.forecast_row, parent, false);
            forecastHolder = new ForecastHolder();
            forecastHolder.date_txt = row.findViewById(R.id.date_time);
            forecastHolder.temperature_txt = row.findViewById(R.id.temperature);
            forecastHolder.feelslike_txt = row.findViewById(R.id.feelsLike);
            forecastHolder.condit_txt = row.findViewById(R.id.Condition);
            forecastHolder.conditDescription_txt = row.findViewById(R.id.ConditionDescription);
            forecastHolder.wind_txt = row.findViewById(R.id.Wind);
            forecastHolder.humid_txt = row.findViewById(R.id.Humidity);
            forecastHolder.pressure_txt = row.findViewById(R.id.Pressure);
            forecastHolder.icon_img = row.findViewById(R.id.weatherIcon);
            row.setTag(forecastHolder);
        }else{
            forecastHolder = (ForecastHolder) row.getTag();
        }

        ForecastModel forecastModel = (ForecastModel) this.getItem(position);
        forecastHolder.date_txt.setText(forecastModel.getDate());
        forecastHolder.temperature_txt.setText((int) Math.round(forecastModel.getTemperature()) + "");
        forecastHolder.feelslike_txt.setText((int) Math.round(forecastModel.getFeels_like()) + "");
          forecastHolder.condit_txt.setText(forecastModel.getCondition());
          forecastHolder.conditDescription_txt.setText(forecastModel.getConditionDescription());
        forecastHolder.wind_txt.setText("Wind: "+Math.round((forecastModel.getWind()) * 10.0) / 10.0 + " km/h");       //rounding precision 1 digit
        forecastHolder.humid_txt.setText("Humidity: " + Math.round((forecastModel.getHumidity()) * 10.0) / 10.0+"%");
        forecastHolder.pressure_txt.setText("Pressure: " + Math.round((forecastModel.getPressure()) * 10.0) / 10.0 +" kPa");
        forecastHolder.icon_img.setImageResource(WeatherUtility.weatherIcon(forecastModel.getICON()));
        return row;
    }

    static class ForecastHolder{
        TextView date_txt;
        TextView temperature_txt;
        TextView feelslike_txt;
        TextView condit_txt;
        TextView conditDescription_txt;
        TextView wind_txt;
        TextView humid_txt;
        TextView pressure_txt;
        ImageView icon_img;
    }
}
