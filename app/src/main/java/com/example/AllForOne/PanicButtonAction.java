package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PanicButtonAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_button_action);

        Button sendSNS = (Button) findViewById(R.id.btn_sendEmergency);

        sendSNS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PanicButtonAction.this, LocationApp.class));
            }
        });
    }
}