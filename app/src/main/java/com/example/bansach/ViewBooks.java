package com.example.bansach;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class ViewBooks extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayout;
    // private Button btnAbout, btnReview, btnAuthor;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.viewbooks_main);
        addImagesToFlipper();

        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new AboutFragment())
                .addToBackStack(null)
                .commit();


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new AboutFragment();
                        break;
                    case 1:
                        fragment = new ReviewFragment();
                        break;
                    case 2:
                        fragment = new AuthorFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void addImagesToFlipper() {
        viewFlipper = findViewById(R.id.viewflipper);
        try {
            int[] images = {R.drawable.hong_luc, R.drawable.hong_luc_2};

            for (int image : images) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(2000);
            viewFlipper.setAutoStart(true); // Bắt đầu tự động
            viewFlipper.startFlipping(); // Bắt đầu lật ảnh
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



//        btnAbout = findViewById(R.id.btn_about);
//        btnReview = findViewById(R.id.btn_review);
//        btnAuthor = findViewById(R.id.btn_author);
//
//        btnAbout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("ViewBooks", "Button About clicked, loading Fragment1");
//                replaceFragmentContent(new Fragment1());
//            }
//        });
//
//        btnReview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("ViewBooks", "Button Review clicked, loading Fragment2");
//                replaceFragmentContent(new Fragment2());
//            }
//        });
//
//        btnAuthor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("ViewBooks", "Button Author clicked, loading Fragment3");
//                replaceFragmentContent(new Fragment3());
//            }
//        });
//
//        if (savedInstanceState == null) {
//            replaceFragmentContent(new Fragment1());
//        }
//    }
//
//    private void replaceFragmentContent(Fragment fragment) {
//        if (fragment != null) {
//
//            FragmentManager fmgr = getSupportFragmentManager();
//            FragmentTransaction ft = fmgr.beginTransaction();
//            ft.replace(R.id.container_body, fragment);
//            ft.addToBackStack(null);
//            ft.commit();
//        }
//    }



