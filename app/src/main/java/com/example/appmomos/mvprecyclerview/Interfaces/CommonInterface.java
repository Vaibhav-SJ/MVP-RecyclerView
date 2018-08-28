package com.example.appmomos.mvprecyclerview.Interfaces;

import com.example.appmomos.mvprecyclerview.Presenters.MainActivityPresenter;
import com.example.appmomos.mvprecyclerview.SetterGetter.RecyclerData;

import java.util.List;

public interface CommonInterface
{

    interface modelInterface
    {
        void makeRecyclerDataReady(MainActivityPresenter mainActivityPresenter);
    }


    interface viewInterface
    {
        void  showLoaderFun();
        void  hideLoaderFun();
        void setAdapter(List<RecyclerData> data);
    }


    interface presenterInterface
    {
        void getData();
        void recyclerDataReadyStatus(List<RecyclerData> data);
    }





}
