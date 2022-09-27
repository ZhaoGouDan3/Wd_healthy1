package com.wd.wd_healthy.view.fragment;

import androidx.fragment.app.Fragment;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.BzBinding;
import com.wd.wd_healthy.databinding.YpBinding;
import com.wd.wd_healthy.model.adapter.FragTabAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.YpBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.YpViewModel;

import java.util.ArrayList;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class YpFrag extends BaseFragment<YpViewModel, YpBinding> {
    ArrayList<String> list=new ArrayList<>();
    @Override
    public int initlayout() {
        return R.layout.yp;
    }

    @Override
    public void initData() {
        viewModel.getYpBeanMediatorLiveData().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof YpBean){
            YpBean bean= (YpBean) o;
            ArrayList<Fragment> list1=new ArrayList<>();
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(bean.getResult().get(i).getName());
                list1.add(new YpFrag2(bean.getResult().get(i).getId()));
            }

            FragTabAdapter fragTabAdapter = new FragTabAdapter(getChildFragmentManager(), list1, list);
            binding.vertVp.setAdapter(fragTabAdapter);
            binding.vertTab.setupWithViewPager(binding.vertVp);
        }
    }
}
