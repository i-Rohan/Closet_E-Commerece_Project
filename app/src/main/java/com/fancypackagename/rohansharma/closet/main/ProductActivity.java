package com.fancypackagename.rohansharma.closet.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductActivity extends AppCompatActivity {

    String productId, productName, sellerName, info, price, images[], type, condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent i = getIntent();
        if (i != null)
            productId = i.getStringExtra("productId");

        getProductsInfo(productId);
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
                            sellerName = jsonObject.getString("sellerName");
                            info = jsonObject.getString("Information");
                            price = jsonObject.getString("Price");
                            JSONArray jsonArray = jsonObject.getJSONArray("Images");
                            images = new String[jsonArray.length()];
                            for (int i = 0; i < jsonArray.length(); i++)
                                images[i] = jsonArray.getString(i);
                            type = jsonObject.getString("Type");
                            condition = jsonObject.getString("Condition");
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
                    }
                }) {
        };

        RequestQueue requestQueue = Volley.newRequestQueue(ProductActivity.this);
        requestQueue.add(stringRequest);
    }
}