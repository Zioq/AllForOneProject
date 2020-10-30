package com.example.AllForOne;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
        , GoogleApiClient.ConnectionCallbacks
        , LocationListener {

    private GoogleMap mMap;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    private double latitude, longitude;
    private int ProximityRadius = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //Assign variable
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);

        //Initialize fused location
        client = LocationServices.getFusedLocationProviderClient(this);

        //check permission
        if(ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            //When permission granted call method
            getCurrentLocation();
        }else{
            //When permission denied, request permission
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        //getNearbyHospitals(latitude, longitude);

    }

    private void getCurrentLocation() {
        //Initialize task location
        Task<Location> task = client.getLastLocation();

        String hospital = "hospital";
        Object transferData[] = new Object[2];
        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();

        List<Address> addressList = null;
        MarkerOptions userMarkerOptions = new MarkerOptions();
        Geocoder geocoder = new Geocoder(this);

        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                //When success
                if(location != null){
                    //Sync map
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            //Initialize lat lng
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            //Create marker options
                            MarkerOptions options = new MarkerOptions().position(latLng).title("Your Location");
                            //Zoom map
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
                            //add marker on map
                            googleMap.addMarker(options);
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();


                           //mMap.clear();
                            String url = getUrl(latitude, longitude, hospital);
                            transferData[0] = mMap;
                            transferData[1] = url;
                            getNearbyPlaces.execute(transferData);
//                            Toast.makeText(this, "Searching for nearby hospitals", Toast.LENGTH_SHORT).show();
//                            Toast.makeText(this, "Showing nearby hospitals", Toast.LENGTH_SHORT).show();;
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 44){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //When permission granted call method
                getCurrentLocation();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    }

    public void getNearbyHospitals(double lat, double lon){

    }

//    public void onClick(View v){
//        String hospital = "hospital", shelter = "shelter", restaurants = "restaurant";
//        Object transferData[] = new Object[2];
//        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
//
//        switch ((v.getId())){
//            case R.id.search_button:
//                EditText addressField = (EditText) findViewById(R.id.location_search);
//                String address = addressField.getText().toString();//getting the text from the text field
//
//                List<Address> addressList = null;
//                MarkerOptions userMarkerOptions = new MarkerOptions();
//
//                if(!TextUtils.isEmpty(address)){
//                    Geocoder geocoder = new Geocoder(this);
//
//                    try {
//                        addressList = geocoder.getFromLocationName(address, 6);
//                        if(addressList != null){
//                            for(int i = 0; i < addressList.size(); i++){
//                                Address userAddress = addressList.get(i);
//                                LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());
//
//                                userMarkerOptions.position(latLng);
//                                userMarkerOptions.title(address);
//                                userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
//
//                                mMap.addMarker(userMarkerOptions);
//                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
//                            }
//                        } else {
//                            Toast.makeText(this, "Location not found...", Toast.LENGTH_SHORT).show();
//                        }
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }else{
//                    Toast.makeText(this, "Please write any location", Toast.LENGTH_LONG);
//                }
//                break;*/
//            case R.id.hospitals_nearby:
//                mMap.clear();
//                String url = getUrl(latitude, longitude, hospital);
//                transferData[0] = mMap;
//                transferData[1] = url;
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby hospitals", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing nearby hospitals", Toast.LENGTH_SHORT).show();;
//                break;
//
//            case R.id.shelters_nearby:
//                mMap.clear();
//                url = getUrl(latitude, longitude, shelter);
//                transferData[0] = mMap;
//                transferData[1] = url;
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby shelters", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing nearby shelters", Toast.LENGTH_SHORT).show();;
//                break;
//
//            case R.id.restaurant_nearby:
//                mMap.clear();
//                url = getUrl(latitude, longitude, restaurants);
//                transferData[0] = mMap;
//                transferData[1] = url;
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby restaurants", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing nearby restaurants", Toast.LENGTH_SHORT).show();;
//                break;
//        }
//    }
    private String getUrl(double latitude, double longitude, String nearbyPlace) {
        StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location=" + latitude + "," + longitude);
        //googleURL.append("location=" + "49.2827283" + "," + "-123.1207367");
        googleURL.append("&radius=" + ProximityRadius);
        googleURL.append("&type=" + nearbyPlace);
        googleURL.append("&sensor=true");
        googleURL.append("&key=" + "AIzaSyBBb5inzGlwH-L_crGgtBP1jWe9zu_URzA");

        Log.d("GoogleMapsActivity", "Url: " + googleURL.toString());
        return  googleURL.toString();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }
}