package com.app.omandiscount.model;

/**
 * Created by Rj on 4/1/2018.
 */

public class TopBannerModel {
    int banner_id,banner_advertisement_id; String banner_img;

    public TopBannerModel(int bannerId, int advertisementId, String bannerImage) {
        this.banner_id = bannerId;
        this.banner_advertisement_id = advertisementId;
        this.banner_img = bannerImage;
    }

    public int getBannerId() {
        return banner_id;
    }

    public int getAdvertisementId() {
        return banner_advertisement_id;
    }

    public String getBannerImage() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+banner_img;
    }
}
