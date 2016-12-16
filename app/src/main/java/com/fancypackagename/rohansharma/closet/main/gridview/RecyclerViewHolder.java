package com.fancypackagename.rohansharma.closet.main.gridview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.main.ProductActivity;

import static com.fancypackagename.rohansharma.closet.main.HomeActivity.allProducts;
import static com.fancypackagename.rohansharma.closet.main.HomeActivity.context;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName, price;
    public ImageView productImage;
    public Button button;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        productImage = (ImageView) itemView.findViewById(R.id.product_image);
        price = (TextView) itemView.findViewById(R.id.price);
        button = (Button) itemView.findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = ((Activity) context).getIntent();
//        intent.putExtra("index", getAdapterPosition() + 1);
//        context.startActivity(intent);

        Intent intent = new Intent(context, ProductActivity.class);
        intent.putExtra("productId", allProducts.get(getAdapterPosition()).getProductId());
        context.startActivity(intent);
    }
}
