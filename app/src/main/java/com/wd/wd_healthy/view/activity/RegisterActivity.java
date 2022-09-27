package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityRegisterBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.viewModel.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initData() {
        binding.refsyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getYpBeanMediatorLiveData(binding.reEmail.getText().toString()).observe(RegisterActivity.this,RegisterActivity.this);
            }
        });
        binding.zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getLiveData(binding.reEmail.getText().toString(),binding.reyzm.getText().toString(),binding.repwd1.getText().toString(),binding.repwd2.getText().toString()).observe(RegisterActivity.this,RegisterActivity.this);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            Toast.makeText(RegisterActivity.this,bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}