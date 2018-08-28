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
import com.example.appmomos.mvprecyclerview.SetterGetter.RecyclerData;
import com.example.appmomos.mvprecyclerview.Views.MainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    private Context context;
    private List<RecyclerData> data;

    public MyAdapter(MainActivity mainActivity, List<RecyclerData> data)
    {
        context = mainActivity;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.items,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        Glide.with(context).load(data.get(i).getImage()).into(viewHolder.imageView);
        viewHolder.name.setText(data.get(i).getName());
        viewHolder.caption.setText(data.get(i).getCaption());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.caption)
        TextView caption;

        @BindView(R.id.img)
        ImageView imageView;

        ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
