package com.tianfeng.videoplyer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianfeng.videoplyer.R;
import com.tianfeng.videoplyer.fallsbean.Product;

import java.util.ArrayList;

/**
 * Created by LUY on 2016/6/6.
 */
public class FallsRecycleAdapter extends RecyclerView.Adapter<FallsRecycleAdapter.MasonryView> {

    private ArrayList<Product> products;
    private static RecycleItemClickListener itemClickListener;
    public FallsRecycleAdapter(ArrayList Pro, RecycleItemClickListener clickListener){
        this.products = Pro;
        this.itemClickListener = clickListener;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_falls_activity, viewGroup, false);
        return new MasonryView(view);

    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.imageView.setImageResource(products.get(position).getImg());
        masonryView.textView.setText(products.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public static class MasonryView extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.img_item_img );
            textView= (TextView) itemView.findViewById(R.id.tv_item_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view,this.getPosition());
        }
    }
}
