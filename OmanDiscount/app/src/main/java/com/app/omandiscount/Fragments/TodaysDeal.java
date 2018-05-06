package com.app.omandiscount.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.omandiscount.Activity.TodaysDetails;
import com.app.omandiscount.Adapters.TodayDealsAdapter;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.R;
import com.app.omandiscount.model.TodaysDealModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Greeshma Prakash on 25-Feb-18.
 */

public class TodaysDeal extends Fragment
{
    List<TodaysDealModel> todaysdeal=new ArrayList<>();
    RecyclerView recyclerView,recyclerView1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Today's Deal");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_todaysdeal, container, false);

        todaysdeal= HomePage.todaysDealModels;


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_todaysdeal);

        TodayDealsAdapter adapter = new TodayDealsAdapter(new TodayDealsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TodaysDealModel item) {

                try {
                    Intent temp = new Intent(getContext(), TodaysDetails.class);
                    temp.putExtra("model",  item);
                    startActivity(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },getContext(), todaysdeal);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.addItemDecoration(new Home.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
