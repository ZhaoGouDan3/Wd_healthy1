package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityZbDetailBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.ZxDetailBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.ZbDetailViewModel;

public class ZbDetailActivity extends BaseActivity<ZbDetailViewModel, ActivityZbDetailBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_zb_detail;
    }

    @Override
    public void initData() {
        viewModel.getLiveData(getIntent().getIntExtra("id",0)).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof ZxDetailBean){
            ZxDetailBean bean= (ZxDetailBean) o;
            String varjs = "<script type='text/javascript'> window.onload = function(){var $img = document.getElementsByTagName('img');for(var p in  $img){$img[p].style.maxWidth = '100%'; $img[p].style.height ='auto'}}</script>";
            binding.web.loadDataWithBaseURL("",bean.getResult().getContent()+varjs,"text/html","utf-8",null);
            WebSettings webSettings=binding.web.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
    }
}