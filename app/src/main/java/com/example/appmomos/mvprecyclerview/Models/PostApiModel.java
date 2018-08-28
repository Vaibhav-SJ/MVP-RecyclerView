package com.example.appmomos.mvprecyclerview.Models;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.appmomos.mvprecyclerview.Interfaces.PostApiCommonInterface;
import com.example.appmomos.mvprecyclerview.Presenters.PostApiPresenter;
import com.example.appmomos.mvprecyclerview.RequestJsonFun;
import com.example.appmomos.mvprecyclerview.ServiceGenerator.ServiceGenerator;
import com.example.appmomos.mvprecyclerview.api.PostApi;
import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class PostApiModel implements PostApiCommonInterface.modelInterface
{

    private PostApi postApi;

    private PostApiPresenter postApiPresenter;
    private Context context;

    @Override
    public void getRecyclerData(PostApiPresenter postApiPresenter, Context context, String brandName)
    {
        this.postApiPresenter = postApiPresenter;
        this.context = context;

        postApi = ServiceGenerator.createService(PostApi.class);

        if (isInternetOn())
        {
            getBrandNamesFun(brandName);
        }
        else
        {
            postApiPresenter.apiFailFun("No Internet.");
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

    private void getBrandNamesFun(String brandName)
    {
        TypedInput input = new TypedByteArray("application/json", RequestJsonFun.getSubBrands(brandName).toString().getBytes());

        postApi.getSubBrands(input, new Callback<SubBrands>()
        {
            @Override
            public void success(SubBrands subBrands, Response response)
            {
                if (subBrands.isSuccess())
                {
                    postApiPresenter.getRecyclerViewItems(subBrands.getSubBrands());
                }
                else
                {
                    postApiPresenter.apiFailFun("No Details Found.");
                }

            }

            @Override
            public void failure(RetrofitError error)
            {
                postApiPresenter.apiFailFun(String.valueOf(error));
            }
        });
    }


}
