package com.example.tugasandroiddicoding_azkalailatulhana;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_IMAGE = "extra_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi toolbar dan tombol kembali
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Artikel"); // Menghapus judul toolbar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Menampilkan tombol kembali
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Inisialisasi elemen UI
        ImageView imgPhoto = findViewById(R.id.img_photo);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDetail = findViewById(R.id.tv_detail);

        // Ambil data dari Intent
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        int imageRes = getIntent().getIntExtra(EXTRA_IMAGE, 0); // Default 0 jika tidak ada

        // Set data
        tvName.setText(name);
        tvDetail.setText(detail);
        imgPhoto.setImageResource(imageRes);

        // Inisialisasi overview
        LinearLayout overview1 = findViewById(R.id.overview_1);
        LinearLayout overview2 = findViewById(R.id.overview_2);
        LinearLayout overview3 = findViewById(R.id.overview_3);
        ImageView imgOverview1 = findViewById(R.id.img_overview_1);
        TextView tvOverview1 = findViewById(R.id.tv_overview_1);
        ImageView imgOverview2 = findViewById(R.id.img_overview_2);
        TextView tvOverview2 = findViewById(R.id.tv_overview_2);
        ImageView imgOverview3 = findViewById(R.id.img_overview_3);
        TextView tvOverview3 = findViewById(R.id.tv_overview_3);

        // Deskripsi singkat overview
        TextView tvOverviewDesc1 = findViewById(R.id.tv_overview_desc_1);
        TextView tvOverviewDesc2 = findViewById(R.id.tv_overview_desc_2);
        TextView tvOverviewDesc3 = findViewById(R.id.tv_overview_desc_3);

        // Ambil data acak dari InfoData
        ArrayList<Info> infoList = InfoData.getListData();
        if (infoList == null || infoList.size() < 3) {
            Toast.makeText(this, "Data overview tidak cukup!", Toast.LENGTH_SHORT).show();
            Log.e("DetailActivity", "infoList kosong atau kurang dari 3 elemen.");
            return;
        }

        Collections.shuffle(infoList); // Mengacak data

        // Set data overview
        Info infoOverview1 = infoList.get(0);
        imgOverview1.setImageResource(infoOverview1.getPhoto());
        tvOverview1.setText(infoOverview1.getName());
        tvOverviewDesc1.setText(infoOverview1.getShortDescription());

        Info infoOverview2 = infoList.get(1);
        imgOverview2.setImageResource(infoOverview2.getPhoto());
        tvOverview2.setText(infoOverview2.getName());
        tvOverviewDesc2.setText(infoOverview2.getShortDescription());

        Info infoOverview3 = infoList.get(2);
        imgOverview3.setImageResource(infoOverview3.getPhoto());
        tvOverview3.setText(infoOverview3.getName());
        tvOverviewDesc3.setText(infoOverview3.getShortDescription());

        // Set listener untuk klik overview
        overview1.setOnClickListener(v -> showDetail(infoOverview1));
        overview2.setOnClickListener(v -> showDetail(infoOverview2));
        overview3.setOnClickListener(v -> showDetail(infoOverview3));
    }

    // Menampilkan detail dari overview yang dipilih
    private void showDetail(Info info) {
        Toast.makeText(this, "Detail: " + info.getName(), Toast.LENGTH_SHORT).show();
        ShowDetails showDetails = new ShowDetails(this);
        showDetails.showDetail(info);
    }
}
