package com.example.appmomos.mvprecyclerview.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.Views.RecyclerViewByApiActivity;
import com.example.appmomos.mvprecyclerview.pojo.BrandNames;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ViewHolder>
{

    private Context context;
    private List<BrandNames.BrandsBean> brandsBeanList;

    public ApiAdapter(RecyclerViewByApiActivity recyclerViewByApiActivity, List<BrandNames.BrandsBean> brandsBeanList)
    {
        context = recyclerViewByApiActivity;
        this.brandsBeanList = brandsBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View view = LayoutInflater.from(context).inflate(R.layout.api_items,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.name.setText(brandsBeanList.get(i).getName());

    }

    @Override
    public int getItemCount() {
    return brandsBeanList.size();
}

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.name)
        TextView name;

        ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
