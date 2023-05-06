package com.example.dhara_parmar_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    EditText PersonName, PhoneNumber,EmailAddress,Password;
    Button registerBtn;
    ProgressBar progressBar;
    ImageView banner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        banner = findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(this);

        PersonName = findViewById(R.id.PersonName);
        PhoneNumber = findViewById(R.id.PhoneNumber);
        EmailAddress = findViewById(R.id.EmailAddress);
        Password = findViewById(R.id.Password);
        progressBar = findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.banner:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.registerBtn:
                registerUser();
                break;
        }

    }

    private void registerUser() {

        String Name = PersonName.getText().toString().trim();
        String Contact = PhoneNumber.getText().toString().trim();
        String Email = EmailAddress.getText().toString().trim();
        String Password2 = Password.getText().toString().trim();

        if(Name.isEmpty()){
            PersonName.setError("Full Name is Required!!!");
            PersonName.requestFocus();
            return;
        }

        if(Contact.isEmpty()){
            PhoneNumber.setError("Phone Number is Required!!!");
            PhoneNumber.requestFocus();
            return;
        }

        if(Email.isEmpty()){
            EmailAddress.setError("Email Address is Required!!!");
            EmailAddress.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            EmailAddress.setError("Enter Valid Email Address!!!");
            EmailAddress.requestFocus();
            return;
        }

        if(Password2.isEmpty()){
            Password.setError("Password is Required!!!");
            Password.requestFocus();
            return;
        }

        if(Password2.length() < 6){
            Password.setError("Min password length should be 6 character!");
            Password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email, Password2)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        User user = new User(Name, Contact, Email );

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        startActivity(new Intent(this,LoginUser.class));
                                        Toast.makeText(RegisterUser.this,"Registered Successfully!!",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);


                                        // redirect to login page
                                    } else {
                                        Toast.makeText(RegisterUser.this,"Failed to register!!",Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                    } else {
                        Toast.makeText(RegisterUser.this,"Failed to register!!",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                    }
                }).addOnFailureListener(failure->{

                    Toast.makeText(RegisterUser.this,failure.getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                });
    }
}