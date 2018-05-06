package com.app.omandiscount.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.CategoryModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Rj on 3/3/2018.
 */

public class CategoryImageAdapter extends RecyclerView.Adapter<CategoryImageAdapter.MyViewHolder> {

    private Context mContext;
    private List<CategoryModel> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView thumbnail;
        TextView catName;
        public MyViewHolder(View view) {
            super(view);
            thumbnail=(ImageView)view.findViewById(R.id.category_item_image);
            catName=(TextView)view.findViewById(R.id.category_item_name);
        }
    }


    public CategoryImageAdapter(Context mContext, List<CategoryModel> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item_image, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CategoryModel album = albumList.get(position);

        holder.catName.setText(album.getCategory_name());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.catName.setZ(10);
            holder.thumbnail.setZ(0);
        }

        try {
            Glide.with(mContext).load(album.getCategory_image()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    @Override
    public int getItemCount() {
        return albumList.size();
    }
}