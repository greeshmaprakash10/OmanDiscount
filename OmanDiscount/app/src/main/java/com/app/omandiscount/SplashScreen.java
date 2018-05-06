package com.app.omandiscount;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.app.omandiscount.NavigationDrawer.HomePage;
import com.app.omandiscount.SqliteDatabase.VolleyAppController;
import com.app.omandiscount.model.BottomSiteModel;
import com.app.omandiscount.model.CategoryModel;
import com.app.omandiscount.model.DealersModel;
import com.app.omandiscount.model.FeaturedModel;
import com.app.omandiscount.model.MiddleSiteAdsModel;
import com.app.omandiscount.model.ProductModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.app.omandiscount.model.TopBannerModel;
import com.app.omandiscount.model.TopSiteAddModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static com.android.volley.VolleyLog.TAG;

public class SplashScreen extends Activity
{
    private Timer timer;
    private int i=0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        HomePage.todaysDealModels=new ArrayList<>();
        HomePage.topBannerModels=new ArrayList<>();
        HomePage.topSiteAddModels=new ArrayList<>();
        HomePage.featuredDatas=new ArrayList<>();
        HomePage.categoryModels=new ArrayList<>();
        HomePage.middleSiteAdsModels=new ArrayList<>();
        HomePage.productModels=new ArrayList<>();
        HomePage.dealersModels=new ArrayList<>();

        //TODO call sync
        try {
            new Loadtop_banner().execute("");
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

    public class LoadTodayDealsData extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/today_deal";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("today_deal");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.todaysDealModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<TodaysDealModel>>(){}.getType());
                                }
                            }
                            try {
                                new Loadtop_site_add().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());

                        try {
                            new Loadtop_site_add().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.todaysDealModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }
    public class Loadtop_banner extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/top_banner";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            try {
                                if (response != null) {
                                    JSONArray jsonArray = response.optJSONArray("banner");
                                    if (jsonArray.length() > 0) {
                                        Gson gson = new Gson();
                                        HomePage.topBannerModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<TopBannerModel>>(){}.getType());
                                    }
                                }
                                //TODO sync todaydeals
                                try {
                                    new LoadTodayDealsData().execute("");

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        //TODO sync todaydeals
                        try {
                            new LoadTodayDealsData().execute("");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.topBannerModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }
    public class Loadtop_site_add extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("top_ad");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.topSiteAddModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<TopSiteAddModel>>(){}.getType());
                                }
                            }
                            try {

                                new LoadFeaturedData().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        try {
                            new LoadFeaturedData().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);

            } catch (Exception e) {
                e.printStackTrace();
                HomePage.topSiteAddModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }

    public class LoadFeaturedData extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/featured";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {

                            try {
                                if (response != null) {
                                    JSONArray jsonArray = response.optJSONArray("featured");
                                    if (jsonArray.length() > 0) {
                                        Gson gson = new Gson();
                                        HomePage.featuredDatas= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<FeaturedModel>>(){}.getType());
                                    }
                                }
                                try {


                                    new LoadCategories().execute("");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();

                            }


                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        HomePage.featuredDatas=new ArrayList<>();
                        try {


                            new LoadCategories().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.featuredDatas=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }

    public class LoadCategories extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/categories";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("categories");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.categoryModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<CategoryModel>>(){}.getType());
                                }
                            }

                            try {
                                new LoadProduct().execute("");
                                //new LoadMiddleBanner().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        HomePage.categoryModels=new ArrayList<>();

                        try {


                            new LoadProduct().execute("");
                            //new LoadMiddleBanner().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);

            } catch (Exception e) {
                e.printStackTrace();
                HomePage.categoryModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }

    public class LoadMiddleBanner extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/middle_site_add";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("middle_ad");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.middleSiteAdsModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<MiddleSiteAdsModel>>(){}.getType());
                                }
                            }
                            try {

                                new LoadProduct().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        try {

                            new LoadProduct().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.middleSiteAdsModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }


    public class LoadProduct extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/product_bycategory";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("pro", response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("products");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.productModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<ProductModel>>(){}.getType());
                                }
                            }
                            try {

                                new LoadBottomBanner().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        HomePage.productModels=new ArrayList<>();
                        try {

                            new LoadBottomBanner().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.productModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }

    public class LoadBottomBanner extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/bottom_site_add";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            if (response != null) {
                                JSONArray jsonArray = response.optJSONArray("bottom_ad");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.bottomSiteModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<BottomSiteModel>>(){}.getType());
                                }
                            }
                            try {

                                new LoadDealersData().execute("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        HomePage.bottomSiteModels=new ArrayList<>();
                        try {

                            new LoadDealersData().execute("");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();
                HomePage.bottomSiteModels=new ArrayList<>();
            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }
    public class LoadDealersData extends AsyncTask<String, Void, String> {
        String link="http://www.omandiscount.com/omandiscount/index.php/api/products/all_dealers";
        private String downloadImage(String sUrl) {
            try {
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        link, (JSONObject) null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("dealer", response.toString());

                        try {
                            if (response != null) {

                                JSONArray jsonArray = response.optJSONArray("dealers");
                                if (jsonArray.length() > 0) {
                                    Gson gson = new Gson();
                                    HomePage.dealersModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<DealersModel>>(){}.getType());
                                }
                            }
                            try {

                                Intent intent =new Intent(SplashScreen.this,HomePage.class);
                                startActivity(intent);
                                // close this activity
                                finish();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        HomePage.dealersModels=new ArrayList<>();

                        try {
                            Intent intent =new Intent(SplashScreen.this,HomePage.class);
                            startActivity(intent);
                            // close this activity
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                // Adding request to request queue
                VolleyAppController.getInstance(SplashScreen.this).addToRequestQueue(jsonObjReq);




                //lists= ApiCalls.getTopSiteAdd("http://www.omandiscount.com/omandiscount/index.php/api/products/top_site_add",getContext());
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "";
        }

        @Override
        protected String doInBackground(String... params) {
            return downloadImage(params[0]);
        }

        protected void onPostExecute(String result) {


        }
    }
}
