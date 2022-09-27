package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityCurrentBinding;
import com.wd.wd_healthy.databinding.ActivityCurrentWzBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.bean.WenZhenBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.StopViewModel;

import java.text.SimpleDateFormat;

public class CurrentWzActivity extends BaseActivity<StopViewModel, ActivityCurrentWzBinding>{
    @Override
    public int initlayout() {
        return R.layout.activity_current_wz;
    }

    @Override
    public void initData() {
        viewModel.getLiveData().observe(this,this);

    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof WenZhenBean){
            WenZhenBean bean= (WenZhenBean) o;
            if(!bean.getMessage().equals("当前无问诊")){
                binding.name.setText(bean.getResult().getDoctorName());
                binding.job.setText(bean.getResult().getJobTitle());
                binding.ks.setText(bean.getResult().getDepartment());
                binding.time.setText("问诊时间  "+new SimpleDateFormat("yyyy.MM.dd HH:mm").format(bean.getResult().getInquiryTime()));
                Glide.with(CurrentWzActivity.this).load(bean.getResult().getImagePic()).into(binding.currentImg);
                binding.stop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.getLiveData1(bean.getResult().getRecordId()).observe(CurrentWzActivity.this,CurrentWzActivity.this);
                    }
                });
                binding.haven.setVisibility(View.GONE);
                binding.havec.setVisibility(View.VISIBLE);
                binding.conti.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(CurrentWzActivity.this,ChatActivity.class));
                    }
                });
            }else{
                binding.havec.setVisibility(View.GONE);
                binding.haven.setVisibility(View.VISIBLE);
            }
        }else if(o instanceof SendEmailBean){
            SendEmailBean bean= (SendEmailBean) o;
            Toast.makeText(CurrentWzActivity.this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if(bean.getStatus().equals("0000")){
                binding.havec.setVisibility(View.GONE);
                binding.haven.setVisibility(View.VISIBLE);
            }
        }
    }
}