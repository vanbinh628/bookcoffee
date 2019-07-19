package com.example.appcoffee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.model.Store;

import java.util.List;

public class AdapterStoreDetail extends RecyclerView.Adapter<AdapterStoreDetail.ViewHolder> {
    Context context;
    List<Store> storeList;

    public AdapterStoreDetail(Context context, List<Store> storeList) {
        this.context = context;
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_order_infor, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(storeList.get(position).getName());
        holder.tvAddress.setText(storeList.get(position).getAddress());
        holder.tvDateTime.setText(storeList.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvDateTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name_item_info);
            tvAddress = itemView.findViewById(R.id.tv_address_item_info);
            tvDateTime = itemView.findViewById(R.id.tv_datetime_item_info);
        }
    }
}
