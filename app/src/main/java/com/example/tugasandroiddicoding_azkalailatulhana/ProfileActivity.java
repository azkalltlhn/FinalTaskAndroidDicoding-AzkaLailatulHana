package com.example.tugasandroiddicoding_azkalailatulhana;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Setup Toolbar dari tema
        Toolbar toolbar = new Toolbar(this);  // Membuat toolbar programmatically
        toolbar.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                getResources().getDimensionPixelSize(android.R.dimen.app_icon_size) // Bisa juga menggunakan dimen standar lainnya
        ));
        // Inisialisasi toolbar dan tombol kembali
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);

        // Mengecek jika getSupportActionBar() tidak null sebelum mengaksesnya
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile"); // Menghapus judul toolbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Menampilkan tombol kembali
        }

        // Menangani klik tombol kembali
        toolbar1.setNavigationOnClickListener(v -> onBackPressed());


        // Referensi ke elemen UI
        ImageView profileImage = findViewById(R.id.img_profile);
        TextView profileName = findViewById(R.id.tv_name);
        TextView profileEmail = findViewById(R.id.tv_email);

        // Set data profile (ganti dengan data dinamis jika diperlukan)
        profileImage.setImageResource(R.drawable.foto_azkalailatulhana); // Gambar di drawable
        profileName.setText("Azka Lailatul Hana");
        profileEmail.setText("azkalltlhn.work@gmail.com");
    }

    // Menangani klik tombol back di Toolbar
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Kembali ke activity sebelumnya
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
