package com.wd.wd_healthy.view.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.Frag2Binding;
import com.wd.wd_healthy.databinding.Frag3Binding;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.CategoryBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.VideoViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某frag1
 * @date 2022/9/11
 */
public class frag3 extends BaseFragment<VideoViewModel, Frag3Binding> {

    @Override
    public int initlayout() {
        return R.layout.frag3;
    }

    @Override
    public void initData() {

        viewModel.getKslivedata().observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof CategoryBean){
            CategoryBean bean= (CategoryBean) o;
            List<Fragment> list=new ArrayList<>();
            binding.vdvp.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
                @NonNull
                @Override
                public Fragment getItem(int position) {
                    return new VideoFrag(bean.getResult().get(position).getId());
                }

                @Override
                public int getCount() {
                    return bean.getResult().size();
                }

                @Nullable
                @Override
                public CharSequence getPageTitle(int position) {
                    return bean.getResult().get(position).getName();
                }
            });
            binding.vdtab.setupWithViewPager(binding.vdvp);
            binding.vdtab.getTabAt(0).select();
        }
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        GSYVideoManager.releaseAllVideos();
    }
}
