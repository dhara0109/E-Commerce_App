package com.example.dhara_parmar_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView imageDetail;
    TextView nameDetails, priceDetails, flavorDetails;
    Button cartBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageDetail = findViewById(R.id.imageDetail);
        nameDetails = findViewById(R.id.nameDetails);
        priceDetails = findViewById(R.id.priceDetails);
        flavorDetails = findViewById(R.id.flavorDetails);
        cartBtn = findViewById(R.id.cartBtn);

        Intent getDetails = getIntent();
        imageDetail.setImageResource(getDetails.getIntExtra("image",R.drawable.cookie));
        nameDetails.setText(getDetails.getStringExtra("name"));
        priceDetails.setText(getDetails.getStringExtra("price"));
        flavorDetails.setText(getDetails.getStringExtra("flavor"));
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addCart = new Intent(DetailActivity.this,CartActivity.class);
                addCart.putExtra("CartName",getDetails.getStringExtra("name"));
                addCart.putExtra("CartImage",getDetails.getIntExtra("image",R.drawable.cookie));
                addCart.putExtra("CartPrice",getDetails.getStringExtra("price"));
                startActivity(addCart);
            }
        });


    }
}