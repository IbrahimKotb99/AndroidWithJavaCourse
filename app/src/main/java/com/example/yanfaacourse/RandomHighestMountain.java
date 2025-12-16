package com.example.yanfaacourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RandomHighestMountain extends AppCompatActivity {

    TextView tvRandomMountain;
    Button btnGenerateRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_highest_mountain);
        tvRandomMountain = findViewById(R.id.tv_randomMountain);
        btnGenerateRandom = findViewById(R.id.btn_generate_Random);
        btnGenerateRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mountainNamesArr[] = {"Everest", "Ohod", "Saint Katreen", "Hormoz"};
                //selecting random string from the array list
                Random random = new Random();
                int index = random.nextInt(mountainNamesArr.length); //selecting the random index of the array and saving it in a variable
                tvRandomMountain.setText(mountainNamesArr[index]);  //showing the mountain name of the chosen index on the textview
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}