package com.app.omandiscount.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.ProductListModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Rj on 3/3/2018.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {
    private final OnItemClickListener listener;

    private Context mContext;
    private List<ProductListModel> todaysDealModels ;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;
        TextView price,itemName,oldPrice;

        public MyViewHolder(View view) {
            super(view);
                thumbnail=(ImageView)view.findViewById(R.id.pro_logo);

            itemName=(TextView)view.findViewById(R.id.pro_title);




        }
        public void bind(final ProductListModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
}
public interface OnItemClickListener {
    void onItemClick(ProductListModel item);
}

    public ProductListAdapter(OnItemClickListener listener, Context mContext, List<ProductListModel> albumList) {
        this.listener = listener;
        this.mContext = mContext;
        this.todaysDealModels = albumList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productlistadapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ProductListModel album = todaysDealModels.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getAd_products_image()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            holder.itemName.setText(album.getAd_products_title());

            holder.bind(todaysDealModels.get(position), listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
