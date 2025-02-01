package com.example.tugasandroiddicoding_azkalailatulhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Info> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Pastikan Toolbar benar-benar diatur dengan benar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Artikel");
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvHeroes = findViewById(R.id.rv_info);
        rvHeroes.setHasFixedSize(true);

        list.addAll(InfoData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListInfoAdapter listInfoAdapter = new ListInfoAdapter(list);
        rvHeroes.setAdapter(listInfoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_profile) {
            // Pindah ke ProfileActivity saat menu profil diklik
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
