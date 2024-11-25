package com.example.bansach.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.InputStream;
public class ReadBookFragment extends Fragment {

    private TextView tvBookTitle, tvSampleContent, author;
    private ImageView imgBookCover;
    private Button btnBuyNow;

    private static final String ARG_BOOK_ID = "bookId";
    private String bookId;

    public static ReadBookFragment newInstance(String bookId) {
        ReadBookFragment fragment = new ReadBookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_BOOK_ID, bookId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookId = getArguments().getString(ARG_BOOK_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_readbook, container, false);

        // Khởi tạo các view
        tvBookTitle = view.findViewById(R.id.tvBookTitle);
        tvSampleContent = view.findViewById(R.id.tvSampleContent);
        imgBookCover = view.findViewById(R.id.imgBookCover);
        btnBuyNow = view.findViewById(R.id.btnBuyNow);
        author = view.findViewById(R.id.tvAuthorTitle);

        // Gọi API để lấy dữ liệu sách
        if (bookId != null) {
            fetchBookDetails(bookId);
        } else {
            Log.e("ReadBookFragment", "Book ID is null");
        }

        // Xử lý sự kiện khi người dùng nhấn nút "Mua sách"
        btnBuyNow.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, new ViewBookFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    private void fetchBookDetails(String bookId) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);
        Call<Book1> call = apiService.getBookDetails(bookId);

        call.enqueue(new Callback<Book1>() {
            @Override
            public void onResponse(@NonNull Call<Book1> call, @NonNull Response<Book1> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Book1 book = response.body();
                    // Hiển thị dữ liệu từ API lên giao diện
                    tvBookTitle.setText(book.getTitle());
                    author.setText(book.getAuthor());
                    // Xử lý nội dung sách mẫu
                    String sampleContent = book.getSampleRead();
                    if (sampleContent != null && sampleContent.endsWith(".docx")) {
                        // Đọc nội dung từ file .docx trong res/raw
                        int resourceId = getResources().getIdentifier(sampleContent.substring(0, sampleContent.lastIndexOf('.')), "raw", getContext().getPackageName());
                        if (resourceId != 0) {
                            String content = readDocxFromRaw(resourceId);
                            tvSampleContent.setText(content);
                        }
                    } else {
                        tvSampleContent.setText(sampleContent);
                    }

                    String imageName = book.getImgResource();

                    if (imageName.endsWith(".jpg") || imageName.endsWith(".png")) {
                        imageName = imageName.substring(0, imageName.lastIndexOf('.'));
                    }

                    if (getContext() != null) {
                        int resId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

                        if (resId != 0) {
                            Glide.with(getContext()).load(resId).into(imgBookCover);
                        } else {
                            Log.e("ViewBookFragment", "Không tìm thấy resource ảnh cho: " + imageName);
                            imgBookCover.setVisibility(View.GONE);
                        }
                    } else {
                        Log.e("ViewBookFragment", "Context là null");
                    }
                } else {
                    Log.e("ReadBookFragment", "API response unsuccessful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Book1> call, @NonNull Throwable t) {
                Log.e("ReadBookFragment", "API call failed: " + t.getMessage());
            }
        });
    }

    private String readDocxFromRaw(int resourceId) {
        StringBuilder content = new StringBuilder();
        try {
            // Mở file từ res/raw
            InputStream inputStream = getResources().openRawResource(resourceId);
            XWPFDocument document = new XWPFDocument(inputStream);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                content.append(paragraph.getText()).append("\n");
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

