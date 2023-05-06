package com.example.dhara_parmar_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginUser extends AppCompatActivity implements View.OnClickListener{

     TextView register,forgotPassword;
     EditText Email,pass;
     Button loginBtn;
     ImageView mainLogo;

     private FirebaseAuth mAuth;
     private ProgressBar progressbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);


        register = findViewById(R.id.register);
        //Toast.makeText(this,register.getText().toString(),Toast.LENGTH_SHORT).show();
        register.setOnClickListener(this);

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);

        Email = findViewById(R.id.Emailaddress);
        pass = findViewById(R.id.pass);
        progressbar = findViewById(R.id.progressbar);
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                startActivity(new Intent(this,RegisterUser.class));
                break;
            case R.id.loginBtn:
                userLogin();
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPassword.class));
        }
    }

    private void userLogin() {
        String email = Email.getText().toString().trim();
        String pass2 = pass.getText().toString().trim();

        if (email.isEmpty()) {
            Email.setError("Email Address is Required!!!");
            Email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Enter Valid Email Address!!!");
            Email.requestFocus();
            return;
        }
        if (pass2.isEmpty()) {
            pass.setError("Full Name is Required!!!");
            pass.requestFocus();
            return;
        }
        if(pass2.length() < 6){
            pass.setError("Min password length should be 6 character!");
            pass.requestFocus();
            return;
        }

        progressbar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,pass2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(LoginUser.this,ProductActivity.class));
                } else {
                    Toast.makeText(LoginUser.this,"Failed to login! Please enter valid credentials!!",Toast.LENGTH_SHORT).show();
                    progressbar.setVisibility(View.GONE);
                }
            }
        });
    }
}