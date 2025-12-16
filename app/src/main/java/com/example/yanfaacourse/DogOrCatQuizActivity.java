package com.example.yanfaacourse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DogOrCatQuizActivity extends AppCompatActivity {

    RadioGroup rgQuest1, rgQuest2;
    RadioButton rbQuest1, rbQuest2;
    Button btnGetQuizResult;
    TextView tvShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dog_or_cat_quiz);
        rgQuest1 = findViewById(R.id.rg_question1);
        rgQuest2 = findViewById(R.id.rg_question2);
        rbQuest1 = findViewById(R.id.rb_never);
        rbQuest2 = findViewById(R.id.rb_notPhysicalPerson);
        btnGetQuizResult = findViewById(R.id.btn_getQuizResult);
        tvShowResult = findViewById(R.id.tv_quizResult);

        btnGetQuizResult.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int rbQuest1Answer = rgQuest1.getCheckedRadioButtonId();
                rbQuest1 = findViewById(rbQuest1Answer);
                int rbQuest2Answer = rgQuest2.getCheckedRadioButtonId();
                rbQuest2 = findViewById(rbQuest2Answer);

                if (rbQuest1Answer==-1 || rbQuest2Answer==-1 ){
                    Toast.makeText(DogOrCatQuizActivity.this, "Please choose answer", Toast.LENGTH_SHORT).show();
                }else {
                    if (rbQuest1.getText().toString().toUpperCase().equals("NEVER")&&
                            rbQuest2.getText().toString().toUpperCase().equals("ALL THE TIME")){
                        tvShowResult.setText("You are a cat person");
                    } else if (rbQuest1.getText().toString().toUpperCase().equals("SOMETIMES")&&
                            rbQuest2.getText().toString().toUpperCase().equals("RARELY")) {
                        tvShowResult.setText("You are a dog person");
                    }else if (rbQuest1.getText().toString().toUpperCase().equals("ALWAYS")&&
                            rbQuest2.getText().toString().toUpperCase().equals("NOT A PHYSICAL PERSON")) {
                        tvShowResult.setText("You are a 50% dog person and 50% cat person");
                    }
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}