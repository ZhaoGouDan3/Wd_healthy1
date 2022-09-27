package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyByqBinding;
import com.wd.wd_healthy.databinding.ActivityMySetupBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.util.ClearCacheUtil;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.UpdatePwdViewModel;

import java.io.File;

public class MySetupActivity extends BaseActivity<UpdatePwdViewModel, ActivityMySetupBinding>{
    private String sdPath;
    private File outCachePath,outFilePath;
    @Override
    public int initlayout() {
        return R.layout.activity_my_setup;
    }

    @Override
    public void initData() {
        Glide.with(this).load(SpUtils.getString("tx")).into(binding.setuptx);
        binding.setupName.setText(SpUtils.getString("nickname"));
        binding.updatePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MySetupActivity.this,UpdatePwd2Activity.class));
            }
        });
        initCacheSize();
        binding.clearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearCacheUtil.clearAllCache(MySetupActivity.this);
                initCacheSize();
            }
        });
        binding.screenLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MySetupActivity.this,ScreenActivity.class));
            }
        });
        binding.inviteFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MySetupActivity.this,InviteActivity.class));
            }
        });
        binding.unlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpUtils.clear();
                startActivity(new Intent(MySetupActivity.this,HomeActivity.class));
                finish();
            }
        });
        binding.mymess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MySetupActivity.this,MymessActivity.class));
            }
        });

    }

    @Override
    public void onChanged(Object o) {

    }
    private void initCacheSize() {
        try {
            String totalCacheSize = ClearCacheUtil.getTotalCacheSize(MySetupActivity.this);
            binding.hctxt.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}