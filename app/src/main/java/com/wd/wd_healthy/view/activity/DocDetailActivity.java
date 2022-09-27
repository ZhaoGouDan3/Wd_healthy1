package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityDocDetailBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.DocDetailBean;
import com.wd.wd_healthy.viewModel.DocDetailViewModel;
import com.wd.wd_healthy.viewModel.ListViewModel;

public class DocDetailActivity extends BaseActivity<DocDetailViewModel, ActivityDocDetailBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_doc_detail;
    }

    @Override
    public void initData() {
        viewModel.getLiveData(getIntent().getIntExtra("id",0)).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof DocDetailBean){
            DocDetailBean bean= (DocDetailBean) o;
            Glide.with(this).load(bean.getResult().getImagePic()).into(binding.detailImg);
            binding.detailName.setText(bean.getResult().getDoctorName());
            binding.detailHos.setText(bean.getResult().getInauguralHospital());
            binding.detailJob.setText(bean.getResult().getJobTitle());
            binding.detailHp.setText("好评率 "+bean.getResult().getPraise());
            binding.detailNum.setText("服务患者数 "+bean.getResult().getServerNum());
            binding.jj.setText(bean.getResult().getPersonalProfile());
            binding.ll.setText(bean.getResult().getGoodField());

        }
    }
}