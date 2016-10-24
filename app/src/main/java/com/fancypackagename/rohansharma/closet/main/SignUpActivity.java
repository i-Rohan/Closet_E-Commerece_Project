package com.fancypackagename.rohansharma.closet.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fancypackagename.rohansharma.closet.R;

public class SignUpActivity extends AppCompatActivity {
    EditText name, email, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        overridePendingTransition(R.anim.zoom_in, R.anim.out);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
    }

    public void onClickSignUp(View v) {

    }
}
