package com.app.omandiscount.model;

import java.util.List;

/**
 * Created by Rj on 4/9/2018.
 */

public class ProductModel {
    String category_id, category_name;
    List<ProductListModel> product_list;

    public ProductModel(String category_id, String category_name, List<ProductListModel> product_list) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.product_list = product_list;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public List<ProductListModel> getProduct_list() {
        return product_list;
    }
}
