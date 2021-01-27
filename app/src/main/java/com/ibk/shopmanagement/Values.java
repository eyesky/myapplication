package com.ibk.shopmanagement;

import java.util.ArrayList;

public class Values {

//    public static final String TYPE_MIRROR = "MIRROR";
//    public static final String TYPE_METAL = "METAL";
//    public static final String TYPE_PLASTIC = "PLASTIC";

    public enum productType {
        MIRROR, METAL, PLASTIC, OTHERS;
    }

    public static ArrayList<String> getProductTypeData() {
        ArrayList<String> items = new ArrayList<>();
        items.add(productType.MIRROR.name());
        items.add(productType.METAL.name());
        items.add(productType.PLASTIC.name());
        items.add(productType.OTHERS.name());
        return items;
    }
}
