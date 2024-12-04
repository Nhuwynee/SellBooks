package com.example.bansach.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bansach.R;
import com.example.bansach.model.Book;
import com.google.android.material.tabs.TabLayout;

public class ViewBookAudioFragment extends Fragment {

    FrameLayout frameLayout;
    TabLayout tabLayout;
    ViewFlipper viewFlipper;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_viewbooks_audio, container, false);
        viewFlipper = view.findViewById(R.id.viewflipper1);
        ImageButton cart = view.findViewById(R.id.btn_cart);
        ImageButton like =view.findViewById(R.id.btn_favourite_book);
        addImagesToFlipper();

        if (getArguments() != null) {
            Book book = (Book) getArguments().getSerializable("book");
        }

        frameLayout = view.findViewById(R.id.framelayout_audio);
        tabLayout = view.findViewById(R.id.tablayout);

        // Khởi tạo fragment mặc định
        getParentFragmentManager().beginTransaction().replace(R.id.framelayout_audio, new AboutAudioFragment())
                .addToBackStack(null)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new AboutAudioFragment();
                        break;
                    case 1:
                        fragment = new ReviewAudioFragment();
                        break;
                    case 2:
                        fragment = new AuthorAudioFragment();
                        break;
                }

                if (fragment != null) {
                    getParentFragmentManager().beginTransaction().replace(R.id.framelayout_audio, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Có thể để trống hoặc thực hiện một số hành động khi tab không được chọn nữa
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Có thể để trống hoặc thực hiện một số hành động khi tab đã được chọn lại
            }
        });


        // Sự kiện nút yêu thích sách
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Fragment khác
                MessageFavouriteBookFragment newFragment = new MessageFavouriteBookFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Fragment khác
                CartFragment newFragment = new CartFragment();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container, newFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view; // Trả về view
    }

    private void addImagesToFlipper() {
        try {
            int[] images = {R.drawable.hongluc, R.drawable.hongluc}; // Thay đổi tên hình ảnh theo thực tế

            for (int image : images) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                viewFlipper.addView(imageView);
            }
            viewFlipper.setFlipInterval(2000);
            viewFlipper.setAutoStart(true);
            viewFlipper.startFlipping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
