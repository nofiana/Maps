package com.example.android.peta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlacePicker(View view) {
        startActivity(new Intent(MainActivity.this,PlacePickerActivity.class));
    }

    public void onMap(View view) {
        startActivity( new Intent(MainActivity.this,MapsActivity.class));
    }

    public void onListMAp(View view) {
        startActivity(new Intent(MainActivity.this,ListMapsActivityy.class));
    }
}
