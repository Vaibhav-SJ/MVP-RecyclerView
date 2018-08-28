package com.example.appmomos.mvprecyclerview.pojo;

import java.util.List;

public class SubBrands
{

    /**
     * success : true
     * subBrands : [{"subBrand":"Control Gears and Accessories","image":"http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00421-500x500.jpg"},{"subBrand":"Distribution Boards /Enclosures","image":"http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00210-500x500.jpg"},{"subBrand":"MCCBs and Accessories","image":"http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00265-500x500.jpg"},{"subBrand":"Protection Devices (MCB/RCCB/RCBO)","image":"http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00001-500x500.jpg"},{"subBrand":"Switch fuse units and Accessories","image":"http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00607-500x500.jpg"}]
     */

    private boolean success;
    /**
     * subBrand : Control Gears and Accessories
     * image : http://appmomos.com/walna_latest/image/cache/catalog/ABB/IM00421-500x500.jpg
     */

    private List<SubBrandsBean> subBrands;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<SubBrandsBean> getSubBrands() {
        return subBrands;
    }

    public void setSubBrands(List<SubBrandsBean> subBrands) {
        this.subBrands = subBrands;
    }

    public static class SubBrandsBean {
        private String subBrand;
        private String image;

        public String getSubBrand() {
            return subBrand;
        }

        public void setSubBrand(String subBrand) {
            this.subBrand = subBrand;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
