package com.wd.wd_healthy.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityDoctorListBinding;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.view.fragment.ListFrag;
import com.wd.wd_healthy.viewModel.DoctorViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends BaseActivity<DoctorViewModel, ActivityDoctorListBinding>{
    List<String> list=new ArrayList<>();
    List<Fragment> list1=new ArrayList<>();
    private int p=0;
    @Override
    public int initlayout() {
        return R.layout.activity_doctor_list;
    }

    @Override
    public void initData() {
        viewModel.getKslivedata().observe(this,this);
        Intent intent = getIntent();
        p = intent.getIntExtra("p", 1);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof KsBean){
            KsBean bean= (KsBean) o;
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i).getDepartmentName());
                list1.add(new ListFrag(bean.getResult().get(i).getId()));
            }
            binding.docVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                @NonNull
                @Override
                public Fragment getItem(int position) {
                    return list1.get(position);
                }

                @Override
                public int getCount() {
                    return list1.size();
                }

                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    return list.get(position);
                }
            });
            binding.docTab.setupWithViewPager(binding.docVp);
            binding.docTab.getTabAt(p).select();
        }
    }
}