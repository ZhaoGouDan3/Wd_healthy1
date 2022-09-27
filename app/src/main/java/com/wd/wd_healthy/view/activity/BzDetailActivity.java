package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityBzDetailBeanBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.BzDetailBean;
import com.wd.wd_healthy.viewModel.BzDetailViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class BzDetailActivity extends BaseActivity<BzDetailViewModel, ActivityBzDetailBeanBinding>{
    String title ="";
    @Override
    public int initlayout() {
        return R.layout.activity_bz_detail_bean;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        viewModel.getLiveData(id).observe(this,this);
        title=intent.getStringExtra("title");
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof BzDetailBean){
            BzDetailBean bean= (BzDetailBean) o;
            binding.bzTitle.setText(title);
            binding.bzBlmess.setText(bean.getResult().getPathology());
            binding.bzZzmess.setText(bean.getResult().getSymptom());
            binding.bzYyjmess.setText(bean.getResult().getBenefitTaboo());
            binding.bzXymess.setText("无");
            binding.bzZymess.setText(bean.getResult().getChineseMedicineTreatment());
        }
    }
}