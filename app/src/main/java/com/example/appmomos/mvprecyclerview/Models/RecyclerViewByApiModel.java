package com.example.appmomos.mvprecyclerview.Models;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.appmomos.mvprecyclerview.Interfaces.ApiRecyclerViewCommonInterface;
import com.example.appmomos.mvprecyclerview.Presenters.RecyclerViewByApiPresenter;
import com.example.appmomos.mvprecyclerview.RequestJsonFun;
import com.example.appmomos.mvprecyclerview.ServiceGenerator.ServiceGenerator;
import com.example.appmomos.mvprecyclerview.api.GetApi;
import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class RecyclerViewByApiModel implements ApiRecyclerViewCommonInterface.modelInterface
{
    private GetApi getApi;

     private RecyclerViewByApiPresenter recyclerViewByApiPresenter;
    private Context context;

    @Override
    public void getRecyclerData(RecyclerViewByApiPresenter recyclerViewByApiPresenter, Context context)
    {
        this.recyclerViewByApiPresenter = recyclerViewByApiPresenter;
        this.context = context;

        getApi = ServiceGenerator.createService(GetApi.class);

        if (isInternetOn())
        {
            getBrandNamesFun();
        }
        else
        {
            recyclerViewByApiPresenter.apiFailFun("No Internet.");
        }

    }


    private boolean isInternetOn()
    {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check for network connections
        assert connec != null;
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {

            return false;
        }
        return false;
    }

    private void getBrandNamesFun()
    {
        TypedInput input = new TypedByteArray("application/json", RequestJsonFun.getBrandNames().toString().getBytes());

        getApi.getBrandNames(input, new Callback<BrandNames>() {
            @Override
            public void success(BrandNames brandNames, Response response)
            {
                if (brandNames.isSuccess())
                {
                    recyclerViewByApiPresenter.getRecyclerViewItems(brandNames.getBrands());
                }
                else
                {
                    recyclerViewByApiPresenter.apiFailFun("No Details Found.");
                }
            }

            @Override
            public void failure(RetrofitError error)
            {
                recyclerViewByApiPresenter.apiFailFun(String.valueOf(error));
            }
        });
    }
}
