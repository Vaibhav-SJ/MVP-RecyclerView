package com.example.appmomos.mvprecyclerview.Views;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmomos.mvprecyclerview.Adapters.ApiAdapter;
import com.example.appmomos.mvprecyclerview.Interfaces.ApiRecyclerViewCommonInterface;
import com.example.appmomos.mvprecyclerview.Presenters.RecyclerViewByApiPresenter;
import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewByApiActivity extends AppCompatActivity implements ApiRecyclerViewCommonInterface.viewInterface
{

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.loadingTxt)
    TextView loadingTxt;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ApiAdapter adapter;



    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_by_api);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Api Recycler View");

        RecyclerViewByApiPresenter recyclerViewByApiPresenter = new RecyclerViewByApiPresenter(this);
        recyclerViewByApiPresenter.getData(this);

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
    public void setAdapterFun(List<BrandNames.BrandsBean> brandsBeanList)
    {
        adapter = new ApiAdapter(RecyclerViewByApiActivity.this,brandsBeanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void ifNoDataFun(String msg) {
        Toast.makeText(RecyclerViewByApiActivity.this,msg,Toast.LENGTH_LONG).show();
    }
}
