package com.app.omandiscount.Adapters;

import android.content.Context;

import android.support.annotation.NonNull;

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


public class ProductViewListAdapter extends RecyclerView.Adapter<ProductViewListAdapter.MyViewHolder>
{
    private final OnItemClickListener listener;
    private Context mContext;
    private List<ProductListModel> todaysDealModels ;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView thumbnail;
        TextView offer,price,itemName,description,pricesub;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            thumbnail=(ImageView)itemView.findViewById(R.id.pv_image);
            offer=(TextView)itemView.findViewById(R.id.pv_productoffer);
            price=(TextView)itemView.findViewById(R.id.pv_productprize);
            itemName=(TextView)itemView.findViewById(R.id.pv_productname);
            pricesub=(TextView)itemView.findViewById(R.id.pv_productprize_sub);
            description=(TextView)itemView.findViewById(R.id.pv_productdescription);

        }
        public void bind(final ProductListModel item, final ProductViewListAdapter.OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public ProductViewListAdapter(OnItemClickListener listener, Context mContext, List<ProductListModel> todaysDealModels) {
        this.listener = listener;
        this.mContext = mContext;
        this.todaysDealModels = todaysDealModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productlistviewnew, parent, false);

        return new MyViewHolder(itemView);
    }
    public interface OnItemClickListener
    {
        void onItemClick(ProductListModel item);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        ProductListModel album = todaysDealModels.get(position);
        // loading album cover using Glide library
        try {
            Glide.with(mContext).load(album.getAd_products_image()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.itemName.setText(album.getAd_products_title());
        holder.offer.setText("("+album.getAd_products_offer()+"% )");
        holder.price.setText(album.getAd_products_prize()+"$");
        holder.description.setText(album.getAd_products_description().trim());
        holder.pricesub.setText(album.getAd_products_prize());

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

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
