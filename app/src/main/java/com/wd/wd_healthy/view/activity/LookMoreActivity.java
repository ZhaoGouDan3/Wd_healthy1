package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityLookMoreBinding;
import com.wd.wd_healthy.model.adapter.HomeFragAdpater;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.ZxBean;
import com.wd.wd_healthy.viewModel.HomeFragViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class LookMoreActivity extends BaseActivity<HomeFragViewModel, ActivityLookMoreBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_look_more;
    }

    @Override
    public void initData() {
        binding.moreTitle.setText(getIntent().getStringExtra("title"));
        viewModel.getZxliveData(getIntent().getIntExtra("id",0),1,20).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof ZxBean){
            ZxBean bean= (ZxBean) o;
            HomeFragAdpater adpater = new HomeFragAdpater(bean.getResult(),LookMoreActivity.this);
            binding.moreRv.setAdapter(adpater);
            binding.moreRv.setLayoutManager(new LinearLayoutManager(LookMoreActivity.this));
            adpater.setOnclickListener(new HomeFragAdpater.OnclickListener() {
                @Override
                public void onclick(int infoid) {
                    Intent intent = new Intent(LookMoreActivity.this, ZbDetailActivity.class);
                    intent.putExtra("id",infoid);
                    startActivity(intent);
                }
            });

        }
    }
}