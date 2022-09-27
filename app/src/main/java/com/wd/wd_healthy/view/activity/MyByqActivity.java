package com.wd.wd_healthy.view.activity;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyByqBinding;
import com.wd.wd_healthy.model.adapter.ScByqAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.MyByqBean;
import com.wd.wd_healthy.viewModel.ByqViewModel;

public class MyByqActivity extends BaseActivity<ByqViewModel, ActivityMyByqBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_my_byq;
    }

    @Override
    public void initData() {
        viewModel.getBzmessageBeanMediatorLiveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof MyByqBean){
            MyByqBean bean= (MyByqBean) o;
            if(bean.getResult().size()>0){
                ScByqAdapter adapter = new ScByqAdapter(bean.getResult(), MyByqActivity.this);
                binding.scbyqrv.setAdapter(adapter);
                binding.scbyqrv.setLayoutManager(new LinearLayoutManager(MyByqActivity.this));
                binding.scbyqrv.setVisibility(View.VISIBLE);
                binding.byqnone.setVisibility(View.GONE);
            }else{
                binding.scbyqrv.setVisibility(View.GONE);
                binding.byqnone.setVisibility(View.VISIBLE);
            }
        }
    }
}