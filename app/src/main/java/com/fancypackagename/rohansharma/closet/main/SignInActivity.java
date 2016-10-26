package com.fancypackagename.rohansharma.closet.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SignInActivity extends AppCompatActivity {
    EditText email, password;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        overridePendingTransition(R.anim.zoom_in, R.anim.out);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    public void onClickLogin(View v) {
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Cannot be blank!");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
            email.setError("Invalid Email!");
            return;
        }
        if (password.getText().toString().length() < 8) {
            password.setError("At least 8 characters required!");
            return;
        }

        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.setTitleText("Signing In...");
        pDialog.setContentText("Please Wait");
        pDialog.setCancelable(false);
        pDialog.show();

        login();
    }

    public void onClickFacebookLogin(View v) {

    }

    protected void login() {
        String url = AppCommons.API_URL + "login";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("login", response);
                        pDialog.dismissWithAnimation();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("login", "error");
                        pDialog.dismissWithAnimation();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email.getText().toString().trim());
                params.put("password", password.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void onClickSkip(View v) {

    }
}
