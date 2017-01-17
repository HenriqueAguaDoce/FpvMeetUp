package pt.ipbeja.pdm2.fpvmeetup;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
    Location location;
    private boolean checkBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Fpv Meet Up");

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria,true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        location = locationManager.getLastKnownLocation(bestProvider);
        if (location == null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider,20000,0,this);
    }

    @Override
    public void onBackPressed() {

        if (checkBack == false)
        {
            Toast.makeText(MainActivity.this, "Click again to exit", Toast.LENGTH_SHORT).show();
            checkBack = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkBack = false;
                }
            }, 2000);
        }
        else if (checkBack = true)
        {
            System.exit(0);
        }
    }

    public void imgConditions_onClick(View view) {
        Intent i = new Intent(this, WeatherActivity.class);
        startActivity(i);
    }

    public void imgBuild_onClick(View view) {
        Intent i = new Intent(this, BuildInfo.class);
        startActivity(i);
    }

    public void imgLocation_onClick(View view) {
        if (isGPSEnabled(this)== true) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            Uri uri = Uri.parse("geo:" + latitude + "," + longitude);

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Gps disconnected", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isGPSEnabled (Context mContext){
        LocationManager locationManager = (LocationManager)
                mContext.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(Location location) {


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
