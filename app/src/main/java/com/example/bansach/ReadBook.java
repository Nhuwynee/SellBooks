package com.example.bansach;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.Fragment.ViewBookFragment;

public class ReadBook extends AppCompatActivity {

    private TextView tvBookTitle, tvSampleContent;
    private ImageView imgBookCover;
    private Button btnBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readbook);

        tvBookTitle = findViewById(R.id.tvBookTitle);
        tvSampleContent = findViewById(R.id.tvSampleContent);
        imgBookCover = findViewById(R.id.imgBookCover);
        btnBuyNow = findViewById(R.id.btnBuyNow);

        // Đặt dữ liệu cho các view (từ API hoặc intent)
        tvBookTitle.setText("Hồng lục");  // Ví dụ cho tiêu đề sách
        tvSampleContent.setText("Hồng Lục kể về cuộc đời của nhân vật chính là Hồng Lục, một thanh niên yêu nước, giàu tình cảm và luôn khao khát tự do. Tuy nhiên, cuộc sống của Hồng Lục lại đầy bi kịch và thử thách. Anh là một người có tư tưởng tiến bộ, nhưng lại phải sống trong một xã hội phong kiến lạc hậu, nơi mà những giá trị nhân đạo bị chà đạp và tiếng nói của cá nhân bị coi thường.");
        imgBookCover.setImageResource(R.drawable.hong_luc);

        // Xử lý sự kiện khi người dùng nhấn nút "Mua sách"
        btnBuyNow.setOnClickListener(v -> {
           startActivity(new Intent(ReadBook.this, ViewBookFragment.class));
        });
    }
}