package com.exod.zoomed;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.fragment_account:
                    loadFragment(new AccountFragment());
                    break;
                case R.id.fragment_setting:
                    loadFragment(new SettingFragment());
                    break;
                case R.id.fragment_command:
                    loadFragment(new CommandFragment());
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new AccountFragment());
        BottomNavigationItemView navigation = findViewById(R.id.nav_view);
        navigation.setOnClickListener(onNavigationItemSelectedListener); //setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
                    return true;
        }
        return  false;
    }
}
