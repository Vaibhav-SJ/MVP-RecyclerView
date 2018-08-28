package com.example.appmomos.mvprecyclerview.Models;

import com.example.appmomos.mvprecyclerview.Interfaces.CommonInterface;
import com.example.appmomos.mvprecyclerview.Presenters.MainActivityPresenter;
import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.SetterGetter.RecyclerData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityModel implements CommonInterface.modelInterface
{


    @Override
    public void makeRecyclerDataReady(MainActivityPresenter mainActivityPresenter)
    {
        List<RecyclerData> data = fill_data();
        mainActivityPresenter.recyclerDataReadyStatus(data);
    }

    private List<RecyclerData> fill_data()
    {
        List<RecyclerData> data = new ArrayList<>();

        data.add(new RecyclerData(R.drawable.bean,"Bean","Actor"));
        data.add(new RecyclerData(R.drawable.jerry,"Jerry","The Mouse"));
        data.add(new RecyclerData(R.drawable.john,"John","Actor"));
        data.add(new RecyclerData(R.drawable.msd,"M.S.Dhoni","Cricketer"));
        data.add(new RecyclerData(R.drawable.samanta,"Samanta","Actress"));
        data.add(new RecyclerData(R.drawable.shruti,"Shruti","Actress"));
        data.add(new RecyclerData(R.drawable.srk,"King Khan","Actor"));
        data.add(new RecyclerData(R.drawable.sudeep,"Sudeep","Actor"));
        data.add(new RecyclerData(R.drawable.tom,"Tom","The Cat"));
        data.add(new RecyclerData(R.drawable.yuvi,"Yuvi","Cricketer"));
        return data;
    }
}
