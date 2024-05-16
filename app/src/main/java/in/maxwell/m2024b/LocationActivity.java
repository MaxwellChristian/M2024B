package in.maxwell.m2024b;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 112233;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);

        Log.d("LocationActivity", "onCreate: location permission granted: " + isLocationPermissionGranted());

        if (!isLocationPermissionGranted()) {
            requestPermissions(
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {

            if (!isLocationPermissionGranted()) {
                requestPermissions(
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_PERMISSION_REQUEST_CODE);
            } else {

                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

                boolean hasGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                boolean hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if (hasGPS) {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0F, location -> {
                        Log.d("LocationActivity", "onCreate: location (GPS): " + location);
                    });

                }

                if (hasNetwork) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 0F, location -> {
                        Log.d("LocationActivity", "onCreate: location (Network): " + location);
                    });
                }

            }

        }

    }

    private boolean isLocationPermissionGranted() {

        if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        return true;

//        return checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
//                && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d("LocationActivity", "onRequestPermissionsResult: location permission granted");
        } else {
            Log.d("LocationActivity", "onRequestPermissionsResult: location permission denied");
        }
    }
}