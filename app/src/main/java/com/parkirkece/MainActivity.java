package com.parkirkece;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button in = findViewById(R.id.btnInput);
        Button data = findViewById(R.id.btnData);
        Button out = findViewById(R.id.btnLogout);
        in.setOnClickListener(v -> startActivity(new Intent(this, InputKendaraanActivity.class)));
        data.setOnClickListener(v -> startActivity(new Intent(this, DataParkirActivity.class)));
        out.setOnClickListener(v -> { startActivity(new Intent(this, LoginActivity.class)); finish(); });
    }
}