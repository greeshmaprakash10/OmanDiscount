package com.app.omandiscount.model;

/**
 * Created by NyesteVenture3 on 4/4/2018.
 */

public class TopSiteAddModel
{
    int siteadd_id,siteadd_advertisement_id; String siteadd_img;

    public TopSiteAddModel(int siteadd_id, int siteadd_advertisement_id, String siteadd_img) {
        this.siteadd_id = siteadd_id;
        this.siteadd_advertisement_id = siteadd_advertisement_id;
        this.siteadd_img = siteadd_img;
    }

    public int getSiteadd_id() {
        return siteadd_id;
    }

    public int getSiteadd_advertisement_id() {
        return siteadd_advertisement_id;
    }

    public String getSiteadd_img() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+siteadd_img;
    }
}
