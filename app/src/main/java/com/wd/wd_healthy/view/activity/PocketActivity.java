package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityPocketBinding;
import com.wd.wd_healthy.model.adapter.PocketAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.PayHistoryBean;
import com.wd.wd_healthy.model.bean.WallBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.PocketViewModel;

public class PocketActivity extends BaseActivity<PocketViewModel, ActivityPocketBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_pocket;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);
        viewModel.getLiveData1().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof WallBean){
            WallBean bean= (WallBean) o;
            binding.money.setText(bean.getResult()+"");
        }else if(o instanceof PayHistoryBean){
            PayHistoryBean bean= (PayHistoryBean) o;
            PocketAdapter adapter = new PocketAdapter(bean.getResult(), PocketActivity.this);
            binding.wallRv.setAdapter(adapter);
            binding.wallRv.setLayoutManager(new LinearLayoutManager(PocketActivity.this));
        }
    }
}