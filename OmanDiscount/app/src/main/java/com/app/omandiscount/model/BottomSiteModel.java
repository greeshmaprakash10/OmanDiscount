package com.app.omandiscount.model;

/**
 * Created by Rj on 4/13/2018.
 */

public class BottomSiteModel {
    String siteadd_id,siteadd_advertisement_id,siteadd_img;

    public BottomSiteModel(String siteadd_id, String siteadd_advertisement_id, String siteadd_img) {
        this.siteadd_id = siteadd_id;
        this.siteadd_advertisement_id = siteadd_advertisement_id;
        this.siteadd_img = siteadd_img;
    }

    public String getSiteadd_id() {
        return siteadd_id;
    }

    public String getSiteadd_advertisement_id() {
        return siteadd_advertisement_id;
    }

    public String getSiteadd_img() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+siteadd_img;
    }
}
