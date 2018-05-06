package com.app.omandiscount.model;

import java.io.Serializable;

public class FeaturedModel implements Serializable
{
    String  ad_products_id,ad_products_advertisementid,ad_productsid,ad_products_image,ad_products_title,
            ad_products_prize,ad_products_offer,ad_products_description,ad_products_is_company,ad_products_companiesid;
    String  vendor_id,vendor_name,vendor_code,vendor_contact_no,vendor_email,vendor_address,vendor_logo,vendor_website,
            vendor_type,vendor_user_id,vendor_profile_id,vendor_latitude,vendor_longitude,vendor_location,vendor_crno,
            vendor_approval,vendor_description;
    String  activated_spcl_deals_offer,deal_products_offer;

    public FeaturedModel(String ad_products_id, String ad_products_advertisementid, String ad_productsid, String ad_products_image,
                         String ad_products_title, String ad_products_prize, String ad_products_offer, String ad_products_description,
                         String ad_products_is_company, String ad_products_companiesid, String vendor_id, String vendor_name,
                         String vendor_code, String vendor_contact_no, String vendor_email, String vendor_address, String vendor_logo,
                         String vendor_website, String vendor_type, String vendor_user_id, String vendor_profile_id,
                         String vendor_latitude, String vendor_longitude, String vendor_location, String vendor_crno,
                         String vendor_approval, String vendor_description, String activated_spcl_deals_offer,
                         String deal_products_offer)
    {
        this.ad_products_id = ad_products_id;
        this.ad_products_advertisementid = ad_products_advertisementid;
        this.ad_productsid = ad_productsid;
        this.ad_products_image = ad_products_image;
        this.ad_products_title = ad_products_title;
        this.ad_products_prize = ad_products_prize;
        this.ad_products_offer = ad_products_offer;
        this.ad_products_description = ad_products_description;
        this.ad_products_is_company = ad_products_is_company;
        this.ad_products_companiesid = ad_products_companiesid;
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.vendor_code = vendor_code;
        this.vendor_contact_no = vendor_contact_no;
        this.vendor_email = vendor_email;
        this.vendor_address = vendor_address;
        this.vendor_logo = vendor_logo;
        this.vendor_website = vendor_website;
        this.vendor_type = vendor_type;
        this.vendor_user_id = vendor_user_id;
        this.vendor_profile_id = vendor_profile_id;
        this.vendor_latitude = vendor_latitude;
        this.vendor_longitude = vendor_longitude;
        this.vendor_location = vendor_location;
        this.vendor_crno = vendor_crno;
        this.vendor_approval = vendor_approval;
        this.vendor_description = vendor_description;
        this.activated_spcl_deals_offer = activated_spcl_deals_offer;
        this.deal_products_offer = deal_products_offer;
    }

    public String getAd_products_id() {
        return ad_products_id;
    }

    public String getAd_products_advertisementid() {
        return ad_products_advertisementid;
    }

    public String getAd_productsid() {
        return ad_productsid;
    }

    public String getAd_products_image() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+ad_products_image;
    }

    public String getAd_products_title() {
        return ad_products_title;
    }

    public String getAd_products_prize() {
        return ad_products_prize;
    }

    public String getAd_products_offer() {
        return ad_products_offer;
    }

    public String getAd_products_description() {
        return ad_products_description;
    }

    public String getAd_products_is_company() {
        return ad_products_is_company;
    }

    public String getAd_products_companiesid() {
        return ad_products_companiesid;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public String getVendor_contact_no() {
        return vendor_contact_no;
    }

    public String getVendor_email() {
        return vendor_email;
    }

    public String getVendor_address() {
        return vendor_address;
    }

    public String getVendor_logo() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+vendor_logo;
    }

    public String getVendor_website() {
        return vendor_website;
    }

    public String getVendor_type() {
        return vendor_type;
    }

    public String getVendor_user_id() {
        return vendor_user_id;
    }

    public String getVendor_profile_id() {
        return vendor_profile_id;
    }

    public String getVendor_latitude() {
        return vendor_latitude;
    }

    public String getVendor_longitude() {
        return vendor_longitude;
    }

    public String getVendor_location() {
        return vendor_location;
    }

    public String getVendor_crno() {
        return vendor_crno;
    }

    public String getVendor_approval() {
        return vendor_approval;
    }

    public String getVendor_description() {
        return vendor_description;
    }

    public String getActivated_spcl_deals_offer() {
        return activated_spcl_deals_offer;
    }

    public String getDeal_products_offer() {
        return deal_products_offer;
    }
}
