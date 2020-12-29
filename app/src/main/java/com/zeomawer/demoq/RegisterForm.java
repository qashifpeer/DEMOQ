package com.zeomawer.demoq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterForm extends AppCompatActivity {
    EditText txtEmail, txtPassword, txtConfirmPassword;
    Button btnRegister;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        getSupportActionBar().setTitle("Registration Form");

        txtEmail= (EditText)findViewById(R.id.txt_email);
        txtPassword=(EditText)findViewById(R.id.txt_password);
        txtConfirmPassword=(EditText)findViewById(R.id.txt_confirm_password);
        btnRegister=(Button)findViewById(R.id.btn_register);

        firebaseAuth=FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                String confirmPassword=txtConfirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterForm.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterForm.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(RegisterForm.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(password.length()<6){
                    Toast.makeText(RegisterForm.this, "Password should be at least 6 chars", Toast.LENGTH_SHORT).show();
                }

                if(password.equals(confirmPassword)){


                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterForm.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(),LoginForm.class));
                                        Toast.makeText(RegisterForm.this, "Registration Complete,Please Login", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }

                                     else {
                                        Toast.makeText(RegisterForm.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                    // ...
                                }
                            });


                }



            }
        });



    }
}