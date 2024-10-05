package com.example.bansach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ViewBookMain extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Tạo danh sách các fragment
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AboutFragment());
        fragmentList.add(new ReviewsFragment());
        fragmentList.add(new AuthorFragment());

        // Tạo adapter cho ViewPager2
        adapter = new ViewPagerAdapter(this, fragmentList);
        viewPager.setAdapter(adapter);

        // Liên kết TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("About");
                        break;
                    case 1:
                        tab.setText("Reviews");
                        break;
                    case 2:
                        tab.setText("Author");
                        break;
                }
            }
        }).attach();
    }
}