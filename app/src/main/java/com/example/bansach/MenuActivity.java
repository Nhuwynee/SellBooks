package com.example.bansach;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.Fragment.AccountFragment;
import com.example.bansach.Fragment.CartFragment;
import com.example.bansach.Fragment.HomeFragment;
import com.example.bansach.Fragment.ListAudioBookFragment;
import com.example.bansach.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // Đảm bảo layout này chứa BottomNavigationView
        frameLayout = findViewById(R.id.container);
        if (savedInstanceState == null )
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_cart) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new CartFragment()).commit();
                }
                if (id == R.id.navigation_audio) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListAudioBookFragment()).commit();
                }
                else if (id == R.id.navigation_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                }
                else if (id == R.id.navigation_search) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                }
                else if ( id == R.id.navigation_account){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new AccountFragment()).commit();
                }
                return true;
            }
        });
    }
}
