package com.example.android.peta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlacePickerActivity extends AppCompatActivity {

    @BindView(R.id.bt_ppicker)
    Button btPpicker;
    @BindView(R.id.tv_place_id)
    TextView tvPlaceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_picker);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_ppicker, })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ppicker:
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(PlacePickerActivity.this),1);
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode ==RESULT_OK){
            Place place = PlacePicker.getPlace(PlacePickerActivity.this,data);
            String informasilokasi = String.format("place : %s \n" +"alamat : %s \n"+"latlong : %s",
                    place.getName(),place.getAddress(),place.getLatLng().latitude+", "+ place.getLatLng().longitude);
            tvPlaceId.setText(informasilokasi);
        }
    }
}
