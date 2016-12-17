package com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public static List<GridViewItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<GridViewItemObject> itemList) {
        RecyclerViewAdapter.itemList = itemList;
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
        holder.productName.setText(itemList.get(position).getProductName().length() >= 15 ? itemList.get(position).getProductName().substring(0, 15) + "..." : itemList.get(position).getProductName());
        holder.price.setText("₹ " + itemList.get(position).getPrice());
        Picasso.with(context)
                .load(AppCommons.PUBLIC_URL + itemList.get(position).getImage().replaceAll("\\s", "%20"))
                .placeholder(R.drawable.placeholder_588_588)   // optional
//                .error(R.drawable.error)      // optional
//                .resize(50, 50)                        // optional
                .into(holder.productImage);
        holder.button.setText(itemList.get(position).getButton());
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }
}