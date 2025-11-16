package com.example.imageviewerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvImageName;
    private Button btnPrevious, btnNext, btnRandom;

    private int[] images = {
            R.drawable.sample1,
            R.drawable.sample2,
            R.drawable.sample3,
            R.drawable.sample4,
            R.drawable.sample5
    };

    private String[] imageNames = {
            "Sample 1",
            "Sample 2",
            "Sample 3",
            "Sample 4",
            "Sample 5"
    };

    private int currentIndex = 0;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        tvImageName = findViewById(R.id.tvImageName);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnRandom = findViewById(R.id.btnRandom);

        // Hiển thị ảnh đầu tiên
        updateImage();

        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % images.length;
            updateImage();
        });

        btnPrevious.setOnClickListener(v -> {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            updateImage();
        });

        btnRandom.setOnClickListener(v -> {
            currentIndex = random.nextInt(images.length);
            updateImage();
        });
    }

    private void updateImage() {
        imageView.setImageResource(images[currentIndex]);
        tvImageName.setText(imageNames[currentIndex]);
    }
}
