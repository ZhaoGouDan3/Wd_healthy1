package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityDetailPlBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.viewModel.DpViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class DetailPlActivity extends BaseActivity<DpViewModel, ActivityDetailPlBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_detail_pl;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onChanged(Object o) {

    }
}