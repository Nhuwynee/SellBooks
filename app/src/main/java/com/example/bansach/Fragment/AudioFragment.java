package com.example.bansach.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bansach.R;

public class AudioFragment extends AppCompatActivity {

    private Button btnPlayPause, btnPrevious, btnNext;
    private SeekBar seekBar;
    private TextView tvTime, audiobookTitle;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiobook);

        btnPlayPause = findViewById(R.id.btn_play_pause);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        seekBar = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tv_time);
        audiobookTitle = findViewById(R.id.audiobook_title);

        // Set audiobook title
        audiobookTitle.setText("Tên Sách Nói");

        // Tạo MediaPlayer từ file âm thanh
        mediaPlayer = MediaPlayer.create(this, R.raw.nguoinamcham); // Đặt tên file sách nói trong thư mục raw

        // Cập nhật SeekBar khi âm thanh phát
        seekBar.setMax(mediaPlayer.getDuration());

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
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Xử lý nút Previous và Next
        btnPrevious.setOnClickListener(v -> rewindAudio());
        btnNext.setOnClickListener(v -> fastForwardAudio());
    }

    // Phát sách nói
    private void playAudio() {
        mediaPlayer.start();
        btnPlayPause.setText("Pause");
        isPlaying = true;
    }

    // Tạm dừng sách nói
    private void pauseAudio() {
        mediaPlayer.pause();
        btnPlayPause.setText("Play");
        isPlaying = false;
    }

    // Tua nhanh
    private void fastForwardAudio() {
        int newPosition = mediaPlayer.getCurrentPosition() + 5000; // Tua nhanh 5 giây
        mediaPlayer.seekTo(newPosition);
    }

    // Tua lùi
    private void rewindAudio() {
        int newPosition = mediaPlayer.getCurrentPosition() - 5000; // Tua lùi 5 giây
        mediaPlayer.seekTo(newPosition);
    }

    // Cập nhật SeekBar
    private Runnable updateSeekBar = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            tvTime.setText(formatTime(mediaPlayer.getCurrentPosition()));
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
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBar);
    }
}
