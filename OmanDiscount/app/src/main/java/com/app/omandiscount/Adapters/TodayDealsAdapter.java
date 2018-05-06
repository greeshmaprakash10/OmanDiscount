package com.app.omandiscount.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;
import com.rd.draw.controller.DrawController;

import java.util.List;

/**
 * Created by Rj on 3/3/2018.
 */

public class TodayDealsAdapter extends RecyclerView.Adapter<TodayDealsAdapter.MyViewHolder> {
    private final OnItemClickListener listener;

    private Context mContext;
    private List<TodaysDealModel> todaysDealModels ;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;
        TextView offer,price,itemName,endTime,oldPrice;

        public MyViewHolder(View view) {
            super(view);
                thumbnail=(ImageView)view.findViewById(R.id.tv_today_deals_item_pic);
            offer=(TextView)view.findViewById(R.id.tv_today_deals_item_offer);
            price=(TextView)view.findViewById(R.id.tv_today_deals_item_ofprice);
            itemName=(TextView)view.findViewById(R.id.tv_today_deals_item_name);
            endTime=(TextView)view.findViewById(R.id.tv_today_deals_item_endtime);
            oldPrice=(TextView)view.findViewById(R.id.tv_today_deals_item_price);



        }
        public void bind(final TodaysDealModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
}
public interface OnItemClickListener {
    void onItemClick(TodaysDealModel item);
}

    public TodayDealsAdapter(OnItemClickListener listener,  Context mContext, List<TodaysDealModel> albumList) {
        this.listener = listener;
        this.mContext = mContext;
        this.todaysDealModels = albumList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todaydeals, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TodaysDealModel album = todaysDealModels.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getAd_products_image()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.itemName.setText(album.getAd_products_title());
        holder.offer.setText(album.getDeal_products_offer()+"%");
        holder.price.setText(album.getAd_products_prize()+"$");
        holder.oldPrice.setText(album.getAd_products_offer()+"$");

        holder.bind(todaysDealModels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        int size=0;
        try {
            size=todaysDealModels.size();
        } catch (Exception e) {
            size=0;
            e.printStackTrace();
        }
        return size;
    }
}
