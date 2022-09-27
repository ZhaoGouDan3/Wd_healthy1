package com.wd.wd_healthy.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.Frag1Binding;
import com.wd.wd_healthy.databinding.Frag2Binding;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.view.activity.HomeActivity;
import com.wd.wd_healthy.viewModel.Frag2ViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某frag1
 * @date 2022/9/11
 */
public class frag2 extends BaseFragment<Frag2ViewModel, Frag2Binding> {
    private List<Fragment> list=new ArrayList<>();
    private List<String> list1=new ArrayList<>();
    private String name;
    @Override
    public int initlayout() {
        return R.layout.frag2;
    }

    @Override
    public void initData() {
        viewModel.getKslivedata().observe(this,this);
        ByqFragment fragment = new ByqFragment(7);
        fragment.setiCallBack(new ByqFragment.ICallBack() {
            @Override
            public void iCallBack(String mess) {
                Toast.makeText(getContext(),mess+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String up){
        if(up.equals("up")){
            binding.tabhead.setVisibility(View.INVISIBLE);
            binding.head.setVisibility(View.VISIBLE);
            binding.kshead.setText(name);
        }else{
            binding.tabhead.setVisibility(View.VISIBLE);
            binding.head.setVisibility(View.GONE);
        }
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof KsBean){
            KsBean bean= (KsBean) o;
            for (int i = 0; i < bean.getResult().size(); i++) {
                list.add(new ByqFragment(bean.getResult().get(i).getId()));
                list1.add(bean.getResult().get(i).getDepartmentName());
            }
            binding.byqvp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
                @NonNull
                @Override
                public Fragment getItem(int position) {
                    return new ByqFragment(bean.getResult().get(position).getId());
                }

                @Override
                public int getCount() {
                    return bean.getResult().size();
                }

                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    return bean.getResult().get(position).getDepartmentName();
                }
            });
            binding.byqtab.setupWithViewPager(binding.byqvp);
            binding.byqtab.getTabAt(0).select();
            name=binding.byqtab.getTabAt(0).getText().toString();
            binding.byqtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    name=binding.byqtab.getTabAt(tab.getPosition()).getText().toString();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }
}
