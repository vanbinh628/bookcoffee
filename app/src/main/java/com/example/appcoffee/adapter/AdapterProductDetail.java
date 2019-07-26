package com.example.appcoffee.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appcoffee.R;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.view.activity.ActivityBottomMenu;
import com.example.appcoffee.view.activity.ActivityOrderDetail;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class AdapterProductDetail extends RecyclerView.Adapter<AdapterProductDetail.ViewHolder> {
    Context context;
    List<Product> arrayList;

    public AdapterProductDetail(Context context, List<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_drink, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvPrice.setText(String.valueOf(arrayList.get(position).getPrice()));

        if(arrayList.get(position).getImg_url().trim().equals("") != true){
            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(arrayList.get(position).getImg_url())
                    .error(R.drawable.no_image)
                    .into(holder.ivImage);
        }
        else {
            holder.ivImage.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivImage,ivAdd;
        TextView tvName, tvType, tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = (ImageView)itemView.findViewById(R.id.iv_item_drink);
            tvName = (TextView)itemView.findViewById(R.id.tv_name_item_drink);
            tvType = (TextView)itemView.findViewById(R.id.tv_type_item_drink);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_price_item_drink);
            ivAdd = (ImageView)itemView.findViewById(R.id.iv_add_item_drink);
            ivAdd.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getPosition();
//
//            Intent intent = new Intent(context, ActivityOrderDetail.class);
//            Product product = arrayList.get(position);
//            intent.putExtra("Hello", product);
            ActivityBottomMenu activityOrderDetail = (ActivityBottomMenu)context;
            activityOrderDetail.SendProduct(arrayList.get(position));
        }
    }
}