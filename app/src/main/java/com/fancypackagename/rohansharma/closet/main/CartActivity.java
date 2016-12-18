package com.fancypackagename.rohansharma.closet.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;
import com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview.GridViewItemObject;
import com.fancypackagename.rohansharma.closet.main.gridview_cart.gridview.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<GridViewItemObject> allItems;
    boolean empty = false;
    RecyclerView rView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        GridLayoutManager lLayout = new GridLayoutManager(CartActivity.this, 1);

        rView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        SharedPreferences sharedPreferences = getSharedPreferences("SignIn", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        Log.e("email", "" + email);
        getCartInfo(email);
    }

    void getCartInfo(String email) {
        String url = AppCommons.API_URL + "get_cart_info?email=" + email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Cart", response);

                        progressBar.setVisibility(View.GONE);

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            allItems = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                allItems.add(new GridViewItemObject(jsonObject.getString("ProductName"),
                                        jsonObject.getString("SellerName"),
                                        jsonObject.getString("Size"),
                                        jsonObject.getString("Color"),
                                        jsonObject.getInt("Quantity"),
                                        jsonObject.getDouble("Price"),
                                        jsonObject.getString("Image")));
                            }
                            RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(CartActivity.this, allItems);
                            rView.setAdapter(rcAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();

                            empty = true;
                        }
                        if (empty)
                            Toast.makeText(CartActivity.this, "Cart Empty!", Toast.LENGTH_SHORT).show();
                        else
                            rView.setVisibility(View.VISIBLE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Home", "error");

                        progressBar.setVisibility(View.GONE);

                        Toast.makeText(CartActivity.this, "Connection problem! :(",
                                Toast.LENGTH_SHORT).show();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(CartActivity.this);
        requestQueue.add(stringRequest);
    }
}