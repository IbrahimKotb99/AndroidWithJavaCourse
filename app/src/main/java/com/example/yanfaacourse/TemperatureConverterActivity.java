package com.example.yanfaacourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TemperatureConverterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFahrenheit, etCelsius;
    Button btnConvert, btnResetTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature_converter);
        etCelsius = findViewById(R.id.et_celsius);
        etFahrenheit = findViewById(R.id.et_fahrenheit);
        etCelsius.setOnClickListener(this);
        etFahrenheit.setOnClickListener(this);
        btnConvert = findViewById(R.id.btn_convert);
        btnResetTmp = findViewById(R.id.btn_resetTempValues);
        btnConvert.setOnClickListener(this);
        btnResetTmp.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        String fahrenheitString = etFahrenheit.getText().toString().trim();
        String clesiusString = etCelsius.getText().toString().trim();

        if (v.getId() == R.id.btn_convert) {
            if (!fahrenheitString.isEmpty() && clesiusString.isEmpty()) {
                double fahrenheitDouble = Double.parseDouble(fahrenheitString);
                String result = String.valueOf((fahrenheitDouble - 32) / 1.8);
                etCelsius.setText(result);
            } else if (fahrenheitString.isEmpty() && !clesiusString.isEmpty()) {
                double clesiusDouble = Double.parseDouble(clesiusString);
                String result = String.valueOf((clesiusDouble * 1.8) + 32);
                etFahrenheit.setText(result);
            } else if (!fahrenheitString.isEmpty() && !clesiusString.isEmpty()) {
                Toast.makeText(this, "There is two values ! Put only one", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "There is no values !", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_resetTempValues) {
            etCelsius.setText("");
            etFahrenheit.setText("");
        }
    }

}