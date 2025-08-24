package com.parkirkece;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class InputKendaraanActivity extends AppCompatActivity {
    private EditText etPlat; private TextView tvWaktu;
    private String waktuMasuk;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        etPlat = findViewById(R.id.etPlat);
        tvWaktu = findViewById(R.id.tvWaktu);
        Button simpan = findViewById(R.id.btnSimpan);
        Button cetak = findViewById(R.id.btnCetak);
        waktuMasuk = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
        tvWaktu.setText("Masuk: " + waktuMasuk);
        simpan.setOnClickListener(v -> finish());
        cetak.setOnClickListener(v -> print(etPlat.getText().toString(), waktuMasuk));
    }
    private void print(String plat, String waktu){
        try{
            BluetoothAdapter ad = BluetoothAdapter.getDefaultAdapter();
            if (ad==null || !ad.isEnabled()) return;
            Set<BluetoothDevice> devs = ad.getBondedDevices();
            BluetoothDevice target = devs.iterator().hasNext()? devs.iterator().next(): null;
            if (target==null) return;
            BluetoothSocket s = target.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            s.connect();
            OutputStream os = s.getOutputStream();
            String text = "=== PARKIR KECE ===\nPlat/ID: "+plat+"\nMasuk: "+waktu+"\n===================\n";
            os.write(text.getBytes());
            os.flush();
            s.close();
        }catch(Exception ignored){}
    }
}