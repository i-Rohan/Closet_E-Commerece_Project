package com.fancypackagename.rohansharma.closet.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.fancypackagename.rohansharma.closet.R;
import com.fancypackagename.rohansharma.closet.commons.AppCommons;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SignInActivity extends AppCompatActivity {
    EditText email, password;
    ImageView closet;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        closet = (ImageView) findViewById(R.id.closet);
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        SharedPreferences sharedPreferences = getSharedPreferences("SignIn", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("signedIn", false)) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }


        YoYo.with(Techniques.SlideInUp)
                .duration(1000)
                .playOn(findViewById(R.id.closet));
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

    protected void login() {
        String url = AppCommons.API_URL + "login";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("login", response);
                        pDialog.dismissWithAnimation();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("result").equals("success")) {
                                SharedPreferences.Editor editor = getSharedPreferences("SignIn", MODE_PRIVATE).edit();
                                editor.putBoolean("signedIn", true);
                                editor.putString("productName", jsonObject.getString("productName"));
                                editor.putString("email", email.getText().toString().trim());
                                editor.apply();
                                SweetAlertDialog success = new SweetAlertDialog(SignInActivity.this,
                                        SweetAlertDialog.SUCCESS_TYPE);
                                success.setTitleText("Welcome!");
                                success.setContentText(jsonObject.getString("productName"));
                                success.setConfirmText("Continue");
                                success.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                                        finish();
                                    }
                                });
                                success.showCancelButton(false);
                                success.setCancelable(false);
                                success.setCanceledOnTouchOutside(false);
                                success.show();
                            } else {
                                SweetAlertDialog warning = new SweetAlertDialog(SignInActivity.this,
                                        SweetAlertDialog.WARNING_TYPE);
                                warning.setTitleText("Incorrect Credentials!");
                                warning.setContentText("Please check spellings and try again.");
                                warning.setConfirmText("Okay");
                                warning.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.dismissWithAnimation();
                                    }
                                });
                                warning.showCancelButton(false);
                                warning.setCancelable(true);
                                warning.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                            SweetAlertDialog error1 = new SweetAlertDialog(SignInActivity.this,
                                    SweetAlertDialog.ERROR_TYPE);
                            error1.setTitleText("Connection Problem!");
                            error1.setContentText("Please check connection and try again.");
                            error1.setConfirmText("Okay");
                            error1.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismissWithAnimation();
                                }
                            });
                            error1.showCancelButton(false);
                            error1.setCancelable(true);
                            error1.show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("login", "error");
                        pDialog.dismissWithAnimation();

                        SweetAlertDialog error2 = new SweetAlertDialog(SignInActivity.this,
                                SweetAlertDialog.ERROR_TYPE);
                        error2.setTitleText("Connection Problem!");
                        error2.setContentText("Please check connection and try again.");
                        error2.setConfirmText("Okay");
                        error2.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                            }
                        });
                        error2.showCancelButton(false);
                        error2.setCancelable(true);
                        error2.show();
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
        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
    }
}
