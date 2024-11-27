package com.example.bansach.Fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.bansach.API.APIService;
import com.example.bansach.API.RetrofitClient;
import com.example.bansach.R;
import com.example.bansach.model.Book1;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AudioFragment extends Fragment {

    private ImageButton btnPlayPause, btnPrevious, btnNext;
    private SeekBar seekBar;
    private TextView tvTime, bookName, bookAuthor;
    private ImageView bookImage;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private boolean isPlaying = false;
    private String bookId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_audiobook, container, false);

        // Liên kết giao diện
        btnPlayPause = view.findViewById(R.id.btn_play_pause);
        btnPrevious = view.findViewById(R.id.btn_previous);
        btnNext = view.findViewById(R.id.btn_next);
        seekBar = view.findViewById(R.id.seekBar);
        tvTime = view.findViewById(R.id.tv_time);
        bookName = view.findViewById(R.id.book_name);
        bookAuthor = view.findViewById(R.id.book_author);
        bookImage = view.findViewById(R.id.book_img);

        if (getArguments() != null) {
            bookId = getArguments().getString("bookId");
            Log.d("ViewBookFragment", "Received bookId: " + bookId);
            if (bookId != null) {
                fetchBookDetails(bookId);
            } else {
                Log.e("ViewBookFragment", "bookId là null");
            }
        } else {
            Log.e("ViewBookFragment", "getArguments() là null");
        }


        return view;
    }

    private void fetchBookDetails(String bookId) {
        APIService apiService = RetrofitClient.getRetrofitInstance().create(APIService.class);

        apiService.getBookDetails(bookId).enqueue(new Callback<Book1>() {
            @Override
            public void onResponse(Call<Book1> call, Response<Book1> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Book1 book = response.body();

                    // Hiển thị thông tin sách lên giao diện
                    bookName.setText(book.getTitle());
                    bookAuthor.setText(book.getAuthor());

                    String mp4 = book.getURLaudioBook(); // Ví dụ: "nu.mp4"
                    if (mp4 != null && mp4.endsWith(".mp3")) {
                        // Lấy tên file mà API trả về
                        String rawFileName = mp4.substring(0, mp4.lastIndexOf('.')); // Lấy tên file mà không có đuôi .mp4

                        // Lấy resourceId từ tên file trong thư mục raw
                        int rawResourceId = getResources().getIdentifier(rawFileName, "raw", getContext().getPackageName());
                        if (rawResourceId != 0) {
                            try {
                                mediaPlayer = MediaPlayer.create(getContext(), rawResourceId);
                                mediaPlayer.setOnPreparedListener(mp -> {
                                    seekBar.setMax(mediaPlayer.getDuration()); // Đặt max SeekBar khi file được chuẩn bị
                                    playAudio(); // Phát âm thanh
                                });

                                mediaPlayer.setOnCompletionListener(mp -> {
                                    isPlaying = false;
                                    seekBar.setProgress(0); // Đặt lại SeekBar về 0 khi phát xong
                                });

                                // Cập nhật SeekBar khi âm thanh phát
                                seekBar.setMax(mediaPlayer.getDuration());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("AudioError", "Lỗi khi thiết lập MediaPlayer: " + e.getMessage());
                            }
                        } else {
                            Log.e("AudioError", "Không tìm thấy file trong thư mục raw: " + rawFileName);
                        }

                        // Xử lý sự kiện cho nút Play/Pause
                        btnPlayPause.setOnClickListener(v -> {
                            if (isPlaying) {
                                pauseAudio();
                            } else {
                                playAudio();
                            }
                        });

                        // Cập nhật tiến độ SeekBar mỗi giây
                        handler.postDelayed(updateSeekBar, 1000);

                        // Xử lý SeekBar để tua nhanh
                        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                if (fromUser) {
                                    mediaPlayer.seekTo(progress);
                                }
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {
                                handler.removeCallbacks(updateSeekBar); // Dừng cập nhật khi người dùng đang kéo
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {
                                handler.postDelayed(updateSeekBar, 1000); // Tiếp tục cập nhật sau khi dừng kéo
                            }
                        });

                        // Xử lý nút Previous và Next
                        btnPrevious.setOnClickListener(v -> rewindAudio());
                        btnNext.setOnClickListener(v -> fastForwardAudio());

                        // Hiển thị ảnh bìa sách
                        String imageName = book.getImgResource();
                        if (imageName != null && (imageName.endsWith(".jpg") || imageName.endsWith(".png"))) {
                            imageName = imageName.substring(0, imageName.lastIndexOf('.'));
                            if (getContext() != null) {
                                int resId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
                                if (resId != 0) {
                                    Glide.with(getContext()).load(resId).into(bookImage);
                                } else {
                                    Log.e("ViewBookFragment", "Không tìm thấy resource ảnh cho: " + imageName);
                                    bookImage.setVisibility(View.GONE);
                                }
                            } else {
                                Log.e("ViewBookFragment", "Context là null");
                            }
                        }
                    } else {
                        Log.e("AudioError", "Không tìm thấy file âm thanh trong API: " + mp4);
                    }
                } else {
                    Log.e("API_ERROR", "Không lấy được thông tin sách");
                }
            }

            @Override
            public void onFailure(Call<Book1> call, Throwable t) {
                Log.e("API_ERROR", "Lỗi: " + t.getMessage());
            }
        });
    }

    // Hàm tạm dừng âm thanh
    private void pauseAudio() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            // Đổi icon thành icon Play
            btnPlayPause.setImageResource(R.drawable.ic_play_circle); // Đặt lại icon thành Play
        }
    }

    // Hàm phát âm thanh
    private void playAudio() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            isPlaying = true;
            // Đổi icon thành icon Pause
            btnPlayPause.setImageResource(R.drawable.ic_pause); // Đặt icon thành Pause
        }
    }


    // Hàm tua lại
    private void rewindAudio() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int rewindPosition = Math.max(currentPosition - 10000, 0); // Tua lại 10 giây
            mediaPlayer.seekTo(rewindPosition);
        }
    }

    // Hàm tua nhanh
    private void fastForwardAudio() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int forwardPosition = Math.min(currentPosition + 10000, mediaPlayer.getDuration()); // Tua nhanh 10 giây
            mediaPlayer.seekTo(forwardPosition);
        }
    }

    // Đảm bảo dừng âm thanh khi Activity hoặc Fragment bị hủy
    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
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



    // Cập nhật SeekBar
    private Runnable updateSeekBar = new Runnable() {
        @Override
        public void run() {
            if (isPlaying) { // Chỉ cập nhật nếu đang phát
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                tvTime.setText(formatTime(mediaPlayer.getCurrentPosition()));
            }
            handler.postDelayed(this, 1000);
        }
    };

    // Định dạng thời gian từ milliseconds
    private String formatTime(int milliseconds) {
        int minutes = milliseconds / 1000 / 60;
        int seconds = (milliseconds / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBar);
    }
}


