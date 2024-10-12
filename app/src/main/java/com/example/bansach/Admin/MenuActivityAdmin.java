package com.example.bansach.Admin;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.Fragment.AccountFragment;
import com.example.bansach.Fragment.SearchFragment;
import com.example.bansach.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuActivityAdmin extends AppCompatActivity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin); // Đảm bảo layout này chứa BottomNavigationView
        frameLayout = findViewById(R.id.container_admin);
        if (savedInstanceState == null )
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_admin, new AddBookFragment()).commit();
        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_add_book) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_admin, new AddBookFragment()).commit();
                }
                else if (id == R.id.navigation_list_books) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_admin, new ListViewBookFragment()).commit();
                }
                else if (id == R.id.navigation_orders) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_admin, new ListInvoiceFragment()).commit();
                }
                else if ( id == R.id.navigation_account){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_admin, new AccountActivityAdmin()).commit();
                }
                return true;
            }
        });
    }
}
