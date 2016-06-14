package com.tianfeng.videoplyer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tianfeng.videoplyer.adapter.FallsRecycleAdapter;
import com.tianfeng.videoplyer.adapter.RecycleItemClickListener;
import com.tianfeng.videoplyer.fallsbean.Product;
import com.tianfeng.videoplyer.uiutls.SpacesItemDecoration;

import java.util.ArrayList;

/**
 * Created by LUY on 2016/6/6.
 */
public class FallsActivity extends Activity {
    private RecyclerView recyclerFalls;
    private ArrayList<Product> products;
    private FallsRecycleAdapter adapter;
    private int[] img = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R.mipmap.p4, R.mipmap.p5, R.mipmap.p6};
    private String[] title = new String[]{"照片", "花花草草", "美女", "风景", "房子", "狗狗"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falls);
        initData();
        initView();
    }

    private void initView() {
        recyclerFalls = (RecyclerView) findViewById(R.id.rcy_recycler_falls);
        //设置2行2列垂直
        recyclerFalls.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration de = new SpacesItemDecoration(16);
        recyclerFalls.addItemDecoration(de);

        RecycleItemClickListener itemClickListener = new RecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("TAG", position + "我");
                Toast.makeText(FallsActivity.this, products.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        };

        if (adapter == null) {
            adapter = new FallsRecycleAdapter(products, itemClickListener);
            recyclerFalls.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        products = new ArrayList();
        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < 6; i++) {
                Product P = new Product(img[i], title[i]);
                products.add(P);
            }
        }
    }
}
