package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityBdBankBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class BdBankActivity extends BaseActivity<KongViewModel, ActivityBdBankBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_bd_bank;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onChanged(Object o) {

    }
}