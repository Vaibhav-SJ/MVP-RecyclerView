package com.example.appmomos.mvprecyclerview.pojo;

import java.util.List;

public class BrandNames
{

    /**
     * success : true
     * brands : [{"name":"ABB"},{"name":"HAGER"},{"name":"INDO ASIAN"},{"name":"LEGRAND"},{"name":"Neptune"},{"name":"SCHNEIDER"}]
     */

    private boolean success;
    /**
     * name : ABB
     */

    private List<BrandsBean> brands;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<BrandsBean> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandsBean> brands) {
        this.brands = brands;
    }

    public static class BrandsBean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
