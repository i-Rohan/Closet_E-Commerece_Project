package com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fancypackagename.rohansharma.closet.R;

/**
 * Created by Rohan Sharma on 13-07-2016.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName, price,quantity;
    public ImageView productImage;
    public Button button;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        productImage = (ImageView) itemView.findViewById(R.id.product_image);
        price = (TextView) itemView.findViewById(R.id.price);
        quantity =(TextView) itemView.findViewById(R.id.quantity);
        button = (Button) itemView.findViewById(R.id.button);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = ((Activity) context).getIntent();
//        intent.putExtra("index", getAdapterPosition() + 1);
//        context.startActivity(intent);

//          Intent intent = new Intent(context, ProductActivity.class);
//        intent.putExtra("productId", allProducts.get(getAdapterPosition()).getProductId());
//        context.startActivity(intent);
    }
}
