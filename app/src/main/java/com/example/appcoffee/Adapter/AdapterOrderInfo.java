package com.example.appcoffee.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.Model.OrderInfor;
import com.example.appcoffee.R;

import java.util.ArrayList;

public class AdapterOrderInfo extends RecyclerView.Adapter<AdapterOrderInfo.ViewHolder> {
    Context context;
    ArrayList<OrderInfor> arrayList;

    public AdapterOrderInfo(Context context, ArrayList<OrderInfor> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_order_infor, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvAddress.setText(arrayList.get(position).getAddress());
        holder.tvDatetime.setText(arrayList.get(position).getDate());
        holder.tvPrice.setText(arrayList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvDatetime, tvPrice;
        LinearLayout viewColor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name_item_info);
            tvAddress = (TextView)itemView.findViewById(R.id.tv_address_item_info);
            tvDatetime = (TextView)itemView.findViewById(R.id.tv_datetime_item_info);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_price_item_info);

            viewColor = (LinearLayout)itemView.findViewById(R.id.view_color_item_info);


        }
    }
}
