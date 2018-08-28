package com.example.appmomos.mvprecyclerview.Presenters;

import android.content.Context;

import com.example.appmomos.mvprecyclerview.Interfaces.ApiRecyclerViewCommonInterface;
import com.example.appmomos.mvprecyclerview.Models.RecyclerViewByApiModel;
import com.example.appmomos.mvprecyclerview.Views.RecyclerViewByApiActivity;
import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import java.util.List;

public class RecyclerViewByApiPresenter implements ApiRecyclerViewCommonInterface.presenterInterface
{

    private ApiRecyclerViewCommonInterface.viewInterface viewInterface;
    private ApiRecyclerViewCommonInterface.modelInterface modelInterface;

    public RecyclerViewByApiPresenter(RecyclerViewByApiActivity recyclerViewByApiActivity)
    {
        viewInterface = recyclerViewByApiActivity;
        modelInterface =  new RecyclerViewByApiModel();
    }

    @Override
    public void getData(Context context)
    {
        viewInterface.showLoaderFun();
        modelInterface.getRecyclerData(this,context);
    }

    @Override
    public void getRecyclerViewItems(List<BrandNames.BrandsBean> brandsBeanList)
    {
        viewInterface.setAdapterFun(brandsBeanList);
        viewInterface.hideLoaderFun();
    }

    @Override
    public void apiFailFun(String msg)
    {
        viewInterface.ifNoDataFun(msg);
        viewInterface.hideLoaderFun();
    }
}
