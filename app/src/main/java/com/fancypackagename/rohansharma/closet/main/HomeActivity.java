package com.fancypackagename.rohansharma.closet.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.fancypackagename.rohansharma.closet.R;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    ViewPager pager;
    Timer timer;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        PagerAdapter adapter = new PagerAdapter();

        pager = (ViewPager)findViewById(R.id.vpager);
        assert pager != null;
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= 3) {
                            pager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            pager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 2000, 3000);





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
