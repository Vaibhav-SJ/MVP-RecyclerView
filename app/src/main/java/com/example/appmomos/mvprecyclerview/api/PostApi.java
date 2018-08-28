package com.example.appmomos.mvprecyclerview.api;

import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.mime.TypedInput;

public interface PostApi
{
    @POST("/index.php?route=feed/new_change_api/getSubBrandsByBrand&key=aQwerty")
    void getSubBrands(@Body  TypedInput input, Callback<SubBrands> subBrandsCallback);
}
