package com.parkirkece;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText u = findViewById(R.id.etUser);
        EditText p = findViewById(R.id.etPass);
        Button b = findViewById(R.id.btnLogin);
        b.setOnClickListener(v -> {
            String su = u.getText().toString().trim();
            String sp = p.getText().toString().trim();
            if(("admin".equals(su) && "12345".equals(sp)) || ("petugas".equals(su) && "0000".equals(sp))){
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Login salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}