package com.example.appcoffee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appcoffee.R;
import com.example.appcoffee.model.Product;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

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

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load("https://lh3.googleusercontent.com/s5ecXrgDkTQvJzbZDKdLY322GBfobtMMy_i8e5Jo0ONn7ADK2BfXOGK75bVDpij-Uf3svWsas_UPfQBrzL2vPZPy1MinVxK8CA=w1600-rj")
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvType, tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = (ImageView)itemView.findViewById(R.id.iv_item_drink);
            tvName = (TextView)itemView.findViewById(R.id.tv_name_item_drink);
            tvType = (TextView)itemView.findViewById(R.id.tv_type_item_drink);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_price_item_drink);
        }
    }
}