package com.example.appcoffee.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcoffee.R;
import com.example.appcoffee.model.Config;

import java.util.List;

public class AdapterConfigSingle extends RecyclerView.Adapter<AdapterConfigSingle.ViewHolder> {
    Context context;
    List<Config> configList;

    public AdapterConfigSingle(Context context, List<Config> configList) {
        this.context = context;
        this.configList = configList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_config, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Config config = configList.get(position);
        if(config.getName() != "" && config.getName() != null ){
            holder.tvName.setText(configList.get(position).getName());
        }
        else {
            if(config.getPercent() != null){
                int percent = (int)(configList.get(position).getPercent()*100);
                String string =String.valueOf(percent)+"%";
                holder.tvName.setText(string);
            }
        }
        if(config.getPrice() != 0 && config.getPrice() != null){
            holder.tvPrice.setText(config.getPrice().toString());
        }
        if(config.getCheck() != null)
            holder.cbConfig.setChecked(config.getCheck());

    }

    @Override
    public int getItemCount() {
        Log.d("InRa",String.valueOf(configList.size()));
        return configList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvPrice;
        CheckBox cbConfig;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_item_config);
            tvPrice = itemView.findViewById(R.id.tv_price_item_config);
            cbConfig = itemView.findViewById(R.id.cb_item_config);
            cbConfig.setOnClickListener(this);
            configList.get(0).setCheck(true);
        }

        @Override
        public void onClick(View view) {
           int position = this.getPosition();
           configList.get(position).setCheck(true);
           for(int i=0; i<configList.size(); i++){
               if(i != position)
                   configList.get(i).setCheck(false);
           }
            notifyDataSetChanged();
        }
    }
}
