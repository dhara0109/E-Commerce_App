package com.example.dhara_parmar_project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    ArrayList<Product> products = new ArrayList<>();

//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef = database.getReference("Products");


    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ProductAdapter(products);
        recyclerView.setAdapter(mAdapter);

        Product cake = new Product("dolphin", "Dolphin", "Vanilla", "50");
        Product pastry = new Product("pastries", "Chocolate Pastry", "chocolate", "20");
        Product cookie = new Product("cookie","Chocolate Chunk","Chocolate","8");
        Product donut = new Product("donuts","Donut","Milk Chocolate","5.60");
        Product cupcake = new Product("cupcakes","Strawberry Cupcake","Strawberry","8.99");
        Product muffin = new Product("muffine","Double Chocolate","Dark Chocolate","4.99");
        Product pie = new Product("pie","Blueberry Pie","Blueberry","14.99");
        Product croissant = new Product("croissant","Butter Croissant","Roasted Butter","18.99");

        products.add(cake);
        products.add(pastry);
        products.add(cookie);
        products.add(donut);
        products.add(cupcake);
        products.add(muffin);
        products.add(pie);
        products.add(croissant);






//           myRef.addValueEventListener(new ValueEventListener() {
//           @Override
//           public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//               for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                   products.add(new Product(dataSnapshot.child("image").getValue(String.class),
//                           dataSnapshot.child("name").getValue(String.class),
//                           dataSnapshot.child("flavor").getValue(String.class),
//                           dataSnapshot.child("price").getValue(String.class)));
//               }
//               mAdapter.notifyDataSetChanged();
//           }
//
//           @Override
//           public void onCancelled(@NonNull DatabaseError error) {
//
//           }
//       });

    }
}