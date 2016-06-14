package com.tianfeng.videoplyer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.tianfeng.videoplyer.uiutls.RecycleViewDivider;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<String> mDatas;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mDatas = new ArrayList();
        for (int i = 'A'; i <= 'Z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.HORIZONTAL, 4,R.color.gray ));

        if(homeAdapter == null){
            homeAdapter = new HomeAdapter(this,mDatas);
            recyclerView.setAdapter(new HomeAdapter(this,mDatas));
        }
        homeAdapter.notifyDataSetChanged();
        homeAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

}