//private void initializeMediaPlayer(String audioUrl) {
//
//    try {
//        if (audioUrl != null && audioUrl.startsWith("raw:")) {
//            // Handling audio from raw resources
//            // String fileName = audioUrl.replace("raw:", "");
//            int rawResourceId = getResources().getIdentifier(audioUrl, "raw", requireContext().getPackageName());
//            if (rawResourceId != 0) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(requireContext(), rawResourceId);
//                mediaPlayer.setOnPreparedListener(mp -> {
//                    seekBar.setMax(mediaPlayer.getDuration()); // Set max duration when media is ready
//                    playAudio(); // Start playing audio after it's prepared
//                });
//            } else {
//                Log.e("MediaPlayer_ERROR", "Could not find raw file");
//            }
//        } else {
//            // Handling audio from URL
//            mediaPlayer = new MediaPlayer();
//            mediaPlayer.setDataSource(requireContext(), Uri.parse(audioUrl)); // Set data source from URL
//            mediaPlayer.prepareAsync(); // Asynchronous preparation of the media
//            mediaPlayer.setOnPreparedListener(mp -> {
//                seekBar.setMax(mediaPlayer.getDuration()); // Set max duration when media is ready
//                playAudio(); // Start playing audio after it's prepared
//            });
//        }
//
//        // Listen for when the audio finishes playing
//        mediaPlayer.setOnCompletionListener(mp -> {
//            isPlaying = false;
//            seekBar.setProgress(0); // Reset SeekBar when audio is finished
//        });
//    } catch (Exception e) {
//        Log.e("MediaPlayer_ERROR", "Error initializing MediaPlayer: " + e.getMessage());
//    }
//}
