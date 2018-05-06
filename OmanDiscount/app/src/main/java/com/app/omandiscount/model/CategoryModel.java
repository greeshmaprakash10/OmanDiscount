package com.app.omandiscount.model;

/**
 * Created by NyesteVenture3 on 4/7/2018.
 */

public class CategoryModel
{
    String category_id,category_name; String category_description,category_image,product_count;

    public CategoryModel(String category_id, String category_name, String category_description, String category_image, String product_count) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.category_image = category_image;
        this.product_count = product_count;
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
}
