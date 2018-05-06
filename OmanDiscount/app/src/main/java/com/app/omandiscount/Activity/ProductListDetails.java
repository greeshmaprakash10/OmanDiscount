package com.app.omandiscount.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.omandiscount.R;
import com.app.omandiscount.model.ProductListModel;
import com.bumptech.glide.Glide;

public class ProductListDetails extends AppCompatActivity {
ProductListModel productMoldel;
TextView pvl_name,pvl_name_sub,pvl_offer,pvl_offer_sub,pvl_prize,pvl_prize_sub;
TextView pvl_featured,pvl_category,pvl_product,pvl_subcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productlistdetails);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        try {
            productMoldel= (ProductListModel) getIntent().getSerializableExtra("model");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView product=(ImageView)findViewById(R.id.iv_produc_pic);
        ImageView dealer=(ImageView)findViewById(R.id.iv_dealer_pic);
        ImageView rating=(ImageView)findViewById(R.id.iv_rating_chart);
        try {
            Glide.with(getApplicationContext()).load(productMoldel.getAd_products_image()).into(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(getApplicationContext()).load(productMoldel.getCategory_image()).into(dealer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Glide.with(getApplicationContext()).load(R.drawable.ratingchart).into(rating);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //setTitle("Product Details");
        String title="Product Details";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
       TextView tv = (TextView) findViewById(R.id.tv_mob_desrtion);
        pvl_name=(TextView)findViewById(R.id.pvl_name);
        pvl_name_sub=(TextView)findViewById(R.id.pvl_name_sub);
        pvl_offer=(TextView)findViewById(R.id.pvl_offer);
        pvl_offer_sub=(TextView)findViewById(R.id.pvl_offer_sub);
        pvl_prize=(TextView)findViewById(R.id.pvl_price);
        pvl_prize_sub=(TextView)findViewById(R.id.pvl_price_sub);
        pvl_featured=(TextView)findViewById(R.id.pvl_featured);
        pvl_category=(TextView)findViewById(R.id.pvl_category);
        pvl_subcat=(TextView)findViewById(R.id.pvl_subcat);
        pvl_product=(TextView)findViewById(R.id.pvl_product);


        pvl_name.setText(productMoldel.getAd_products_title());
        pvl_name_sub.setText(productMoldel.getAd_products_title());
        pvl_offer.setText(productMoldel.getAd_products_offer()+"%");
        pvl_offer_sub.setText(productMoldel.getAd_products_offer()+"%");
        pvl_prize.setText(productMoldel.getAd_products_prize());
        pvl_prize_sub.setText(productMoldel.getAd_products_prize());
        pvl_featured.setText(productMoldel.getFeatured_from());
        pvl_category.setText(productMoldel.getCategory_name());
        pvl_subcat.setText(productMoldel.getSubcategory_name());
        pvl_product.setText(productMoldel.getProducts_name());

        tv.setText(productMoldel.getAd_products_description());
        makeTextViewResizable(tv, 3, "See More >", true);
    }



    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                String text;
                int lineEndIndex;
                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    lineEndIndex = tv.getLayout().getLineEnd(0);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else {
                    lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                }
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(
                        addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                viewMore), TextView.BufferType.SPANNABLE);
            }
        });

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
