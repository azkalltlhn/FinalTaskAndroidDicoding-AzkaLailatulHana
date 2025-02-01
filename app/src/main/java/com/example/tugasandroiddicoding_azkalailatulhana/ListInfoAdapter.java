package com.example.tugasandroiddicoding_azkalailatulhana;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListInfoAdapter extends RecyclerView.Adapter<ListInfoAdapter.ListViewHolder> {
    private ArrayList<Info> listInfo;

    public ListInfoAdapter(ArrayList<Info> list) {
        this.listInfo = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_info, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Info hero = listInfo.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        // Menambahkan setOnClickListener untuk mengirim data ke DetailActivity
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_NAME, hero.getName());
            intent.putExtra(DetailActivity.EXTRA_DETAIL, hero.getDetail());
            intent.putExtra(DetailActivity.EXTRA_IMAGE, hero.getPhoto());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listInfo.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public ListViewHolder(View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
