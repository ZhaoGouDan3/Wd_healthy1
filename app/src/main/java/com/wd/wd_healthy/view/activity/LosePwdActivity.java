package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityLosePwdBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.viewModel.LoseViewModel;

public class LosePwdActivity extends BaseActivity<LoseViewModel, ActivityLosePwdBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_lose_pwd;
    }

    @Override
    public void initData() {
        binding.hqyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.loseEmail.getText()!=null||binding.loseEmail.getText().toString().equals("")){
                    viewModel.getYpBeanMediatorLiveData(binding.loseEmail.getText().toString()).observe(LosePwdActivity.this,LosePwdActivity.this);
                }
            }
        });
        binding.loseNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getJylivedata(binding.loseEmail.getText().toString(),binding.loseYzm.getText().toString()).observe(LosePwdActivity.this,LosePwdActivity.this);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            Toast.makeText(LosePwdActivity.this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            if(bean.getMessage().equals("验证通过")){
                startActivity(new Intent(LosePwdActivity.this,UpdatePwdActivity.class).putExtra("email",binding.loseEmail.getText().toString()));
                finish();
            }
        }
    }
}