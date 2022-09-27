package com.wd.wd_healthy.view.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.fragment.app.Fragment;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.BzBinding;
import com.wd.wd_healthy.model.adapter.FragTabAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.BzBean;
import com.wd.wd_healthy.viewModel.BzViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.SimpleTabAdapter;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class BzFrag extends BaseFragment<BzViewModel, BzBinding> {
    ArrayList<String> list=new ArrayList<>();
    @Override
    public int initlayout() {
        return R.layout.bz;
    }

    @Override
    public void initData() {
        viewModel.getBzliveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof BzBean){
            BzBean bean= (BzBean) o;
            ArrayList<Fragment> list1=new ArrayList<>();
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i).getDepartmentName());
                list1.add(new BzFrag2(bean.getResult().get(i).getId()));
            }

            FragTabAdapter fragTabAdapter = new FragTabAdapter(getChildFragmentManager(), list1, list);
            binding.verVp.setAdapter(fragTabAdapter);
            binding.verTab.setupWithViewPager(binding.verVp);
        }
    }
}
