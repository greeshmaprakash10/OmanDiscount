package com.app.omandiscount.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.FeaturedModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Rj on 3/3/2018.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.MyViewHolder> {
    private final OnItemClickListener listener;
    private Context mContext;
    private List<FeaturedModel> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;
        TextView price,offer,off,name;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.tv_feature_item_pic);
            price = (TextView) view.findViewById(R.id.tv_feature_item_price);
            offer = (TextView) view.findViewById(R.id.tv_feature_item_offer);
            off = (TextView) view.findViewById(R.id.tv_feature_item_off);
            name = (TextView) view.findViewById(R.id.tv_feature_item_name);
        }
        public void bind(final FeaturedModel item, final FeaturedAdapter.OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }


    public FeaturedAdapter(OnItemClickListener listener, Context mContext, List<FeaturedModel> albumList) {
        this.listener = listener;
        this.mContext = mContext;
        this.albumList = albumList;
    }
    public interface OnItemClickListener {
        void onItemClick(FeaturedModel item);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featured, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        FeaturedModel album = albumList.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getAd_products_image()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.name.setText(album.getAd_products_title());
        holder.off.setText("("+album.getAd_products_offer()+"%off)");
        holder.offer.setText(album.getAd_products_offer()+"$");
        holder.price.setText(album.getAd_products_prize()+"$");
        holder.bind(albumList.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
