package com.example.bansach.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bansach.R;

public class AudioFragment extends Fragment {

    private ImageButton btnPlayPause, btnPrevious, btnNext;
    private SeekBar seekBar;
    private TextView tvTime;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private boolean isPlaying = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_audiobook, container, false);

        btnPlayPause = view.findViewById(R.id.btn_play_pause);
        btnPrevious = view.findViewById(R.id.btn_previous);
        btnNext = view.findViewById(R.id.btn_next);
        seekBar = view.findViewById(R.id.seekBar);
        tvTime = view.findViewById(R.id.tv_time);


        // Tạo MediaPlayer từ file âm thanh
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.ditimlesongmp3); // Đặt tên file sách nói trong thư mục raw

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

        // Nghe sự kiện khi âm thanh phát xong
        mediaPlayer.setOnCompletionListener(mp -> {
            isPlaying = false;
            seekBar.setProgress(0); // Đặt lại SeekBar về 0 khi phát xong
        });

        return view;
    }

    // Phát sách nói
    private void playAudio() {
        mediaPlayer.start();
        isPlaying = true;
    }

    // Tạm dừng sách nói
    private void pauseAudio() {
        mediaPlayer.pause();
        isPlaying = false;
    }

    // Tua nhanh
    private void fastForwardAudio() {
        int newPosition = mediaPlayer.getCurrentPosition() + 5000; // Tua nhanh 5 giây
        if (newPosition < mediaPlayer.getDuration()) {
            mediaPlayer.seekTo(newPosition);
        }
    }

    // Tua lùi
    private void rewindAudio() {
        int newPosition = mediaPlayer.getCurrentPosition() - 5000; // Tua lùi 5 giây
        if (newPosition >= 0) {
            mediaPlayer.seekTo(newPosition);
        }
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