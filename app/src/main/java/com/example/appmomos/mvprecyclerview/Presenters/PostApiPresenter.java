package com.example.appmomos.mvprecyclerview.Presenters;

import android.content.Context;

import com.example.appmomos.mvprecyclerview.Interfaces.PostApiCommonInterface;
import com.example.appmomos.mvprecyclerview.Models.PostApiModel;
import com.example.appmomos.mvprecyclerview.Views.PostApiActivity;
import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import java.util.List;

public class PostApiPresenter implements PostApiCommonInterface.presenterInterface
{

    private PostApiCommonInterface.viewInterface viewInterface;
    private PostApiCommonInterface.modelInterface modelInterface;

    public PostApiPresenter(PostApiActivity postApiActivity)
    {
        viewInterface = postApiActivity;
        modelInterface = new PostApiModel();
    }

    @Override
    public void getData(Context context, String brandName)
    {
        viewInterface.showLoaderFun();
        modelInterface.getRecyclerData(this,context,brandName);
    }

    @Override
    public void getRecyclerViewItems(List<SubBrands.SubBrandsBean> subBrandsBeanList)
    {
        viewInterface.setAdapterFun(subBrandsBeanList);
        viewInterface.hideLoaderFun();
    }

    @Override
    public void apiFailFun(String msg)
    {
        viewInterface.ifNoDataFun(msg);
        viewInterface.hideLoaderFun();

    }
}
