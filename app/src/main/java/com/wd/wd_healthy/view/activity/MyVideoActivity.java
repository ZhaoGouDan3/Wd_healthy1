package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyVideoBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.MyVideoBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.MyVideoViewModel;

public class MyVideoActivity extends BaseActivity<MyVideoViewModel, ActivityMyVideoBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_my_video;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof MyVideoBean){
            MyVideoBean bean= (MyVideoBean) o;
            if(bean.getResult().size()>0){
                binding.videorv.setVisibility(View.VISIBLE);
                binding.cnnone.setVisibility(View.GONE);




            }else{
                binding.videorv.setVisibility(View.GONE);
                binding.cnnone.setVisibility(View.VISIBLE);
            }
        }
    }
}