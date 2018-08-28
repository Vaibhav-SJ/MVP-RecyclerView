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

import com.example.appmomos.mvprecyclerview.Adapters.MyAdapter;
import com.example.appmomos.mvprecyclerview.Interfaces.CommonInterface;
import com.example.appmomos.mvprecyclerview.Presenters.MainActivityPresenter;
import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.SetterGetter.RecyclerData;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements CommonInterface.viewInterface
{

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.loadingTxt)
    TextView loadingTxt;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MyAdapter adapter;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this);
        mainActivityPresenter.getData();

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Recycler View Exp");
    }

    @Override
    public void showLoaderFun() {
        loadingTxt.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoaderFun() {
        loadingTxt.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAdapter(List<RecyclerData> data)
    {
        adapter = new MyAdapter(MainActivity.this,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
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
}
