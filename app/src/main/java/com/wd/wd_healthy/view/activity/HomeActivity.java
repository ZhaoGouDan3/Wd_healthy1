package com.wd.wd_healthy.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityHomeBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.view.fragment.frag1;
import com.wd.wd_healthy.view.fragment.frag2;
import com.wd.wd_healthy.view.fragment.frag3;
import com.wd.wd_healthy.viewModel.KongViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<KongViewModel, ActivityHomeBinding>{

    private int isChecked=1;
    @Override
    public int initlayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        List<Fragment> list=new ArrayList<>();
        list.add(new frag1());
        list.add(new frag2());
        list.add(new frag3());
        binding.homeVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        binding.homeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbt1:
                        binding.homeVp.setCurrentItem(0);
                        isChecked=1;
                        break;
                    case R.id.rbt2:
                        binding.homeVp.setCurrentItem(1);
                        break;
                    case R.id.rbt3:
                        binding.homeVp.setCurrentItem(2);
                        isChecked=1;
                        break;
                }
            }
        });

        binding.rbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked++;
                if(isChecked>2){
                    startActivity(new Intent(HomeActivity.this,FbActivity.class));
                }
            }
        });


    }

    @Override
    public void onChanged(Object o) {

    }
}