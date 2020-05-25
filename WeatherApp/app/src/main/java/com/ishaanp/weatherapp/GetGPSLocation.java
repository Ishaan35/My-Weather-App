package com.ishaanp.weatherapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class GetGPSLocation implements LocationListener {

    Context context;

    public GetGPSLocation(Context c) {
        context = c;
    }

    public Location getLocation() {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSenabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(context, "Permission Not Granted. Grant Permission and refresh the weather.", Toast.LENGTH_LONG).show();
            return null;
        }

        if (isGPSenabled) {

            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 20, this);
            Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;
        }else{
            Toast.makeText(context, "Error, try enabling GPS", Toast.LENGTH_LONG).show();
        }
        return  null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
