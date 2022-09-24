package com.beast.nari;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;

import com.beast.nari.databinding.ActivityMapsBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zaag;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    double LATITUDE = -34, LONGITUDE = 152;
    int PERMISSION_ID = 44;
    private LocationManager locationManager;
    ProgressDialog progressDialog;
    private GoogleApiClient client;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        
       checkLocation();

       progressDialog.setMessage("Please Wait...");
//       progressDialog.show();

    }

    @SuppressLint("MissingPermission")
    private void checkLocation() {

        progressDialog.dismiss();

        if (checkPermissions()){

            if (isLocationEnabled()){

                getLocationData();
//                progressDialog.show();

            }else {
                enableLocation();
            }

        }else {
            requestPermissions();
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(LATITUDE, LONGITUDE);
        MarkerOptions options = new MarkerOptions();
        options.position(sydney);
        options.title("Nari's Location");

        mMap.addMarker(options).showInfoWindow();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    @SuppressLint("MissingPermission")
    private void setMarkerTOMap(){
        mMap.clear();
        LatLng sydney = new LatLng(LATITUDE, LONGITUDE);

        MarkerOptions options = new MarkerOptions();
        options.position(sydney);
        options.title("Nari's Location" );


        mMap.addMarker(options).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        mMap.moveCamera(CameraUpdateFactory.zoomTo(18));

        progressDialog.dismiss();

        locationManager =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {



        LATITUDE = location.getLatitude();
        LONGITUDE = location.getLongitude();
        locationManager.removeUpdates(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setMarkerTOMap();
            }
        }, 2000);

    }







    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        // If we want background location
        // on Android 10.0 and higher,
        // use:
        // ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    private void enableLocation(){
        Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }






    @SuppressLint("MissingPermission")
    private void getLocationData(){
        
        client = new GoogleApiClient() {
            @NonNull
            @Override
            public ConnectionResult blockingConnect() {
                return null;
            }

            @NonNull
            @Override
            public ConnectionResult blockingConnect(long l, @NonNull TimeUnit timeUnit) {
                return null;
            }

            @NonNull
            @Override
            public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
                return null;
            }

            @NonNull
            @Override
            public PendingResult<Status> clearDefaultAccountAndReconnect() {
                return null;
            }

            @Override
            public void connect() {

            }

            @Override
            public void disconnect() {

            }

            @Override
            public void dump(@NonNull String s, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strings) {

            }

            @Override
            public void reconnect() {

            }

            @Override
            public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

            }

            @Override
            public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

            }

            @Override
            public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {

            }

            @Override
            public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

            }

            @Override
            public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

            }

            @Override
            public boolean hasConnectedApi(@NonNull Api<?> api) {
                return false;
            }

            @Override
            public boolean isConnected() {
                return false;
            }

            @Override
            public boolean isConnecting() {
                return false;
            }

            @Override
            public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
                return false;
            }

            @Override
            public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
                return false;
            }
        };
        client.connect();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null){

                            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                            try {
                                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                                Toast.makeText(MapsActivity.this, "location retrived successfully", Toast.LENGTH_SHORT).show();

                                LATITUDE = addresses.get(0).getLatitude();
                                LONGITUDE = addresses.get(0).getLongitude();

                                setMarkerTOMap();


                            } catch (IOException e) {
                                Toast.makeText(MapsActivity.this, "location exception" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MapsActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }


}