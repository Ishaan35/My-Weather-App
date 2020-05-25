package com.ishaanp.weatherapp;

public class ForecastModel {

    private String date;
    private double temperature;
    private double feels_like;
    private String condition;
    private String conditionDescription;
    private double wind;
    private double humidity;
    private double pressure;
    private String ICON;

    public ForecastModel(String date, double temperature, double feels_like, String condition, String conditionDescription, double wind, double humidity, double pressure, String ICON) {
        this.date = date;
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.condition = condition;
        this.conditionDescription = conditionDescription;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
        this.ICON = ICON;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getICON() {
        return ICON;
    }

    public void setICON(String ICON) {
        this.ICON = ICON;
    }
}
