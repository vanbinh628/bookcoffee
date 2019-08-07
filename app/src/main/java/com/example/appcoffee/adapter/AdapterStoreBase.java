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
import com.example.appcoffee.model.Store;
import com.example.appcoffee.view.HandleStore;

import java.lang.reflect.Array;
import java.util.List;

public class AdapterStoreBase extends RecyclerView.Adapter<AdapterStoreBase.ViewHolder> {
    private Context mContext;
    private List<Store> mListStore;
    HandleStore mHandleStore;

    public AdapterStoreBase(Context mContext, List<Store> mListStore, HandleStore handleStore) {
        this.mContext = mContext;
        this.mListStore = mListStore;
        this.mHandleStore = handleStore;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.item_dialog_change_store, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(mListStore.get(position).getName());
        holder.tvAddress.setText(mListStore.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return mListStore.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvFar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_store_item_dialog);
            tvAddress = itemView.findViewById(R.id.tv_address_store_item_dialog);
            tvFar = itemView.findViewById(R.id.tv_far_store_item_dialog);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getPosition();

                    mHandleStore.chooseStore(mListStore.get(position));
                }
            });
        }
    }
}
