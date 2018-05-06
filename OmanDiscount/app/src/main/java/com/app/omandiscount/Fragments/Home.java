package com.app.omandiscount.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.omandiscount.Activity.FeaturedDetails;
import com.app.omandiscount.Activity.Products;
import com.app.omandiscount.Activity.TodaysDetails;
import com.app.omandiscount.Adapters.CategoryImageAdapter;
import com.app.omandiscount.Adapters.FeaturedAdapter;
import com.app.omandiscount.Adapters.PageIndicaterAdapter;
import com.app.omandiscount.Adapters.ProductListAdapter;
import com.app.omandiscount.Adapters.TodayDealsAdapter;
import com.app.omandiscount.Adapters.TopSiteAddAdapter;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.R;
import com.app.omandiscount.model.FeaturedModel;
import com.app.omandiscount.model.ProductListModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.RtlMode;

import java.util.ArrayList;
import java.util.List;

import static com.rd.utils.DensityUtils.dpToPx;

/**
 * Created by Greeshma Prakash on 25-Feb-18.
 */

public class Home extends Fragment
{
    LayoutInflater inflater;
    ConstraintLayout cl_top_banner;
    LinearLayout todaydeals,fearcherd,productlist,categories;


    TopSiteAddAdapter topSiteAddAdapter;
    ImageView bannerMiddle,bannerBottom;
    ViewPager pager;
    TextView today_view,feature_view;
    LinearLayout category_view,mobile_view;
    View rootView;
    TodayDealsAdapter todayDealsAdapter;
    private PageIndicatorView pageIndicatorView;
    RecyclerView rv_categories,rv_topsiteadd,rv_todaydeals,rv_featured,rv_productlist;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Home");
    }
    LayoutInflater vi;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        today_view = (TextView) rootView.findViewById(R.id.today_viewall);
        feature_view = (TextView) rootView.findViewById(R.id.feature_viewall);
        category_view = (LinearLayout) rootView.findViewById(R.id.category_viewall);
        mobile_view = (LinearLayout) rootView.findViewById(R.id.mobile_viewall);

        today_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new TodaysDeal();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment2);
                fragmentTransaction.commit();
            }
        });
        feature_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new Featured();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment2);
                fragmentTransaction.commit();
            }
        });
        category_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment2 = new Category();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment2);
                fragmentTransaction.commit();
            }
        });
        mobile_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(getContext(), Products.class);
                startActivity(n);
            }
        });
        pager = rootView.findViewById(R.id.viewPager);
        pager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), TodaysDetails.class);
                startActivity(i);
            }
        });
        //TODO load first banner
        pageIndicatorView = rootView.findViewById(R.id.pageIndicatorView);
        cl_top_banner = (ConstraintLayout) rootView.findViewById(R.id.cl_top_banner);
        cl_top_banner.setVisibility(View.INVISIBLE);

        if (HomePage.topBannerModels.size() > 0)
        {
            try {
                PageIndicaterAdapter adapter = new PageIndicaterAdapter();
                adapter.setData(createPageList());

                pager.setAdapter(adapter);
                pageIndicatorView.setViewPager(pager);
                pageIndicatorView.setAnimationType(AnimationType.SCALE);
                pageIndicatorView.setOrientation(Orientation.HORIZONTAL);
                pageIndicatorView.setRtlMode(RtlMode.Off);
                pageIndicatorView.setInteractiveAnimation(false);
                pageIndicatorView.setAutoVisibility(true);
                cl_top_banner.setVisibility(View.VISIBLE);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //TODO load 1st recycler view
        rv_topsiteadd = (RecyclerView) rootView.findViewById(R.id.recyclerview1);
        rv_topsiteadd.setVisibility(View.INVISIBLE);
        rv_topsiteadd.setHasFixedSize(true);
        rv_topsiteadd.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_topsiteadd.setLayoutManager(layoutManager);
        if(HomePage.topSiteAddModels.size()>0)
        {
            //TODO 1 st recyclerview
            try{

                topSiteAddAdapter = new TopSiteAddAdapter(getContext(), HomePage.topSiteAddModels);
                rv_topsiteadd.setAdapter(topSiteAddAdapter);
                rv_topsiteadd.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //TODO load todaydeals
        todaydeals=(LinearLayout)rootView.findViewById(R.id.ll_home_todaydeals) ;
        todaydeals.setVisibility(View.INVISIBLE);
        rv_todaydeals = (RecyclerView) rootView.findViewById(R.id.rv_todaydeals);
        rv_todaydeals.setHasFixedSize(true);
        rv_todaydeals.setNestedScrollingEnabled(false);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
       // RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        rv_todaydeals.setLayoutManager(horizontalLayoutManagaer);
        try {
            if(HomePage.todaysDealModels.size()>0)
            {
                todayDealsAdapter = new TodayDealsAdapter(new TodayDealsAdapter.OnItemClickListener() {
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
                }, getContext(), HomePage.todaysDealModels);
                rv_todaydeals.setAdapter(todayDealsAdapter);
                todaydeals.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        //TODO featurd list
        fearcherd=(LinearLayout)rootView.findViewById(R.id.ll_home_featurdlist) ;
        fearcherd.setVisibility(View.INVISIBLE);
        rv_featured = (RecyclerView) rootView.findViewById(R.id.rv_featured);
        rv_featured.setHasFixedSize(true);
        rv_featured.setNestedScrollingEnabled(false);
         horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_featured.setLayoutManager(horizontalLayoutManagaer);
        if(HomePage.featuredDatas.size()>0)
        {
            try {
                FeaturedAdapter adapter1 = new FeaturedAdapter(new FeaturedAdapter.OnItemClickListener() {
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
                }, getContext(), HomePage.featuredDatas);
                rv_featured.setAdapter(adapter1);
                fearcherd.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        //TODO 2 st recyclerview categories
        try {
            categories=(LinearLayout)rootView.findViewById(R.id.ll_home_categories);
            categories.setVisibility(View.INVISIBLE);
            rv_categories = (RecyclerView) rootView.findViewById(R.id.rv_home_categories);
            GridLayoutManager mLayoutManager1 = new GridLayoutManager(getContext(), 2);
            rv_categories.setLayoutManager(mLayoutManager1);
            rv_categories.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
            rv_categories.setItemAnimator(new DefaultItemAnimator());
            rv_categories.setNestedScrollingEnabled(false);
            if(HomePage.categoryModels.size()>0)
            {
                    try {
                    CategoryImageAdapter adapter1 = new CategoryImageAdapter(getContext(), HomePage.categoryModels);
                    rv_categories.setAdapter(adapter1);
                    categories.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//TODO add middle banner
        bannerMiddle=(ImageView)rootView.findViewById(R.id.iv_banner_middle);
        bannerMiddle.setVisibility(View.INVISIBLE);
        if(HomePage.bottomSiteModels.size()>0)
        {
            try {
            Glide.with(Home.this).load(HomePage.bottomSiteModels.get(0).getSiteadd_img()).asBitmap().into(bannerMiddle);
            bannerMiddle.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        //TODO set product list
        productlist=(LinearLayout)rootView.findViewById(R.id.ll_home_productlist);
        productlist.setVisibility(View.INVISIBLE);
        rv_productlist = (RecyclerView) rootView.findViewById(R.id.rv_productlist);
        rv_productlist.setHasFixedSize(true);
        rv_featured.setNestedScrollingEnabled(false);
        horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_productlist.setLayoutManager(horizontalLayoutManagaer);
        if(HomePage.productModels.size()>0)
        {
            TextView productName=rootView.findViewById(R.id.tv_home_product_name);
            productName.setText(HomePage.productModels.get(0).getCategory_name());
            try {
               ProductListAdapter adapter1 = new ProductListAdapter(new ProductListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(ProductListModel item) {

                        try {
                            Intent temp = new Intent(getContext(), Products.class);
                            temp.putExtra("model",  item);
                            startActivity(temp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },getContext(), HomePage.productModels.get(0).getProduct_list());
                rv_productlist.setAdapter(adapter1);
                productlist.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //TODO set bottom banner
        bannerBottom=(ImageView)rootView.findViewById(R.id.iv_banner_bottom);
        if(HomePage.bottomSiteModels.size()>0)
        {
            try {
                Glide.with(Home.this).load(HomePage.bottomSiteModels.get(0).getSiteadd_img()).asBitmap().into(bannerBottom);
                bannerBottom.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rootView;
    }
    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        for(int i=0;i<HomePage.topBannerModels.size();i++)
        {
            pageList.add(createPageView(HomePage.topBannerModels.get(i).getBannerImage()));
        }

        return pageList;
    }



    @NonNull
    private View createPageView(String url){
        final View view = new View(getContext());
        Glide.with(this).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Drawable drawable = new BitmapDrawable(getContext().getResources(), resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.setBackground(drawable);
                }
            }
        });

        return view;
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
