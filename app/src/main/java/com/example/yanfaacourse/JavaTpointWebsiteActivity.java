package com.example.yanfaacourse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JavaTpointWebsiteActivity extends AppCompatActivity {
    WebView wvJavaTpointWebsite;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_tpoint_website);
        wvJavaTpointWebsite = findViewById(R.id.wv_JavaTpointWebsite);
        wvJavaTpointWebsite.loadUrl("https://www.tpointtech.com/java-tutorial");
        //to show images (but in our case it works without it)
        //wvJavaTpointWebsite.getSettings().setJavaScriptEnabled(true);

        //not to go out from your app to open the website from another app like chrome
        wvJavaTpointWebsite.setWebViewClient(new WebViewClient());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}