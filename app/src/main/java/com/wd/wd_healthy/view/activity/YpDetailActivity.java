package com.wd.wd_healthy.view.activity;

import android.content.Intent;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityBzDetailBeanBinding;
import com.wd.wd_healthy.databinding.YpdetailBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.BzDetailBean;
import com.wd.wd_healthy.model.bean.YpDetailBean;
import com.wd.wd_healthy.viewModel.BzDetailViewModel;
import com.wd.wd_healthy.viewModel.YpDetailViewModel;

public class YpDetailActivity extends BaseActivity<YpDetailViewModel, YpdetailBinding>{
    String title ="";
    @Override
    public int initlayout() {
        return R.layout.ypdetail;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        viewModel.getLiveData(id).observe(this,this);

    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof YpDetailBean){
            YpDetailBean bean= (YpDetailBean) o;
            binding.ypTitle.setText(bean.getResult().getName());
            binding.ypCfmess.setText(bean.getResult().getComponent());
            binding.ypYymess.setText(bean.getResult().getTaboo());
            binding.ypGnmess.setText(bean.getResult().getEffect());
            binding.ypYfmess.setText(bean.getResult().getUsage());
            binding.ypXzmess.setText(bean.getResult().getShape());
            binding.ypBzmess.setText(bean.getResult().getPacking());
            binding.ypBlmess.setText(bean.getResult().getSideEffects());
            binding.ypCcmess.setText(bean.getResult().getStorage());
            binding.ypSxmess.setText(bean.getResult().getMindMatter());
            binding.ypWhmess.setText(bean.getResult().getApprovalNumber());

        }
    }
}