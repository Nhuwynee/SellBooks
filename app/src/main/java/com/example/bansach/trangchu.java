package com.example.bansach;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;
import android.widget.ViewFlipper;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;



public class trangchu extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_chu);
        addImagesToFlipper();
    }
    private void addImagesToFlipper() {
        viewFlipper = findViewById(R.id.viewflipper);
        try {
            int[] images = {R.drawable.hong_luc, R.drawable.tinh_yeu_cua_thoi_ha, R.drawable.nay_dung_co_an_co, R.drawable.toc_cua_toi};

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
