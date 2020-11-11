package com.example.AllForOne;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

//import com.google.android.gms.common.api.ApiException;
//import com.google.android.gms.maps.model.LatLng;

public class DisplayInfoActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.AllForOne.NAME";
    public static final String EXTRA_ADDRESS = "com.example.AllForOne.ADDRESS";
    public static final String EXTRA_PHONE = "com.example.AllForOne.PHONE";
    public static final String EXTRA_TIME = "com.example.AllForOne.TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra(EXTRA_NAME);
        String address = intent.getStringExtra(EXTRA_ADDRESS);
        String phone = intent.getStringExtra(EXTRA_PHONE);
        List<String> time = intent.getStringArrayListExtra(EXTRA_TIME);

        String weekTime = "";

        for(int i = 0; i < time.size(); i++) {
            weekTime += time.get(i) + "\n";
        }

        TextView tName = findViewById(R.id.txtBName);
        TextView tAddress = findViewById(R.id.txtAddress);
        TextView tPhone = findViewById(R.id.txtPhone);
        TextView tTime = findViewById(R.id.txtTime);

        tName.setText(name);
        tAddress.setText(address);
        tPhone.setText(phone);
        tTime.setText(weekTime);
        Linkify.addLinks(tPhone, Linkify.ALL);
    }
}