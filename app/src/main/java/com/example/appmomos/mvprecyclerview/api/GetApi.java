package com.example.appmomos.mvprecyclerview.api;

import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.mime.TypedInput;

public interface GetApi
{
    @POST("/index.php?route=feed/new_change_api/getBrandNames&key=aQwerty")
    void getBrandNames(@Body TypedInput typedInput, Callback<BrandNames> brandNamesCallback);
}
