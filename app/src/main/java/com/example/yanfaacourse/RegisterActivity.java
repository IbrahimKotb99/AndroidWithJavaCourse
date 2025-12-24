package com.example.yanfaacourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText etFullName, etEmailAddress, etPassword;

    Button btnRegistering;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        btnRegistering= findViewById(R.id.btnRegister);
        etFullName=findViewById(R.id.et_fullName);
        etEmailAddress=findViewById(R.id.et_emailAddress);
        etPassword=findViewById(R.id.et_password);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

        btnRegistering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString().trim();
                String emailAddress = etEmailAddress.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(emailAddress,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                            DatabaseReference newUser = databaseReference.child(firebaseUser.getUid());
                            newUser.child("fullName").setValue(etFullName.getText().toString());
                            newUser.child("emailAddress").setValue(etEmailAddress.getText().toString());
                            newUser.child("password").setValue(etPassword.getText().toString());

                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                            Intent goToMainScreen = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(goToMainScreen);

                        }else {
                            //Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                            Toast.makeText(
                                    RegisterActivity.this,
                                    task.getException().getMessage(),
                                    Toast.LENGTH_LONG
                            ).show();

                        }


                    }
                });

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}