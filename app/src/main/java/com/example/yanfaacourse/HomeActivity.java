package com.example.yanfaacourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCalculator, btnRandomHighestMountain,btnRestaurant, btnDogOrCat, btnJavaTpointWeb
            ,btnPdfView, btnTempConvertor, btnMediaPlayer, btnXOGame, btnGoogleMaps, btnFakeAPI ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        btnCalculator=findViewById(R.id.btn_calc);
        btnRandomHighestMountain=findViewById(R.id.btn_randomHighestM);
        btnRestaurant=findViewById(R.id.btn_restaurant);
        btnDogOrCat=findViewById(R.id.btn_dogOrCat);
        btnPdfView = findViewById(R.id.btn_pdfView);
        btnTempConvertor = findViewById(R.id.btn_temperatureConvertor);
        btnMediaPlayer = findViewById(R.id.btn_mediaPlayer);
        btnXOGame = findViewById(R.id.btn_xoGame);
        btnGoogleMaps= findViewById(R.id.btn_googleMaps);
        btnFakeAPI= findViewById(R.id.btn_fakeAPI);
        btnFakeAPI.setOnClickListener(this);
        btnGoogleMaps.setOnClickListener(this);
        btnXOGame.setOnClickListener(this);
        btnMediaPlayer.setOnClickListener(this);
        btnTempConvertor.setOnClickListener(this);
        btnPdfView.setOnClickListener(this);
        btnJavaTpointWeb = findViewById(R.id.btn_javaTpointWebsite);
        btnJavaTpointWeb.setOnClickListener(this);
        btnDogOrCat.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);
        btnRandomHighestMountain.setOnClickListener(this);
        btnRestaurant.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_calc){
            Intent goToCalc = new Intent(getApplicationContext(), CalculatorActivity.class);
            startActivity(goToCalc);
        } else if (v.getId()==R.id.btn_randomHighestM) {
            Intent goToRandomH = new Intent(getApplicationContext(), RandomHighestMountain.class);
            startActivity(goToRandomH);

        }else if (v.getId()==R.id.btn_restaurant) {
            Intent goToRestaurant = new Intent(getApplicationContext(), RestaurantActivity.class);
            startActivity(goToRestaurant);
        }else if (v.getId()==R.id.btn_dogOrCat) {
            Intent goToDogOrCat = new Intent(getApplicationContext(), DogOrCatQuizActivity.class);
            startActivity(goToDogOrCat);
        }else if (v.getId()==R.id.btn_javaTpointWebsite) {
            Intent goToJavaTpointWebsite = new Intent(getApplicationContext(), JavaTpointWebsiteActivity.class);
            startActivity(goToJavaTpointWebsite);
        }else if (v.getId()==R.id.btn_pdfView) {
            Intent goToPdf = new Intent(getApplicationContext(), PDFViewActivity.class);
            startActivity(goToPdf);
        }else if (v.getId()==R.id.btn_temperatureConvertor) {
            Intent goToTempConvertor = new Intent(getApplicationContext(), TemperatureConverterActivity.class);
            startActivity(goToTempConvertor);
        }else if (v.getId()==R.id.btn_mediaPlayer) {
            Intent goToMediaPlayer = new Intent(getApplicationContext(), MediaPlayerAcivity.class);
            startActivity(goToMediaPlayer);
        }else if (v.getId()==R.id.btn_xoGame) {
            Intent goToXOGame = new Intent(getApplicationContext(), XOGameActivity.class);
            startActivity(goToXOGame);
        }else if (v.getId()==R.id.btn_googleMaps) {
            Intent goToGoogleMaps = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(goToGoogleMaps);
        }
    }
}


