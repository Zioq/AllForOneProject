package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.time.temporal.ValueRange;

public class Navigation extends AppCompatActivity {

    CardView shelter;
    CardView bchouse;
    CardView hospital;
    CardView panicbutton;
    CardView food;
    CardView lifeguard;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        shelter = findViewById(R.id.shelter);
        bchouse = findViewById(R.id.bchouse);
        hospital = findViewById(R.id.hospital);
        panicbutton = findViewById(R.id.panic);
        food = findViewById(R.id.food);
        lifeguard = findViewById(R.id.lifeguard);

        shelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this, FindShelter.class));
            }
        });

        bchouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,FindBcHousing.class));
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this, FindHospital.class));
            }
        });

        panicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this, PanicButtonAction.class));
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Navigation.this, FindFood.class));
            }
        });

        lifeguard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this, FindLifeGuard.class));
            }
        });
    }
}