package com.app.omandiscount.model;

import java.io.Serializable;

public class DealersModel implements Serializable
{
    String vendor_id,vendor_name,vendor_code,vendor_contact_no,vendor_email,vendor_address,vendor_logo;
    String vendor_website,vendor_type,vendor_user_id,vendor_profile_id,vendor_lattitude,vendor_longitude;
    String vendor_location,vendor_crno,vendor_approval,vendor_description;

    public DealersModel(String vendor_id, String vendor_name, String vendor_code,
                        String vendor_contact_no, String vendor_email, String vendor_address,
                        String vendor_logo, String vendor_website, String vendor_type,
                        String vendor_user_id, String vendor_profile_id, String vendor_lattitude,
                        String vendor_longitude, String vendor_location, String vendor_crno,
                        String vendor_approval, String vendor_description)
    {
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
        this.vendor_lattitude = vendor_lattitude;
        this.vendor_longitude = vendor_longitude;
        this.vendor_location = vendor_location;
        this.vendor_crno = vendor_crno;
        this.vendor_approval = vendor_approval;
        this.vendor_description = vendor_description;
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

    public String getVendor_lattitude() {
        return vendor_lattitude;
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
