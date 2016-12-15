package com.fancypackagename.rohansharma.closet.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.fancypackagename.rohansharma.closet.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                super.onBackPressed();
//                break;
//            case R.id.edit_profile:
//                startActivity(new Intent(this, EditDetailsActivity.class));
//                break;
//            case R.id.change_password:
//                startActivity(new Intent(this, ChangePasswordActivity.class));
//                break;
//            case R.id.add_cont_acc:
//                startActivity(new Intent(this, AddContractAccActivity.class));
//                break;
//        }
//        return true;
//    }
}
