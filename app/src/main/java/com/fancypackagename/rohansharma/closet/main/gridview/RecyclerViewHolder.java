package com.fancypackagename.rohansharma.closet.main.gridview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fancypackagename.rohansharma.closet.R;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName, price;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        price = (TextView) itemView.findViewById(R.id.price);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = ((Activity) context).getIntent();
//        intent.putExtra("index", getAdapterPosition() + 1);
//        context.startActivity(intent);
    }
}
