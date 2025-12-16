package com.example.yanfaacourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RestaurantActivity extends AppCompatActivity {

    CheckBox chkPizza, chkBurger, chkFriedChicken, chkPepsi, chkTea, chkOrangeJuice;
    Button btnGetInvoice;
    TextView tvInvoice;
    int invoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restaurant);
        chkBurger=findViewById(R.id.chk_burger);
        chkPizza=findViewById(R.id.chk_pizza);
        chkTea=findViewById(R.id.chk_tea);
        chkFriedChicken=findViewById(R.id.chk_fried_chicken);
        chkPepsi=findViewById(R.id.chk_pepsi);
        chkOrangeJuice=findViewById(R.id.chk_orange_juice);
        btnGetInvoice=findViewById(R.id.btn_get_invoice);
        tvInvoice=findViewById(R.id.tv_invoice);

        btnGetInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invoice=0;
                StringBuilder totalStringOrder = new StringBuilder();
                if (chkBurger.isChecked()){
                    invoice+=25;
                    totalStringOrder.append(chkBurger.getText().toString()+ ",");
                }
                if (chkFriedChicken.isChecked()){
                    invoice+=30;
                    totalStringOrder.append(chkFriedChicken.getText().toString()+ ",");
                }
                if (chkTea.isChecked()){
                    invoice+=3;
                    totalStringOrder.append(chkTea.getText().toString()+ ",");
                }
                if (chkPizza.isChecked()){
                    invoice+=20;
                    totalStringOrder.append(chkPizza.getText().toString()+ ",");
                }
                if (chkPepsi.isChecked()){
                    invoice+=5;
                    totalStringOrder.append(chkPepsi.getText().toString()+ ",");
                }
                if (chkOrangeJuice.isChecked()){
                    invoice+=6;
                    totalStringOrder.append(chkOrangeJuice.getText().toString()+ ",");
                }
                tvInvoice.setText("The total order is " + totalStringOrder + " and your invoice is " + invoice + " $");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}