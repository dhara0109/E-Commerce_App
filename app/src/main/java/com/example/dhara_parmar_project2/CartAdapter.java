package com.example.dhara_parmar_project2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{

     ArrayList<Cart> mCartList;
    public CartAdapter(ArrayList<Cart> cart){

        mCartList = cart;
    }



    @NonNull
    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MyViewHolder holder, int position) {

        Cart c = mCartList.get(position);

        Context actContext = holder.itemView.getContext();
        int resid1 = actContext.getResources().getIdentifier(c.getCartImage(),"drawable",actContext.getPackageName());


        holder.CartImage.setImageResource(resid1);
        holder.CartName.setText(c.getCartName());
        holder.CartPrice.setText(c.getCartPrice());
       // holder.DefaultValue.setText(c.getCartDefault());
        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getItemCount = holder.DefaultValue.getText().toString();
                int getItemCountInt = Integer.parseInt(getItemCount) + 1;
                holder.DefaultValue.setText(String.valueOf(getItemCountInt));
//                int getPriceValue = (Integer.parseInt(c.getCartPrice()) * getItemCountInt);
//                holder.CartPrice.setText(String.valueOf(getPriceValue));
            }
        });

        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(holder.DefaultValue.getText().toString()) > 1) {
                    String getItemCount = holder.DefaultValue.getText().toString();
                    int getItemCountInt = Integer.parseInt(getItemCount) - 1;
                    holder.DefaultValue.setText(String.valueOf(getItemCountInt));
//                    int getPriceValue = (Integer.parseInt(c.getCartPrice()) * getItemCountInt);
//                    holder.CartPrice.setText(String.valueOf(getPriceValue));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCartList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        TextView CartName;
        TextView CartPrice;
        EditText DefaultValue;
        ImageView CartImage;
        Button decrement;
        Button increment;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.cart_item, parent, false));
            CartName = itemView.findViewById(R.id.NameCart);
            CartPrice = itemView.findViewById(R.id.PriceCart);
            DefaultValue = itemView.findViewById(R.id.defaultValue);
            CartImage = itemView.findViewById(R.id.ImageCart);
            decrement = itemView.findViewById(R.id.decrement);
            increment = itemView.findViewById(R.id.increment);
        }
    }

}

