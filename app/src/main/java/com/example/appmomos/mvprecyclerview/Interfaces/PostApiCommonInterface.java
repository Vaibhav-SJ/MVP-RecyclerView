package com.example.appmomos.mvprecyclerview.Interfaces;

import android.content.Context;

import com.example.appmomos.mvprecyclerview.pojo.BrandNames;
import com.example.appmomos.mvprecyclerview.Presenters.PostApiPresenter;
import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import java.util.List;

public interface PostApiCommonInterface
{
    interface modelInterface
    {
        void getRecyclerData(PostApiPresenter recyclerViewByApiPresenter, Context context, String brandName);
    }

    interface viewInterface
    {
        void showLoaderFun();
        void hideLoaderFun();
        void setAdapterFun(List<SubBrands.SubBrandsBean> subBrandsBeanList);
        void ifNoDataFun(String msg);
    }

    interface presenterInterface
    {
        void getData(Context context,String brandName);
        void getRecyclerViewItems(List<SubBrands.SubBrandsBean> subBrandsBeanList);
        void apiFailFun(String msg);
    }

}
