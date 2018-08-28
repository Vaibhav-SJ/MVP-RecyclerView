package com.example.appmomos.mvprecyclerview.Interfaces;

import android.content.Context;

import com.example.appmomos.mvprecyclerview.Presenters.RecyclerViewByApiPresenter;
import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import java.util.List;

public interface ApiRecyclerViewCommonInterface
{
    interface modelInterface
    {
        void getRecyclerData(RecyclerViewByApiPresenter recyclerViewByApiPresenter, Context context);
    }

    interface viewInterface
    {
        void showLoaderFun();
        void hideLoaderFun();
        void setAdapterFun(List<BrandNames.BrandsBean> brandsBeanList);
        void ifNoDataFun(String msg);
    }

    interface presenterInterface
    {
        void getData(Context context);
        void getRecyclerViewItems(List<BrandNames.BrandsBean> brandsBeanList);
        void apiFailFun(String msg);
    }


}
