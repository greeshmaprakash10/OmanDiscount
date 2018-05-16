package com.app.omandiscount.Activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.omandiscount.R;
import com.app.omandiscount.Utility.OnMapAndViewReadyListener;
import com.app.omandiscount.model.DealersModel;
import com.app.omandiscount.model.TodaysDealModel;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.Text;

public class DealersDetails extends AppCompatActivity  implements
        GoogleMap.OnInfoWindowCloseListener,
        OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener
{
        DealersModel dealersModel;
        private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dealers_details);
        String title="Dealer's Details";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        try
        {
            dealersModel= (DealersModel) getIntent().getSerializableExtra("model");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ImageView delr=(ImageView)findViewById(R.id.iv_delear_image);
        TextView description=(TextView)findViewById(R.id.dealer_details);
        TextView address=(TextView)findViewById(R.id.dealer_address);
        TextView phone=(TextView)findViewById(R.id.dealer_num);
        TextView email=(TextView)findViewById(R.id.dealer_email);
        TextView website=(TextView)findViewById(R.id.dealer_website);

        try {
            Glide.with(getApplicationContext()).load(dealersModel.getVendor_logo()).into(delr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        description.setText(dealersModel.getVendor_description());
        address.setText(dealersModel.getVendor_address());
        phone.setText(dealersModel.getVendor_contact_no());
        email.setText(dealersModel.getVendor_email());
        website.setText(dealersModel.getVendor_website());


        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        new OnMapAndViewReadyListener(mapFragment, this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }
}
