package com.example.dhara_parmar_project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

//    ImageView ImageCart;
//    TextView NameCart, PriceCart;
//    EditText defaultValue;
//    Button decrement, increment;
    Button CheckoutBtn;
    RecyclerView CartRecyclerView;
    RecyclerView.Adapter mCart;
    ArrayList<Cart> carts = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        ImageCart = findViewById(R.id.ImageCart);
//        NameCart = findViewById(R.id.NameCart);
//        PriceCart = findViewById(R.id.PriceCart);
//        defaultValue = findViewById(R.id.defaultValue);
//        decrement = findViewById(R.id.decrement);
//        increment = findViewById(R.id.increment);


        CartRecyclerView = findViewById(R.id.CartRecyclerView);
        CheckoutBtn = findViewById(R.id.CheckoutBtn);
        CartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCart = new CartAdapter(carts);
        CartRecyclerView.setAdapter(mCart);

        Intent cartGet = getIntent();

        carts.add(new Cart(String.valueOf(cartGet.getIntExtra("CartImage",R.drawable.cookie)),cartGet.getStringExtra("CartName"),cartGet.getStringExtra("CartPrice")));
        CheckoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,CheckoutActivity.class));
            }
        });

    }
}