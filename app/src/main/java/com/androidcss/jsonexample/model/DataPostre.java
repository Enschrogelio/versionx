package com.androidcss.jsonexample.model;

/**
 * Created by x on 9/7/2016.
 */
public class DataPostre {

    public String fishImage;
    public String fishName;
    public String catName;
    public String sizeName;
    public int price;

    public DataPostre() {
        this.fishName = fishName;
        this.fishImage = fishImage;
    }

    public String getFishName() {
        return fishName;
    }
    public String getName() {
        return catName;
    }
    public int getPrice() {
        return price;
    }

    public String getImage_url() {
        return fishImage;
    }

    public String getSizeName() {
        return sizeName;
    }
}
