package com.example.appmomos.mvprecyclerview.Views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmomos.mvprecyclerview.Adapters.PostApiAdapter;
import com.example.appmomos.mvprecyclerview.Interfaces.PostApiCommonInterface;
import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.Presenters.PostApiPresenter;
import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostApiActivity extends AppCompatActivity implements PostApiCommonInterface.viewInterface
{
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.loadingTxt)
    TextView loadingTxt;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String brandName = "ABB";

    PostApiAdapter adapter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_api);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Post Api Recycler View");

        PostApiPresenter postApiPresenter = new PostApiPresenter(this);
        postApiPresenter.getData(this,brandName);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showLoaderFun()
    {
        loadingTxt.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoaderFun()
    {
        recyclerView.setVisibility(View.VISIBLE);
        loadingTxt.setVisibility(View.GONE);
    }


    @Override
    public void setAdapterFun(List<SubBrands.SubBrandsBean> subBrandsBeanList) {
        adapter = new PostApiAdapter(PostApiActivity.this,subBrandsBeanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void ifNoDataFun(String msg) {
        Toast.makeText(PostApiActivity.this,msg,Toast.LENGTH_LONG).show();
        Log.d("errorMSg",msg);
    }
}
