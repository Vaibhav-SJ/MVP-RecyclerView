package com.example.appmomos.mvprecyclerview;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestJsonFun
{
    public static JSONObject getBrandNames()
    {
        return new JSONObject();
    }



    public static JSONObject getSubBrands(String brandName)
    {
        JSONObject object = new JSONObject();
        try {
            object.put("brandName",brandName);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return object;
    }


}
