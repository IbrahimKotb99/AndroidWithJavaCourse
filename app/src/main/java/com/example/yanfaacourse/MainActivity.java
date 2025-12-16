package com.example.yanfaacourse;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Boolean pressTwiceExit = false;
    AlertDialog.Builder buildAlertDialog;


//    @Override
//    public void onBackPressed() {
//        //it will check if it is true (it will be true if u clicked twice on the return button) then it will close the app
//        if(pressTwiceExit){
//            super.onBackPressed();
//            //if not? it will make it true then wait 3 sec then returns it to false again ,, and if during
////            the 3 sec it is pressed again then it will go again to the if statememnt and it will close the app
//        }else {
//            pressTwiceExit=true;
//            Toast.makeText(this, "Press again to Exit", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    pressTwiceExit=false;
//                }
//            },3000);
//        }
//
//    }

    TextView txForgetPassword, txRegister;  //casting
    Button btnLoginMain;
    EditText etEmailAddress, etPassword;
    CheckBox chkRememberMe;



    @Override
    public void onBackPressed() {
        buildAlertDialog.setMessage("Do you want to exit")
                .setIcon(R.drawable.mlogoo)
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(MainActivity.this, "Good Bye", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "Welcome again", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = buildAlertDialog.create();
        alertDialog.setTitle("Exit");
        alertDialog.show();
        super.onBackPressed();  //there is problem here this line must be commented

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buildAlertDialog=new AlertDialog.Builder(this);


        txForgetPassword=findViewById(R.id.tx_forgetPass);
        txRegister=findViewById(R.id.tx_register);
        btnLoginMain=findViewById(R.id.btnLogin);
        etEmailAddress= findViewById(R.id.et_emailAddress);
        etPassword = findViewById(R.id.et_password);
        chkRememberMe = findViewById(R.id.chk_rememberMe);


        txForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForgetActivity = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(goToForgetActivity);
            }
        });

        txRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(goToRegister);
            }
        });

        btnLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to Calc App", Toast.LENGTH_SHORT).show();
                Intent goToCalculator = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(goToCalculator);

            }


        });

        SharedPreferences rememberMe = getSharedPreferences("rememberMe",0);
        //rememberMe.getBoolean("bool", false) reads the saved boolean.If it is true,
        // this means user previously selected "Remember Me".
        //Then you auto-fill the email + password.
        //take care of the difference between .getBoolean and .putBoolean
        if (rememberMe.getBoolean("bool",false)==true){
            String emailAddress = rememberMe.getString("email","");
            etEmailAddress.setText(emailAddress);
            String password = rememberMe.getString("password","");
            etPassword.setText(password);
            chkRememberMe.setChecked(true);
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void rememberMe(View view) {
        SharedPreferences rememberMe = getSharedPreferences("rememberMe",0); // creating the file that will comtain the saved data
        SharedPreferences.Editor pen = rememberMe.edit(); // this is the pene that will write the data in the file
        pen.putString("email",etEmailAddress.getText().toString().trim()); //this the first data to be saved consists of a key and the value
        pen.putString("password",etPassword.getText().toString().trim()); // the second one
        pen.putBoolean("bool",true); //to check later whether the user enabled "Remember Me".
        pen.apply();
        Toast.makeText(this, "We saved your data", Toast.LENGTH_SHORT).show();
        chkRememberMe.setChecked(true); // makes the check box checked after saving the data

    }
}