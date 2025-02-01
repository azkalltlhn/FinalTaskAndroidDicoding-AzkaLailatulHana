package com.example.tugasandroiddicoding_azkalailatulhana;

import android.content.Context;
import android.content.Intent;

public class ShowDetails {
    private Context context;

    public ShowDetails(Context context) {
        this.context = context;
    }

    public void showDetail(Info info) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_NAME, info.getName());
        intent.putExtra(DetailActivity.EXTRA_DETAIL, info.getDetail());
        intent.putExtra(DetailActivity.EXTRA_IMAGE, info.getPhoto());
        context.startActivity(intent);
    }
}
