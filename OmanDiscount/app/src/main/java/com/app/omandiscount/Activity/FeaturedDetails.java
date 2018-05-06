package com.app.omandiscount.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.model.FeaturedModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;

import static com.app.omandiscount.Activity.ProductListDetails.makeTextViewResizable;

public class FeaturedDetails extends AppCompatActivity
{
    FeaturedModel todaysDealModel;
    TextView pro_name,pronamesub,pro_price,pro_price_sub,pro_offer,pro_offer_sub;
    TextView deal_add,deal_email,deal_ph,deal_web;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_featured_details);
        try {
            todaysDealModel= (FeaturedModel) getIntent().getSerializableExtra("model");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView product=(ImageView)findViewById(R.id.f_iv_produc_pic);
        ImageView dealer=(ImageView)findViewById(R.id.f_iv_dealer_pic);
        ImageView rating=(ImageView)findViewById(R.id.iv_rating_chart);

        try {
            Glide.with(getApplicationContext()).load(todaysDealModel.getAd_products_image()).into(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(getApplicationContext()).load(todaysDealModel.getVendor_logo()).into(dealer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(getApplicationContext()).load(R.drawable.ratingchart).into(rating);
        } catch (Exception e) {
            e.printStackTrace();
        }


        TextView tv = (TextView) findViewById(R.id.f_tv_mob_desrtion);
        pro_name=(TextView)findViewById(R.id.f_pro_name);
        pronamesub=(TextView)findViewById(R.id.f_pro_name_sub);
        pro_offer=(TextView)findViewById(R.id.f_pro_offer);
        pro_offer_sub=(TextView)findViewById(R.id.f_pro_offer_sub);
        pro_price=(TextView)findViewById(R.id.f_pro_price);
        pro_price_sub=(TextView)findViewById(R.id.f_pro_price_sub);
        deal_add=(TextView)findViewById(R.id.f_deal_web);
        deal_email=(TextView)findViewById(R.id.f_deal_email);
        deal_ph=(TextView)findViewById(R.id.f_deal_ph);
        deal_web=(TextView)findViewById(R.id.f_deal_web);

        tv.setText(todaysDealModel.getAd_products_description());
        pro_name.setText(todaysDealModel.getAd_products_title());
        pronamesub.setText(todaysDealModel.getAd_products_title());
        pro_offer.setText(todaysDealModel.getAd_products_offer()+" %");
        pro_offer_sub.setText(todaysDealModel.getAd_products_offer()+" %");
        pro_price.setText(todaysDealModel.getAd_products_prize());
        pro_price_sub.setText(todaysDealModel.getAd_products_prize());
        deal_add.setText(todaysDealModel.getVendor_address());
        deal_email.setText(todaysDealModel.getVendor_email());
        deal_ph.setText(todaysDealModel.getVendor_contact_no());
        deal_web.setText(todaysDealModel.getVendor_website());
        makeTextViewResizable(tv, 3, "See More >", true);
        String title="Product Details";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);


    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new ClickableSpan() {

                @Override
                public void onClick(View widget) {
                    tv.setLayoutParams(tv.getLayoutParams());
                    tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    if (viewMore) {
                        makeTextViewResizable(tv, -1, "See Less >", false);
                    } else {
                        makeTextViewResizable(tv, 3, "See More >", true);
                    }

                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }
}
