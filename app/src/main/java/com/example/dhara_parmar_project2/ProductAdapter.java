package com.example.dhara_parmar_project2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {


    private ArrayList<Product> mproductList;

    public ProductAdapter(ArrayList<Product> product){

        this.mproductList = product;

    }


    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {

        Product p = mproductList.get(position);

        Context actContext = holder.itemView.getContext();
        int resid = actContext.getResources().getIdentifier(p.getImage(),"drawable",actContext.getPackageName());

        holder.name.setText(p.getName());
//        Glide.with(this).load("http://goo.gl/gEgYUd").into(p.getImage());
        holder.image.setImageResource(resid);
        holder.flavor.setText("Flavor: "+p.getFlavor());
        holder.price.setText("Price: $"+p.getPrice());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent putDetails = new Intent(view.getContext(),DetailActivity.class);
                putDetails.putExtra("name",p.getName());
                putDetails.putExtra("flavor",""+p.getFlavor());
                putDetails.putExtra("price","$"+p.getPrice());
                putDetails.putExtra("image",resid);
                view.getContext().startActivity(putDetails);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mproductList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView flavor;
        TextView price;
        ImageView image;
        CardView cardView;


        public MyViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.row_layout, parent, false));
            name = itemView.findViewById(R.id.name);
            flavor = itemView.findViewById(R.id.flavor);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
        }



    }
}
