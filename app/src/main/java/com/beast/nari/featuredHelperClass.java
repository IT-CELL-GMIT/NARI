package com.beast.nari;

public class featuredHelperClass {

    int image;
    String tittle,desc;

    public featuredHelperClass(int image, String tittle, String desc) {
        this.image = image;
        this.tittle = tittle;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDesc() {
        return desc;
    }
}
