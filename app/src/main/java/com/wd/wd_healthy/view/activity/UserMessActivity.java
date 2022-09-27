package com.wd.wd_healthy.view.activity;

import android.content.Intent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityUserMessBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.KongViewModel;

public class UserMessActivity extends BaseActivity<KongViewModel, ActivityUserMessBinding>{

    @Override
    public int initlayout() {
        return R.layout.activity_user_mess;
    }

    @Override
    public void initData() {
        Glide.with(this).load(SpUtils.getString("tx")).into(binding.mytx);
        binding.myname.setText(SpUtils.getString("nickname"));
        binding.myfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, DangAnActivity.class));
            }
        });
        binding.mypocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, PocketActivity.class));
            }
        });
        binding.mycol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MyColActivity.class));
            }
        });
        binding.myyj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, CaiNaActivity.class));
            }
        });
        binding.myvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MyVideoActivity.class));
            }
        });
        binding.mybyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MyByqActivity.class));
            }
        });
        binding.myattention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MyGzActivity.class));
            }
        });
        binding.mytask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MySignActivity.class));
            }
        });
        binding.mysetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MySetupActivity.class));
            }
        });
        binding.mysetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this, MySetupActivity.class));
            }
        });
        binding.current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this,CurrentWzActivity.class));
            }
        });
        binding.history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMessActivity.this,CurrentWzActivity.class));
            }
        });
    }

    @Override
    public void onChanged(Object o) {

    }
}