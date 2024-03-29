package com.example.appcoffee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.model.ProductOrder;
import com.example.appcoffee.view.HandleOrderItems;

import java.util.List;

public class AdapterUserCart extends RecyclerView.Adapter<AdapterUserCart.ViewHolder> {
    private HandleOrderItems mHandleOrderItems;
    private Context mContext;
    private List<ProductOrder> mListProductOrder;

    public AdapterUserCart(Context mContext, List<ProductOrder> listProductOrder, HandleOrderItems handleOrderItems) {
        this.mContext = mContext;
        this.mListProductOrder = listProductOrder;
        this.mHandleOrderItems = handleOrderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.item_order_confirm, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSTT.setText(String.valueOf(position + 1));
        holder.tvName.setText(mListProductOrder.get(position).getName());
        holder.tvPrice.setText(String.valueOf(mListProductOrder.get(position).getTotal()));
    }

    @Override
    public int getItemCount() {
        return mListProductOrder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvSTT, tvPrice, tvEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_order_confirm);
            tvSTT = itemView.findViewById(R.id.tv_stt_order_confirm);
            tvPrice = itemView.findViewById(R.id.tv_price_order_confirm);
            tvEdit = itemView.findViewById(R.id.tv_edit_order_confirm);

            tvEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getPosition();
                    mHandleOrderItems.showDialogUpdate(position);
                }
            });
        }
    }
}
