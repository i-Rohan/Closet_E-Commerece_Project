package com.fancypackagename.rohansharma.closet.main.gridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fancypackagename.rohansharma.closet.R;

import java.util.List;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<GridViewItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<GridViewItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_home,
                null);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.productName.setText(itemList.get(position).getProductName());
        holder.price.setText(itemList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}