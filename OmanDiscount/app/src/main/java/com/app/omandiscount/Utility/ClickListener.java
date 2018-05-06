package com.app.omandiscount.Utility;


import com.app.omandiscount.model.ProductListModel;
import com.app.omandiscount.model.TodaysDealModel;

/**
 * Created by user on 21-Mar-18.
 */

public interface ClickListener {
    void onPositionClicked(TodaysDealModel item);
    void onPositionClicked(ProductListModel item);
}
