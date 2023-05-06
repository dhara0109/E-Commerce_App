package com.example.dhara_parmar_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText ResetEmail;
    private Button ResetBtn;
    private ImageView logoReset;
    private ProgressBar progressBarReset;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        ResetEmail = findViewById(R.id.ResetEmail);
        ResetBtn = findViewById(R.id.ResetBtn);
        logoReset = findViewById(R.id.logoReset);
        progressBarReset = findViewById(R.id.progressBarReset);

        auth = FirebaseAuth.getInstance();

        ResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword(){
        String email = ResetEmail.getText().toString().trim();
        if(email.isEmpty()){
            ResetEmail.setError("Email is required!!!");
            ResetEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ResetEmail.setError("Enter valid Email!!!");
            ResetEmail.requestFocus();
            return;
        }

        progressBarReset.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,"Check your email to reset password...",Toast.LENGTH_SHORT).show();
                    progressBarReset.setVisibility(View.GONE);
                } else {
                    Toast.makeText(ForgotPassword.this,"Try again! Something wrong happened...",Toast.LENGTH_SHORT).show();
                    progressBarReset.setVisibility(View.GONE);
                }
            }
        });
    }
}