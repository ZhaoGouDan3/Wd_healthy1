package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityWjxBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class WjxActivity extends BaseActivity<KongViewModel, ActivityWjxBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_wjx;
    }

    @Override
    public void initData() {
        binding.wjx.loadUrl("https://www.wjx.cn/jq/33939807.aspx");
        WebSettings webSettings=binding.wjx.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

    }

    @Override
    public void onChanged(Object o) {

    }
}