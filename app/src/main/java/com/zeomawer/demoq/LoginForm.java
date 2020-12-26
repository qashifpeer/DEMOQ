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

public class LoginForm extends AppCompatActivity {
    EditText txtEmail,txtPassword;
    Button btnLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");

        txtEmail= (EditText)findViewById(R.id.userName_login);
        txtPassword=(EditText)findViewById(R.id.password_login);
        btnLogin=(Button)findViewById(R.id.btn_login);
        firebaseAuth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
                        public void onClick(View v) {

                            String email=txtEmail.getText().toString().trim();
                            String password=txtPassword.getText().toString().trim();

                            if(TextUtils.isEmpty(email)){
                                Toast.makeText(LoginForm.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                                return;

                            }
                            if(TextUtils.isEmpty(password)){
                                Toast.makeText(LoginForm.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                                return;

                            }
                            if(password.length()<6){
                                Toast.makeText(LoginForm.this, "Password should be at least 6 chars", Toast.LENGTH_SHORT).show();
                            }


                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginForm.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), RegisterStudent.class));

                                } else {

                                    Toast.makeText(LoginForm.this, "Failed To Login", Toast.LENGTH_SHORT).show();

                                }

                                                          }
                        });






                        }
        });

    }

    public void btn_RegisterForm(View view) {

        startActivity(new Intent(getApplicationContext(), RegisterForm.class));
    }
}