package com.example.yanfaacourse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFirstNumber, etSecondNumber;
    Button btnAddition, btnSubtraction, btnMultiplication, btnDivision, btnResetting;
    TextView tvShowResult;
    String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        etFirstNumber=findViewById(R.id.etFirstNum);
        etSecondNumber=findViewById(R.id.etSecondNum);
        tvShowResult=findViewById(R.id.tvResult);
        btnSubtraction=findViewById(R.id.btnSub);
        btnMultiplication=findViewById(R.id.btnMul);
        btnDivision=findViewById(R.id.btnDiv);
        btnResetting=findViewById(R.id.btnReset);
        btnAddition=findViewById(R.id.btnAdd);
        btnAddition.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnResetting.setOnClickListener(this);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        //the data from the edit text is string do you should take any data from it and switch it to string
        String firstNum=etFirstNumber.getText().toString().trim();
        String secondNum=etSecondNumber.getText().toString().trim();

        if (firstNum.isEmpty()&&secondNum.isEmpty()){
            Toast.makeText(this, "Please Enter Values", Toast.LENGTH_SHORT).show();
        }else {
            //the data taken from the et is string and i cant make math on it so i should parse it to double
            double firstNumDouble=Double.parseDouble(firstNum);
            double secondNumDouble=Double.parseDouble(secondNum);

//            switch (v.getId()){
//                case R.id.btnAdd:
//                    operation= String.valueOf(firstNumDouble+secondNumDouble);
//                    tvShowResult.setText(operation);
//                    break;
//                case R.id.btnSub:
//                    operation= String.valueOf(firstNumDouble-secondNumDouble);
//                    tvShowResult.setText(operation);
//                    break;
//                case R.id.btnMul:
//                    operation= String.valueOf(firstNumDouble*secondNumDouble);
//                    tvShowResult.setText(operation);
//                    break;
//                case R.id.btnDiv:
//                    operation= String.valueOf(firstNumDouble/secondNumDouble);
//                    tvShowResult.setText(operation);
//                    break;
//                case R.id.btnReset:
//                    etFirstNumber.setText("");
//                    etSecondNumber.setText("");
//                    break;
//
//            }

            if (v.getId() == R.id.btnAdd) {
                //taking the value of the result as Double and return it back to String to be shown on the tv
                operation = String.valueOf(firstNumDouble + secondNumDouble);
                tvShowResult.setText(operation);

            } else if (v.getId() == R.id.btnSub) {
                operation = String.valueOf(firstNumDouble - secondNumDouble);
                tvShowResult.setText(operation);

            } else if (v.getId() == R.id.btnMul) {
                operation = String.valueOf(firstNumDouble * secondNumDouble);
                tvShowResult.setText(operation);

            } else if (v.getId() == R.id.btnDiv) {
                operation = String.valueOf(firstNumDouble / secondNumDouble);
                tvShowResult.setText(operation);

            } else if (v.getId() == R.id.btnReset) {
                etFirstNumber.setText("");
                etSecondNumber.setText("");
            }

        }


    }

}
