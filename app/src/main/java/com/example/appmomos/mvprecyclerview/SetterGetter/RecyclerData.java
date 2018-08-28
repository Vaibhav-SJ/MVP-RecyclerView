package com.example.appmomos.mvprecyclerview.SetterGetter;

public class RecyclerData
{
    private int image;
    private String name;
    private String caption;


    public RecyclerData(int image, String name, String caption)
    {
        this.image = image;
        this.name = name;
        this.caption = caption;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
