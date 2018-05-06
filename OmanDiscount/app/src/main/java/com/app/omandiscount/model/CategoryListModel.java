package com.app.omandiscount.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rj on 3/4/2018.
 */

public class CategoryListModel
{
        public static HashMap<String, List<String>> getData() {
    HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

    List<String> list1 = new ArrayList<String>();
    list1.add("Hummar");
    expandableListDetail.put("Building Materials",list1);
    list1 = new ArrayList<String>();
    list1.add("Menu");
    expandableListDetail.put("Food & Beverages",list1);

            list1 = new ArrayList<String>();
            list1.add("Softwares");
            list1.add("Website Designing");
            list1.add("Web Applications");
            list1.add("ERP Solutions");
            list1.add("Customised Software Development");
            expandableListDetail.put("IT",list1);

            list1 = new ArrayList<String>();
            list1.add("Balls");
            list1.add("Flying discs");
            list1.add("Cricket");
            list1.add("Football");
            list1.add("Badminton");
            list1.add("Cycling");
            expandableListDetail.put("Sports, Fitness & Outdoors",list1);

            list1 = new ArrayList<String>();
            list1.add("Mice");
            list1.add("Keyboards");
            list1.add("Routers");
            expandableListDetail.put("Computers & Accessories",list1);

            list1 = new ArrayList<String>();
            list1.add("Laptops");
            list1.add("Telivisions");
            list1.add("Printers");
            list1.add("Moniters");
            expandableListDetail.put("Electronics",list1);

            list1 = new ArrayList<String>();
            list1.add("Down for down-filled parkas");
            list1.add("Fur");
            list1.add("Outwear & Jackets");
            list1.add("Bottoms");
            list1.add("Weddings & Events");
            expandableListDetail.put("Clothing",list1);

            list1 = new ArrayList<String>();
            list1.add("Microwave oven");
            list1.add("air conditioner");
            list1.add("Refrigerators"); list1.add("Menu");
            list1.add("Electric water heater tank");

            expandableListDetail.put("Home Appliances",list1);


    return expandableListDetail;
}
}
