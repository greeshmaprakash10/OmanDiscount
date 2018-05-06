package com.app.omandiscount.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.TopSiteAddModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Rj on 3/3/2018.
 */

public class TopSiteAddAdapter extends RecyclerView.Adapter<TopSiteAddAdapter.MyViewHolder> {

    private Context mContext;
    private List<TopSiteAddModel> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
                thumbnail=(ImageView)view.findViewById(R.id.thumbnail);
//                thumbnail.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                       Intent i=new Intent(mContext,TodaysDetails.class);
//                       mContext.startActivity(i);
//                    }
//                });
        }
    }


    public TopSiteAddAdapter(Context mContext, List<TopSiteAddModel> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item_cardview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TopSiteAddModel album = albumList.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getSiteadd_img()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
