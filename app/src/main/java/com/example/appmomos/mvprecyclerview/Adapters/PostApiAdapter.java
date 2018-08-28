package com.example.appmomos.mvprecyclerview.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appmomos.mvprecyclerview.R;
import com.example.appmomos.mvprecyclerview.Views.PostApiActivity;
import com.example.appmomos.mvprecyclerview.pojo.SubBrands;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostApiAdapter extends RecyclerView.Adapter<PostApiAdapter.ViewHolder>
{

    private Context context;
    private List<SubBrands.SubBrandsBean> subBrandsBeanList;

    public PostApiAdapter(PostApiActivity postApiActivity, List<SubBrands.SubBrandsBean> subBrandsBeanList)
    {
        context = postApiActivity;
        this.subBrandsBeanList = subBrandsBeanList;
    }

    @NonNull
    @Override
    public PostApiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View view = LayoutInflater.from(context).inflate(R.layout.post_api_items,viewGroup,false);
        return new PostApiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostApiAdapter.ViewHolder viewHolder, int i)
    {
        Glide.with(context).load(subBrandsBeanList.get(i).getImage()).into(viewHolder.imageView);
        viewHolder.name.setText(subBrandsBeanList.get(i).getSubBrand());

    }

    @Override
    public int getItemCount() {
        return subBrandsBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.img)
        ImageView imageView;


        ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

