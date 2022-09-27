package com.wd.wd_healthy.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityBzAndYpBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.view.fragment.BzFrag;
import com.wd.wd_healthy.view.fragment.YpFrag;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.util.ArrayList;
import java.util.List;

public class BzAndYpActivity extends BaseActivity<KongViewModel, ActivityBzAndYpBinding>{
    String[] title={"常见病症","常用药品"};
    @Override
    public int initlayout() {
        return R.layout.activity_bz_and_yp;
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int choose = intent.getIntExtra("choose", 0);
        List<Fragment> list=new ArrayList<>();
        list.add(new BzFrag());
        list.add(new YpFrag());
        binding.bzvp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return  title[position];
            }
        });
        binding.bztab.setupWithViewPager(binding.bzvp);
        binding.bztab.getTabAt(choose).select();
    }

    @Override
    public void onChanged(Object o) {

    }
}