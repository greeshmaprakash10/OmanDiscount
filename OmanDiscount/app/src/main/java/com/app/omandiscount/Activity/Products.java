package com.app.omandiscount.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.ListView;

import com.app.omandiscount.Adapters.ProductViewListAdapter;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.R;
import com.app.omandiscount.model.ProductListModel;

public class Products extends AppCompatActivity
{
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_products);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // add back arrow to toolbar
            if (getSupportActionBar() != null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String title="Products";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview_products);

        if(HomePage.productModels.get(0).getProduct_list().size()>0)
        {
            ProductViewListAdapter adapter=new ProductViewListAdapter(new ProductViewListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(ProductListModel item)
                {
                    try {
                        Intent temp = new Intent(getApplicationContext(), ProductListDetails.class);
                        temp.putExtra("model",  item);
                        startActivity(temp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            },getApplicationContext(),HomePage.productModels.get(0).getProduct_list());
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(adapter);

        }


    }


}
