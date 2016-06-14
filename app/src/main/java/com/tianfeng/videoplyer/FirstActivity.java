package com.tianfeng.videoplyer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LUY on 2016/6/6.
 */
public class FirstActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {
        TextView tvBos = (TextView) findViewById(R.id.tv_bos);
        tvBos.setOnClickListener(this);
        TextView tvFalls = (TextView) findViewById(R.id.tv_falls);
        tvFalls.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.tv_bos:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_falls:
                startActivity(new Intent(this,FallsActivity.class));
                break;
//            case R.id.tv_refresh:
//                startActivity(new Intent(this,RefreshActivity.class));
            default:
                break;
        }
    }
}
