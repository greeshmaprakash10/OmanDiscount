package com.app.omandiscount.NavigationDrawer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.app.omandiscount.Activity.MapActivity;
import com.app.omandiscount.Fragments.Category;
import com.app.omandiscount.Fragments.ContactUs;
import com.app.omandiscount.Fragments.Dealers;
import com.app.omandiscount.Fragments.Featured;
import com.app.omandiscount.Fragments.Home;
import com.app.omandiscount.Fragments.Settings;
import com.app.omandiscount.Fragments.TodaysDeal;
import com.app.omandiscount.R;
import com.app.omandiscount.model.BottomSiteModel;
import com.app.omandiscount.model.CategoryModel;
import com.app.omandiscount.model.DealersModel;
import com.app.omandiscount.model.FeaturedModel;
import com.app.omandiscount.model.MiddleSiteAdsModel;
import com.app.omandiscount.model.ProductListModel;
import com.app.omandiscount.model.ProductModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.app.omandiscount.model.TopBannerModel;
import com.app.omandiscount.model.TopSiteAddModel;

import java.util.List;


public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static List<TodaysDealModel> todaysDealModels;
    public  static List<TopBannerModel> topBannerModels;
    public  static List<TopSiteAddModel> topSiteAddModels;
    public static List<FeaturedModel> featuredDatas;
    public static List<CategoryModel> categoryModels;
    public static List<MiddleSiteAdsModel> middleSiteAdsModels;
    public static List<ProductModel> productModels;
    public static List<BottomSiteModel>  bottomSiteModels;
    public static List<DealersModel>  dealersModels;
    public static List<ProductListModel>  productListModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowHeight = displayMetrics.heightPixels;
        int windowWidth = displayMetrics.widthPixels;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // setTitle("Oman Discount");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
		displaySelectedScreen(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(HomePage.this,MapActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
		
		displaySelectedScreen(item.getItemId());
        return true;
	}
	@SuppressLint("NewApi")
    private void displaySelectedScreen(int id) {
        // int id = item.getItemId();
        Fragment fragment=null;
        if (id == R.id.nav_home){
            fragment=new Home();
        } else if (id == R.id.nav_todaydeal) {
            fragment=new TodaysDeal();

        } else if (id == R.id.nav_featured) {
            fragment=new Featured();

        } else if (id == R.id.nav_category) {
            fragment=new Category();

        } else if (id == R.id.nav_dealer) {
            fragment=new Dealers();

        } else if (id == R.id.nav_settings) {
            fragment=new Settings();

        } else if (id == R.id.nav_contact) {
            fragment=new ContactUs();

        } else if (id == R.id.nav_logout)
        {
            finishAffinity();
            System.exit(0);

        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack("Home");
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
