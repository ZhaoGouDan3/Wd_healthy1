package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityUpNameBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.UpNameViewModel;

public class UpNameActivity extends BaseActivity<UpNameViewModel, ActivityUpNameBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_up_name;
    }

    @Override
    public void initData() {
        binding.upName.setHint(SpUtils.getString("nickname"));
        binding.upmyname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getLiveData(binding.upName.getText().toString()).observe(UpNameActivity.this,UpNameActivity.this);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            if(bean.getStatus().equals("0000")){
                setResult(2,new Intent().putExtra("name",binding.upName.getText().toString()));
                finish();
            }
        }
    }
}