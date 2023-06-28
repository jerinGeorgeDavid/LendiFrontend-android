package com.jaydee.lendi.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListToGiveAdapter extends RecyclerView.Adapter<ListToGiveAdapter.ListToGiveViewHolder>{
    @NonNull
    @Override
    public ListToGiveAdapter.ListToGiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListToGiveAdapter.ListToGiveViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ListToGiveViewHolder extends RecyclerView.ViewHolder{

        public ListToGiveViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
