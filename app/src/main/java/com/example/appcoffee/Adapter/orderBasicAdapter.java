package com.example.appcoffee.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.Model.orderBasic;
import com.example.appcoffee.R;

import java.util.ArrayList;

public class orderBasicAdapter extends RecyclerView.Adapter<orderBasicAdapter.ViewHolder> {
    ArrayList<orderBasic> dataOrder;
    Context context;

    public orderBasicAdapter(ArrayList<orderBasic> dataOrder, Context context) {
        this.dataOrder = dataOrder;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());//LayoutInflater  giúp bạn chuyển layout file (xml) thành view (java code)
        View itemView = layoutInflater.inflate(R.layout.item_order_progress,parent,false);
        //có 3 tham số
        //resource nơi chứa file xml
        //viewgroup parent là view group nơi mà xml layout file có thể được nhúng vào.( parrent chứa recycleview)
        // attachToRoot=true or bằng false

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//đổ data vào view
        holder.tvNumber.setText(String.valueOf(dataOrder.get(position).getNumber()));
        holder.tvNameInfo.setText(dataOrder.get(position).getName());
        holder.tvPrice.setText(dataOrder.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return dataOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {//giúp ta ánh xạ chúng
        TextView tvNumber;
        TextView tvNameInfo;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = (TextView)itemView.findViewById(R.id.item_order_number);
            tvNameInfo = (TextView)itemView.findViewById(R.id.item_order_name_info);
            tvPrice = (TextView)itemView.findViewById(R.id.item_order_price);

        }
    }
}
