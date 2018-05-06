package com.app.omandiscount.Adapters;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.DealersModel;

import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class DealersAdapter extends RecyclerView.Adapter<DealersAdapter.MyViewHolder>
{
    private OnItemClickListener listener;
    private Context mContext;
    private List<DealersModel> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.dealers_logo);
        }
        public void bind(final DealersModel item, final DealersAdapter.OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
    public DealersAdapter(OnItemClickListener listener,Context mContext, List<DealersModel> albumList) {
        this.listener=listener;
        this.mContext = mContext;
        this.albumList = albumList;
    }
    public interface OnItemClickListener {
        void onItemClick(DealersModel item);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dealers, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        DealersModel album = albumList.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getVendor_logo()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.bind(albumList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
