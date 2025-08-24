package com.parkirkece;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DataParkirActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_parkir);
        ListView list = findViewById(R.id.listData);
        ArrayList<String> items = new ArrayList<>();
        items.add("0001 | B1234CD | 10:00 → 11:05 | Rp 5.000");
        items.add("0002 | D5555AB | 10:15 → 10:50 | Rp 3.000");
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }
}