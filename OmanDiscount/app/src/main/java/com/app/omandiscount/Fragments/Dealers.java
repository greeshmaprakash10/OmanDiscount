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

import com.app.omandiscount.Activity.DealersDetails;
import com.app.omandiscount.Activity.TodaysDetails;
import com.app.omandiscount.Adapters.DealersAdapter;
import com.app.omandiscount.Adapters.FeaturedAdapter;
import com.app.omandiscount.Adapters.TodayDealsAdapter;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.R;
import com.app.omandiscount.model.DealersModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Greeshma Prakash on 25-Feb-18.
 */

public class Dealers extends Fragment
{
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String title="Dealers";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getActivity().setTitle(s);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dealers, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_dealers);
        if(HomePage.dealersModels.size()>0)
        {
            DealersAdapter adapter=new DealersAdapter(new DealersAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(DealersModel item)
                {
                    Intent temp = new Intent(getContext(), DealersDetails.class);
                    temp.putExtra("model",  item);
                    startActivity(temp);

                }
            },getContext(),HomePage.dealersModels);
            recyclerView.setNestedScrollingEnabled(true);
            GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }

        return rootView;
    }
}
