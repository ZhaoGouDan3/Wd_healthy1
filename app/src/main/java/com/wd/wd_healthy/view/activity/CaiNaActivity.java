package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityCaiNaBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.CaiNaBean;
import com.wd.wd_healthy.viewModel.CaiNaViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class CaiNaActivity extends BaseActivity<CaiNaViewModel, ActivityCaiNaBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_cai_na;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof CaiNaBean){
            CaiNaBean bean= (CaiNaBean) o;
            if(bean.getResult().size()>0){
                binding.cnrv.setVisibility(View.VISIBLE);
                binding.cnnone.setVisibility(View.GONE);
            }else{
                binding.cnnone.setVisibility(View.VISIBLE);
                binding.cnrv.setVisibility(View.GONE);
            }
        }
    }
}