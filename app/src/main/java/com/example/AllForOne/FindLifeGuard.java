package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FindLifeGuard extends ListActivity {

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.citycentreupcc.ca")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vch.ca/Locations-Services/result?res_id=597")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vch.ca/Locations-Services/result?res_id=1438")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vch.ca/StaticDirectoryPages/573.aspx")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https:///www.providencehealthcare.org/hospitals-residences/mount-saint-joseph-hospital")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://http://www.vch.ca/Locations-Services/result?res_id=991")));
                break;
            case 6:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.providencehealthcare.org/hospitals-residences/st-paul%27s-hospital")));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_find_life_guard);

        String[] emergencies = {"City Center Urgent Primary care center", "Gordon & Leslie Diamond Helth Care Center",
                "North Vancouver Urgent In Primary Care Center","Vancouver General Hospital Emergency Dept",
                "Mount Saint Joseph Emergency Dept","Urgent Care Center-UBC","Saint Paul's Hospital Emergency"};

        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_find_life_guard,
                            R.id.lifeGuard, emergencies));

    }
}