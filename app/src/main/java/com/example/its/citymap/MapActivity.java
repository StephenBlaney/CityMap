package com.example.its.citymap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    String city = "";
    MapFragment mf;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent I = getIntent();
        city = I.getStringExtra("city");
        mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        mf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        // code to run when the map has loaded

        double lat, lon;

        if (city.equals("Dublin"))
        {
            lat = 53.343908;
            lon = -6.267554;
        }
        else if (city.equals("Cork"))
        {
            lat=51.892751;
            lon=-8.491542;
        }
        else if (city.equals("Galway"))
        {
            lat= 53.276533;
            lon= -9.069362;
        }

        else if (city.equals("Wexford"))
        {
            lat= 52.336521;
            lon= -6.462855;
        }

        else if (city.equals("Belfast"))
        {
            lat= 54.602755;
            lon= -5.945180;
        }

        else if (city.equals("Kerry"))
        {
            lat= 52.264007;
            lon= -9.686990;
        }

        else
        {
            lat=0;
            lon=0;
        }

        map.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lon))
                        .title("")
        );

        map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon)));
        map.moveCamera(CameraUpdateFactory.zoomTo(10));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
