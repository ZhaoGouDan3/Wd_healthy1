package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityUpSexyBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.UpsexyViewModel;

public class UpSexyActivity extends BaseActivity<UpsexyViewModel, ActivityUpSexyBinding>{

    private int sexy=1;
    @Override
    public int initlayout() {
        return R.layout.activity_up_sexy;
    }

    @Override
    public void initData() {
        if(SpUtils.getInt("sexy")==1){
            binding.v1.setVisibility(View.VISIBLE);
            binding.v2.setVisibility(View.GONE);
        }else{
            binding.v1.setVisibility(View.GONE);
            binding.v2.setVisibility(View.VISIBLE);
        }
        binding.boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.v1.setVisibility(View.VISIBLE);
                binding.v2.setVisibility(View.GONE);
                sexy=1;
            }
        });
        binding.girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.v1.setVisibility(View.GONE);
                binding.v2.setVisibility(View.VISIBLE);
                sexy=2;
            }
        });
        binding.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getLiveData(sexy).observe(UpSexyActivity.this,UpSexyActivity.this);
            }
        });
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            if(bean.getStatus().equals("0000")){
                setResult(3,new Intent().putExtra("sexy",sexy ));
                finish();
            }

        }
    }
}