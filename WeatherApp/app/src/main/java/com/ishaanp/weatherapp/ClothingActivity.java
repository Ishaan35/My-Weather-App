package com.ishaanp.weatherapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClothingActivity extends AppCompatActivity {

    private ImageView top;
    private ImageView bottom;
    private ImageView shoes;
    private ImageView Extras1;
    private ImageView Extras2;
    private ImageView Extras3;


    private TextView topTXT;
    private TextView bottomTXT;
    private TextView shoesTXT;
    private TextView Extras1TXT;
    private TextView Extras2TXT;
    private TextView Extras3TXT;


    private TextView Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        Location = findViewById(R.id.location_);
        top = findViewById(R.id.top_clothing_image);
        bottom = findViewById(R.id.bottom_clothing_image);
        shoes = findViewById(R.id.shoe_image);
        Extras1 = findViewById(R.id.extras1);
        Extras2 = findViewById(R.id.extras2);
        Extras3 = findViewById(R.id.extras3);

        topTXT = findViewById(R.id.top_clothing_text);
        bottomTXT = findViewById(R.id.bottom_clothing_text);
        shoesTXT = findViewById(R.id.shoe_text);
        Extras1TXT = findViewById(R.id.extras1_text);
        Extras2TXT = findViewById(R.id.extras2_text);
        Extras3TXT = findViewById(R.id.extras3_text);


        Location.setText(MainActivity.currentLocation);

        //umbrella
        if(MainActivity.condition.equals("Drizzle") || MainActivity.condition.equals("Rain")){
            Extras3.setImageResource(R.drawable.umbrella);
            Extras3TXT.setText("Umbrella");
        } else{
            Extras3.setImageResource(R.color.Transparent);
            Extras3TXT.setText("");
        }

        //hat
        if(MainActivity.current_temperature <=10){
            Extras1.setImageResource(R.drawable.hat);
            Extras1TXT.setText("Hat");

        } else{
            Extras1.setImageResource(R.color.Transparent);
            Extras1TXT.setText("");
        }

        //scarf
        if(MainActivity.current_temperature <5){
            Extras2.setImageResource(R.drawable.scarf);
            Extras2TXT.setText("Scarf");
        } else{
            Extras2.setImageResource(R.color.Transparent);
            Extras2TXT.setText("");
        }

        //top
        if(MainActivity.current_temperature <= 5){
            top.setImageResource(R.drawable.winterjacket);
            topTXT.setText("Winter Jacket");
        } else if(MainActivity.current_temperature > 5 && MainActivity.current_temperature <= 12){
            top.setImageResource(R.drawable.jacket);
            topTXT.setText("Jacket");
        }else if(MainActivity.current_temperature > 12 && MainActivity.current_temperature < 20){
            top.setImageResource(R.drawable.sweater);
            topTXT.setText("Sweater");
        }else if(MainActivity.current_temperature >= 20 && MainActivity.current_temperature < 25){
            top.setImageResource(R.drawable.regularshirt);
            topTXT.setText("Shirt");
        }else if(MainActivity.current_temperature >= 25){
            top.setImageResource(R.drawable.tshirt);
            topTXT.setText("T-Shirt");
        }

        //bottom
        if(MainActivity.current_temperature >= 25){
            bottom.setImageResource(R.drawable.shorts);
            bottomTXT.setText("Shorts");
        }else{
            bottom.setImageResource(R.drawable.trousers);
            bottomTXT.setText("Trousers");
        }

        //boot
        if(MainActivity.current_temperature < 5){
            shoes.setImageResource(R.drawable.boot);
            shoesTXT.setText("Boots");
        }else{
            shoes.setImageResource(R.drawable.shoe);
            shoesTXT.setText("Shoes");
        }






    }
}
