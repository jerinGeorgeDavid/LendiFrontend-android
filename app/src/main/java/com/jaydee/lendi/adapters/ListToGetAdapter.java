package com.jaydee.lendi.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaydee.lendi.R;
import com.jaydee.lendi.model.TransactionL;

import java.util.List;

public class ListToGetAdapter extends RecyclerView.Adapter<ListToGetAdapter.ListToGetViewHolder>{
    public static final String TAG="ListToGetAdapter";
    public List<TransactionL> mData;
    @NonNull
    @Override
    public ListToGetAdapter.ListToGetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview_toget, parent, false);
        return new ListToGetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListToGetAdapter.ListToGetViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: ---->position : "+position);
        holder.tvItemName.setText(mData.get(position).getType());
        holder.tvItemAmount.setText(String.valueOf(mData.get(position).getId()));
       // String.valueOf(mData.get(position).getId());

    }

    @Override
    public int getItemCount() {
        if(mData!=null){
            return mData.size();
        }
      return -1;
    }

    public void setData(List<TransactionL> mdata){
        this.mData=mdata;
        notifyDataSetChanged();
    }


    public static class ListToGetViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemName,tvItemAmount;
        public ListToGetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName=itemView.findViewById(R.id.rvItemName);
            tvItemAmount=itemView.findViewById(R.id.rvItemAmount);
        }
    }
}
