package com.app.omandiscount.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.omandiscount.Activity.FeaturedDetails;
import com.app.omandiscount.Activity.TodaysDetails;
import com.app.omandiscount.Adapters.FeaturedAdapter;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.R;
import com.app.omandiscount.model.FeaturedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Greeshma Prakash on 25-Feb-18.
 */

public class Featured extends Fragment
{
    RecyclerView recyclerView;
    List<FeaturedModel> todaysdeal=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title="Featured";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getActivity().setTitle(s);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_featured, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_featured);
        todaysdeal= HomePage.featuredDatas;

        if(todaysdeal.size()>0)
        {
            FeaturedAdapter adapter = new FeaturedAdapter(new FeaturedAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(FeaturedModel item) {
                    try {
                        Intent temp = new Intent(getContext(), FeaturedDetails.class);
                        temp.putExtra("model",  item);
                        startActivity(temp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, getContext(),todaysdeal);
            recyclerView.setNestedScrollingEnabled(true);
            GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
            // recyclerView.addItemDecoration(new Home.GridSpacingItemDecoration(2, dpToPx(10), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }
        return rootView;
    }
}
