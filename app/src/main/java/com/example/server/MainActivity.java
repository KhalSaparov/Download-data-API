package com.example.server;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Post post;
    Handler handler = new Handler();
    private long onHiddenTime;
    private Toast bakeToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentChange(1);
        handler.postDelayed(new Runnable() {
            public void run() {
               fragmentChange(0);
            }
        }, 3000);
    }

    public void fragmentChange (int i) {
        Fragment fragment;
        switch (i){
            case 1:
                fragment = new Fragment_Hello();
                break;
            case 2:
                fragment = new Fragment_Info();
                break;
            default:
                fragment = new Fragment_Data();

        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_main, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (onHiddenTime + 2000 > System.currentTimeMillis()){
            bakeToast.cancel();
            super.onBackPressed();
            return;
        } else {
            bakeToast = Toast.makeText(getBaseContext(), "Click double", Toast.LENGTH_SHORT);
            bakeToast.show();
            fragmentChange(0);
        }
        onHiddenTime = System.currentTimeMillis();
    }
}
