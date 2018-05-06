package com.app.omandiscount.model;

import java.io.Serializable;

/**
 * Created by Rj on 4/13/2018.
 */

public class ProductListModel implements Serializable{
    String ad_products_id,ad_products_advertisementid,ad_productsid,ad_products_image,ad_products_title,
            ad_products_prize,ad_products_offer,ad_products_description,ad_products_is_company,ad_products_companiesid
            ,products_id,products_name,subcategoryid,products_description,subcategory_id,subcategory_name,categoryid,
            subcategory_description,category_id,category_name,category_description,category_image,product_count,
            featured_id,featured_from,featured_to,featured_advertisement_id,status,featured_deactivation,
            advertisement_id,advertisement_vendor,advertisement_rechargeid,advertisement_title,
            advertisement_description,advertisement_date,advertisement_to_date,advertisement_status,advertisement_deactivation;

    public ProductListModel(String ad_products_id, String ad_products_advertisementid,
                            String ad_productsid, String ad_products_image,
                            String ad_products_title, String ad_products_prize,
                            String ad_products_offer, String ad_products_description,
                            String ad_products_is_company, String ad_products_companiesid,
                            String products_id, String products_name, String subcategoryid,
                            String products_description, String subcategory_id,
                            String subcategory_name, String categoryid, String subcategory_description,
                            String category_id, String category_name, String category_description,
                            String category_image, String product_count, String featured_id,
                            String featured_from, String featured_to, String featured_advertisement_id,
                            String status, String featured_deactivation, String advertisement_id,
                            String advertisement_vendor, String advertisement_rechargeid,
                            String advertisement_title, String advertisement_description,
                            String advertisement_date, String advertisement_to_date,
                            String advertisement_status, String advertisement_deactivation) {
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
        this.products_id = products_id;
        this.products_name = products_name;
        this.subcategoryid = subcategoryid;
        this.products_description = products_description;
        this.subcategory_id = subcategory_id;
        this.subcategory_name = subcategory_name;
        this.categoryid = categoryid;
        this.subcategory_description = subcategory_description;
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.category_image = category_image;
        this.product_count = product_count;
        this.featured_id = featured_id;
        this.featured_from = featured_from;
        this.featured_to = featured_to;
        this.featured_advertisement_id = featured_advertisement_id;
        this.status = status;
        this.featured_deactivation = featured_deactivation;
        this.advertisement_id = advertisement_id;
        this.advertisement_vendor = advertisement_vendor;
        this.advertisement_rechargeid = advertisement_rechargeid;
        this.advertisement_title = advertisement_title;
        this.advertisement_description = advertisement_description;
        this.advertisement_date = advertisement_date;
        this.advertisement_to_date = advertisement_to_date;
        this.advertisement_status = advertisement_status;
        this.advertisement_deactivation = advertisement_deactivation;
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

    public String getProducts_id() {
        return products_id;
    }

    public String getProducts_name() {
        return products_name;
    }

    public String getSubcategoryid() {
        return subcategoryid;
    }

    public String getProducts_description() {
        return products_description;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public String getSubcategory_description() {
        return subcategory_description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public String getCategory_image() {
        return "http://www.omandiscount.com/omandiscount/assets/uploads/"+category_image;
    }

    public String getProduct_count() {
        return product_count;
    }

    public String getFeatured_id() {
        return featured_id;
    }

    public String getFeatured_from() {
        return featured_from;
    }

    public String getFeatured_to() {
        return featured_to;
    }

    public String getFeatured_advertisement_id() {
        return featured_advertisement_id;
    }

    public String getStatus() {
        return status;
    }

    public String getFeatured_deactivation() {
        return featured_deactivation;
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
}
