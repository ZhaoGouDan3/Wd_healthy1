package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityUpdatePwdBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.RsaCoder;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.UpdatePwdViewModel;

public class UpdatePwdActivity extends BaseActivity<UpdatePwdViewModel, ActivityUpdatePwdBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_update_pwd;
    }

    @Override
    public void initData() {
        binding.loseUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s = RsaCoder.encryptByPublicKey(binding.losePwd1.getText().toString());
                    String s1 = RsaCoder.encryptByPublicKey(binding.losePwd2.getText().toString());
                    String email = getIntent().getStringExtra("email");
                    viewModel.getLiveData(email,s,s1).observe(UpdatePwdActivity.this,UpdatePwdActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            if(bean.getMessage().equals("密码重置成功")){
                finish();
            }
        }
    }
}