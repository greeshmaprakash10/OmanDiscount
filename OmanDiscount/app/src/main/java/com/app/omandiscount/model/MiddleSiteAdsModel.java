package com.app.omandiscount.model;

/**
 * Created by Rj on 4/13/2018.
 */

public class MiddleSiteAdsModel {
    String footer_banner_id,footer_banner_advertisement_id,footer_banner_img;

    public MiddleSiteAdsModel(String footer_banner_id, String footer_banner_advertisement_id, String footer_banner_img) {
        this.footer_banner_id = footer_banner_id;
        this.footer_banner_advertisement_id = footer_banner_advertisement_id;
        this.footer_banner_img = footer_banner_img;
    }

    public String getFooter_banner_id() {
        return footer_banner_id;
    }

    public String getFooter_banner_advertisement_id() {
        return footer_banner_advertisement_id;
    }

    public String getFooter_banner_img() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+footer_banner_img;
    }
}
