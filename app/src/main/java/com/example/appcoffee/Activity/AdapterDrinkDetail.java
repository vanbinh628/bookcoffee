package com.example.appcoffee.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.Model.DrinkDetail;
import com.example.appcoffee.R;

import java.util.ArrayList;

public class AdapterDrinkDetail extends RecyclerView.Adapter<AdapterDrinkDetail.ViewHolder> {
    Context context;
    ArrayList<DrinkDetail> arrayList;

    public AdapterDrinkDetail(Context context, ArrayList<DrinkDetail> arrayList) {
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
        holder.ivImage.setImageResource(arrayList.get(position).getImage());
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvType.setText(arrayList.get(position).getType());
        holder.tvPrice.setText(arrayList.get(position).getPrice());

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
