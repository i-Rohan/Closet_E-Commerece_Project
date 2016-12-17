package com.fancypackagename.rohansharma.closet.main;

import android.content.SharedPreferences;
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

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Cart> allItems;
    boolean empty = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        SharedPreferences sharedPreferences = getSharedPreferences("SignIn", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        getCartInfo(email);
    }

    void getCartInfo(String email) {
        String url = AppCommons.API_URL + "get_product_info?id=" + email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Home", response);

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            allItems = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                allItems.add(new Cart(jsonObject.getString("ProductName"),
                                        jsonObject.getString("SellerName"),
                                        jsonObject.getString("Size"),
                                        jsonObject.getString("Color"),
                                        jsonObject.getInt("Quantity"),
                                        jsonObject.getDouble("Price")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                            empty = true;
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Home", "error");

                        Toast.makeText(CartActivity.this, "Connection problem! :(",
                                Toast.LENGTH_SHORT).show();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(CartActivity.this);
        requestQueue.add(stringRequest);
    }
}