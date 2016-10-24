package com.fancypackagename.rohansharma.closet.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fancypackagename.rohansharma.closet.R;

public class SignInActivity extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        overridePendingTransition(R.anim.zoom_in, R.anim.out);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    public void onClickLogin(View v) {

    }

    public void onClickFacebookLogin(View v) {

    }

    public void onClickSignUp(View v) {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }
}
