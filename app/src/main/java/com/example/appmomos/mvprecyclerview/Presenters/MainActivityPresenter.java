package com.example.appmomos.mvprecyclerview.Presenters;

import com.example.appmomos.mvprecyclerview.Interfaces.CommonInterface;
import com.example.appmomos.mvprecyclerview.Models.MainActivityModel;
import com.example.appmomos.mvprecyclerview.SetterGetter.RecyclerData;
import com.example.appmomos.mvprecyclerview.Views.MainActivity;

import java.util.List;

public class MainActivityPresenter implements CommonInterface.presenterInterface
{

    private CommonInterface.viewInterface viewInterface;
    private CommonInterface.modelInterface modelInterface;

    public MainActivityPresenter(MainActivity mainActivity)
    {
        viewInterface = mainActivity;
        modelInterface = new MainActivityModel();
    }

    @Override
    public void getData()
    {
        viewInterface.showLoaderFun();

        modelInterface.makeRecyclerDataReady(this);
    }

    @Override
    public void recyclerDataReadyStatus(List<RecyclerData> data)
    {
        viewInterface.setAdapter(data);
        viewInterface.hideLoaderFun();
    }
}
