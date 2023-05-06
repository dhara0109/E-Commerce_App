package com.example.dhara_parmar_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener{

    EditText PersonName,Emailaddress,contactNumber,PostalAddress, PostalCode,
            cardHolder,cardNumber,ExpDate,cvv;
    TextView creditDetails;
    Button checkOutBtn;
    ImageView mainLogo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        PersonName = findViewById(R.id.PersonName);
        Emailaddress = findViewById(R.id.Emailaddress);
        contactNumber = findViewById(R.id.contactNumber);
        PostalAddress = findViewById(R.id.PostalAddress);
        PostalCode = findViewById(R.id.PostalCode);
        cardHolder = findViewById(R.id.cardHolder);
        cardNumber = findViewById(R.id.cardNumber);
        ExpDate = findViewById(R.id.ExpDate);
        cvv = findViewById(R.id.cvv);
        creditDetails = findViewById(R.id.creditDetails);
        checkOutBtn = findViewById(R.id.checkOutBtn);
        mainLogo = findViewById(R.id.backMainPage);
        checkOutBtn.setOnClickListener(this);
        mainLogo.setOnClickListener(this);

        ExpDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String current = s.toString();
                if(current.length() == 2 && start == 1){
                    ExpDate.setText(current + "/");
                    ExpDate.setSelection(current.length() + 1);
                } else if(current.length() == 2 && before == 1){
                    current = current.substring(0,1);
                    ExpDate.setText(current + "/");
                    ExpDate.setSelection(current.length());

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backMainPage:
                startActivity(new Intent(CheckoutActivity.this,MainActivity.class));
                Toast.makeText(CheckoutActivity.this,"logo click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkOutBtn:
                userCheckout();
                break;
        }
    }

    private void userCheckout() {
        String name = PersonName.getText().toString().trim();
        String email = Emailaddress.getText().toString().trim();
        String number = contactNumber.getText().toString().trim();
        String paddress = PostalAddress.getText().toString().trim();
        String zipcode = PostalCode.getText().toString().trim();
        String cardname = cardHolder.getText().toString().trim();
        String card = cardNumber.getText().toString().trim();
        String exp = ExpDate.getText().toString().trim();
        String cardCvv = cvv.getText().toString().trim();

        if (name.isEmpty()) {
            PersonName.setError("Name is Required!!!");
            PersonName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            Emailaddress.setError("Email Address is Required!!!");
            Emailaddress.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Emailaddress.setError("Enter Valid Email Address!!!");
            Emailaddress.requestFocus();
            return;
        }

        if (number.isEmpty()) {
            contactNumber.setError("Contact Info is Required!!!");
            contactNumber.requestFocus();
            return;
        }
        if (number.length() != 10) {
            contactNumber.setError("Enter valid Contact Number!!!");
            contactNumber.requestFocus();
            return;
        }
        if (paddress.isEmpty()) {
            PostalAddress.setError("Postal Address is Required!!!");
            PostalAddress.requestFocus();
            return;
        }
        if (zipcode.isEmpty()) {
            PostalCode.setError("Postal Code is Required!!!");
            PostalCode.requestFocus();
            return;
        }
        if(zipcode.length() != 6){
            PostalCode.setError("Enter valid Postal Code!!!");
            PostalCode.requestFocus();
            return;
        }
        if (cardname.isEmpty()) {
            cardHolder.setError("Card Holder Name is Required!!!");
            cardHolder.requestFocus();
            return;
        }
        if (card.isEmpty()) {
            cardNumber.setError("Enter valid Card Number!!!");
            cardNumber.requestFocus();
            return;
        }
        if (exp.isEmpty()) {
            ExpDate.setError("Expiry Date of card is Required!!!");
            ExpDate.requestFocus();
            return;
        }
        if (cardCvv.isEmpty()) {
            cvv.setError("Cvv is Required!!!");
            cvv.requestFocus();
            return;
        }
        if(cardCvv.length() != 3){
            cvv.setError("Enter valid CVV!!!");
            cvv.requestFocus();
            return;
        }
        startActivity(new Intent(CheckoutActivity.this,MainActivity.class));
    }
}