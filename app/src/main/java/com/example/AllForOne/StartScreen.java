package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        //varibles
        Button login = (Button)findViewById(R.id.btnLogin);
        Button sign = (Button)findViewById(R.id.btnSignIn);
        Button tryIt =findViewById(R.id.btnContinue);
        Button navi = (Button) findViewById(R.id.btnNavi);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartScreen.this,Login.class));
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartScreen.this,SignIn.class));
            }
        });

        tryIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartScreen.this,MapsActivity.class));
            }
        });

        navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartScreen.this, Navigation.class));
            }
        });



    }
}