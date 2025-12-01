package com.example.imageviewerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Import Toolbar để xử lý thanh tiêu đề
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến View
    private ImageView imageView;
    private TextView tvImageName;
    private Button btnPrevious, btnNext, btnRandom;

    // Mảng chứa ID của 5 ảnh (tương ứng với file sample1.jpg -> sample5.jpg trong res/drawable)
    private int[] images = {
            R.drawable.sample1,
            R.drawable.sample2,
            R.drawable.sample3,
            R.drawable.sample4,
            R.drawable.sample5
    };

    // Mảng chứa tên ảnh để hiển thị bên dưới
    private String[] imageNames = {
            "picture 1",
            "picture 2",
            "picture 3",
            "picture 4",
            "picture 5"
    };

    // Biến lưu chỉ số ảnh hiện tại (bắt đầu từ 0)
    private int currentIndex = 0;

    // Đối tượng Random để chọn ảnh ngẫu nhiên
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- CẤU HÌNH TOOLBAR (Thanh tiêu đề màu tím) ---
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Hiển thị nút mũi tên quay lại (Back button) trên Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // --- ÁNH XẠ VIEW ---
        imageView = findViewById(R.id.imageView);
        tvImageName = findViewById(R.id.tvImageName);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnRandom = findViewById(R.id.btnRandom);

        // Hiển thị ảnh đầu tiên ngay khi mở app
        updateImage();

        // --- XỬ LÝ SỰ KIỆN NÚT BẤM ---

        // 1. Nút Next (Tiếp theo)
        btnNext.setOnClickListener(v -> {
            // Tăng chỉ số, chia lấy dư để quay vòng về 0 nếu vượt quá
            currentIndex = (currentIndex + 1) % images.length;
            updateImage();
        });

        // 2. Nút Previous (Quay lại)
        btnPrevious.setOnClickListener(v -> {
            // Giảm chỉ số. Cộng thêm độ dài mảng để tránh số âm
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            updateImage();
        });

        // 3. Nút Random (Ngẫu nhiên)
        btnRandom.setOnClickListener(v -> {
            // Chọn một số ngẫu nhiên từ 0 đến độ dài mảng - 1
            currentIndex = random.nextInt(images.length);
            updateImage();
        });
    }

    // --- HÀM XỬ LÝ KHI BẤM NÚT BACK TRÊN TOOLBAR ---
    @Override
    public boolean onSupportNavigateUp() {
        // Quay lại màn hình trước đó (hoặc thoát app nếu đây là màn hình chính)
        onBackPressed();
        return true;
    }

    // --- HÀM CẬP NHẬT HÌNH ẢNH VÀ TÊN ---
    private void updateImage() {
        // Set hình ảnh theo ID trong mảng
        imageView.setImageResource(images[currentIndex]);

        // Set tên ảnh tương ứng
        tvImageName.setText(imageNames[currentIndex]);
    }
}