package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyGzBinding;
import com.wd.wd_healthy.model.adapter.GzAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.GzBean;
import com.wd.wd_healthy.viewModel.GzViewModel;

public class MyGzActivity extends BaseActivity<GzViewModel, ActivityMyGzBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_my_gz;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof GzBean){
            GzBean bean= (GzBean) o;
            if(bean.getResult().size()>0){
                binding.gzrv.setVisibility(View.VISIBLE);
                binding.gznone.setVisibility(View.GONE);
                GzAdapter adapter=new GzAdapter(bean.getResult(),MyGzActivity.this);
                binding.gzrv.setAdapter(adapter);
                binding.gzrv.setLayoutManager(new LinearLayoutManager(MyGzActivity.this));
            }else{
                binding.gzrv.setVisibility(View.GONE);
                binding.gznone.setVisibility(View.VISIBLE);
            }
        }
    }
}