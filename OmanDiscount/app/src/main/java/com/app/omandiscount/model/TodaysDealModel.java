package com.app.omandiscount.model;

import java.io.Serializable;

/**
 * Created by NyesteVenture3 on 4/5/2018.
 */

public class TodaysDealModel implements Serializable
{
    String todays_deals_id,todays_deals_productid,deals_from_date,deals_to_date;
    String todays_deals_deactivation,todays_deals_status,deal_products_offer,ad_products_id;
    String ad_products_advertisementid,ad_productsid,ad_products_image,ad_products_title;
    String ad_products_prize,ad_products_offer,ad_products_description,ad_products_is_company;
     String ad_products_companiesid,advertisement_id,advertisement_vendor,advertisement_rechargeid,
             advertisement_title,advertisement_description,advertisement_date,advertisement_to_date,
             advertisement_status,advertisement_deactivation,vendor_id,vendor_name,vendor_code,vendor_contact_no,
             vendor_email,vendor_address,vendor_logo,vendor_website,vendor_type,
             vendor_user_id,vendor_profile_id,vendor_latitude,vendor_longitude,
             vendor_location,vendor_crno,vendor_approval,vendor_description;


    public TodaysDealModel(String todays_deals_id, String todays_deals_productid,
                           String deals_from_date, String deals_to_date, String todays_deals_deactivation,
                           String todays_deals_status, String deal_products_offer, String ad_products_id,
                           String ad_products_advertisementid, String ad_productsid, String ad_products_image,
                           String ad_products_title, String ad_products_prize, String ad_products_offer,
                           String ad_products_description, String ad_products_is_company, String ad_products_companiesid,
                           String advertisement_id, String advertisement_vendor, String advertisement_rechargeid,
                           String advertisement_title, String advertisement_description, String advertisement_date,
                           String advertisement_to_date, String advertisement_status, String advertisement_deactivation,
                           String vendor_id, String vendor_name, String vendor_code, String vendor_contact_no,
                           String vendor_email, String vendor_address, String vendor_logo, String vendor_website,
                           String vendor_type, String vendor_user_id, String vendor_profile_id, String vendor_latitude,
                           String vendor_longitude, String vendor_location, String vendor_crno, String vendor_approval, String vendor_description) {
        this.todays_deals_id = todays_deals_id;
        this.todays_deals_productid = todays_deals_productid;
        this.deals_from_date = deals_from_date;
        this.deals_to_date = deals_to_date;
        this.todays_deals_deactivation = todays_deals_deactivation;
        this.todays_deals_status = todays_deals_status;
        this.deal_products_offer = deal_products_offer;
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
        this.advertisement_id = advertisement_id;
        this.advertisement_vendor = advertisement_vendor;
        this.advertisement_rechargeid = advertisement_rechargeid;
        this.advertisement_title = advertisement_title;
        this.advertisement_description = advertisement_description;
        this.advertisement_date = advertisement_date;
        this.advertisement_to_date = advertisement_to_date;
        this.advertisement_status = advertisement_status;
        this.advertisement_deactivation = advertisement_deactivation;
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
    }

    public String getTodays_deals_id() {
        return todays_deals_id;
    }

    public String getTodays_deals_productid() {
        return todays_deals_productid;
    }

    public String getDeals_from_date() {
        return deals_from_date;
    }

    public String getDeals_to_date() {
        return deals_to_date;
    }

    public String getTodays_deals_deactivation() {
        return todays_deals_deactivation;
    }

    public String getTodays_deals_status() {
        return todays_deals_status;
    }

    public String getDeal_products_offer() {
        return deal_products_offer;
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

    public String getAdvertisement_id() {
        return advertisement_id;
    }

    public String getAdvertisement_vendor() {
        return advertisement_vendor;
    }

    public String getAdvertisement_rechargeid() {
        return advertisement_rechargeid;
    }

    public String getAdvertisement_title() {
        return advertisement_title;
    }

    public String getAdvertisement_description() {
        return advertisement_description;
    }

    public String getAdvertisement_date() {
        return advertisement_date;
    }

    public String getAdvertisement_to_date() {
        return advertisement_to_date;
    }

    public String getAdvertisement_status() {
        return advertisement_status;
    }

    public String getAdvertisement_deactivation() {
        return advertisement_deactivation;
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
}
