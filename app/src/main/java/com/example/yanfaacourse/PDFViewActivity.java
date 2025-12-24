package com.example.yanfaacourse;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewActivity extends AppCompatActivity {
    PDFView pdfViewCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pdfview);
        pdfViewCV=findViewById(R.id.pdfView);
        //pdfViewCV.fromAsset("cv.pdf").load();
        Toast.makeText(this, "PDF loading", Toast.LENGTH_SHORT).show();

//        pdfViewCV.fromAsset("test.pdf")
//                .enableSwipe(true)
//                .swipeHorizontal(false)
//                .enableDoubletap(true)
//                .load();
        pdfViewCV.fromAsset("cv.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .onError(t ->
                        Toast.makeText(this, "PDF error: " + t.getMessage(), Toast.LENGTH_LONG).show()
                )
                .onPageError((page, t) ->
                        Toast.makeText(this, "Page error: " + page, Toast.LENGTH_LONG).show()
                )
                .load();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}