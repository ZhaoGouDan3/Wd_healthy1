package com.wd.wd_healthy.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityMyColBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.view.fragment.MyCollectionFragment;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyColActivity extends BaseActivity<KongViewModel, ActivityMyColBinding>{
    String[] title={"健康资讯","健康视频","病友圈"};
    @Override
    public int initlayout() {
        return R.layout.activity_my_col;
    }

    @Override
    public void initData() {
        List<Fragment> list=new ArrayList<>();
        list.add(new MyCollectionFragment(1));
        list.add(new MyCollectionFragment(2));
        list.add(new MyCollectionFragment(3));
        binding.scvp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
                return title[position];
            }
        });
        binding.sclayout.setupWithViewPager(binding.scvp);
    }

    @Override
    public void onChanged(Object o) {

    }
}