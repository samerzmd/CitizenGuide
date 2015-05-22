package com.apps.salta3a.citizenguide.Activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.apps.salta3a.citizenguide.Fragments.MapFragment;
import com.apps.salta3a.citizenguide.R;

public class MapActivity extends ActionBarActivity {
    public static String locLatArgs="locLat";
    public static String locLonArgs="locLon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        double lat= getIntent().getExtras().getDouble(locLatArgs);
        double lon=getIntent().getExtras().getDouble(locLonArgs);
        getSupportFragmentManager().beginTransaction().add(R.id.container,MapFragment.newInstaince(lat,lon)).commit();
    }
}
