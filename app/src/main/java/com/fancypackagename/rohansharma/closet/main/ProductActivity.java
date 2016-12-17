package com.fancypackagename.rohansharma.closet.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductActivity extends AppCompatActivity {

    String productId, productName, sellerName, info, price, images[], type, condition;
    CarouselView customProduct;
    TextView pname, sname, pprice, pinfo, pcondition;
    Button ptype;
    LinearLayout ll;
    RelativeLayout rl;
    // To set simple images
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.with(getApplicationContext()).load(AppCommons.PUBLIC_URL + images[position].replaceAll("\\s", "%20")).into(imageView);
            //imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent i = getIntent();
        if (i != null)
            productId = i.getStringExtra("productId");

        getProductsInfo(productId);

        pname = (TextView) findViewById(R.id.name);
        sname = (TextView) findViewById(R.id.sname);
        pinfo = (TextView) findViewById(R.id.info);
        pprice = (TextView) findViewById(R.id.pprice);
        ptype = (Button) findViewById(R.id.type);
        pcondition = (TextView) findViewById(R.id.condition);
        customProduct = (CarouselView) findViewById(R.id.customProduct);
        ll = (LinearLayout) findViewById(R.id.ll);
        rl = (RelativeLayout) findViewById(R.id.rl);

        customProduct.setSlideInterval(4000);
        // set ViewListener for custom view
        customProduct.setImageListener(imageListener);
    }

    void getProductsInfo(String id) {
        String url = AppCommons.API_URL + "get_product_info?id=" + id;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Home", response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            productName = jsonObject.getString("ProductName");
                            sellerName = jsonObject.getString("SellerName");
                            info = jsonObject.getString("Information");
                            price = jsonObject.getString("Price");
                            type = jsonObject.getString("Type");
                            condition = jsonObject.getString("Condition");
                            JSONArray jsonArray = jsonObject.getJSONArray("Images");
                            images = new String[jsonArray.length()];
                            Log.d("LOD", jsonObject.getString("Images"));

                            pname.setText(productName);
                            sname.setText(sellerName);
                            pprice.setText("₹" + price);
                            pinfo.setText(info);
                            pcondition.setText("Condition:" + condition);
                            ptype.setText(type);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                images[i] = jsonArray.getString(i);
                            }

                            customProduct.setPageCount(images.length);

                            type = jsonObject.getString("Type");
                            condition = jsonObject.getString("Condition");

                            ll.setVisibility(View.GONE);
                            rl.setVisibility(View.VISIBLE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Home", "error");

                        Toast.makeText(ProductActivity.this, "Connection problem! :(",
                                Toast.LENGTH_SHORT).show();

                        ll.setVisibility(View.GONE);
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(ProductActivity.this);
        requestQueue.add(stringRequest);
    }
}