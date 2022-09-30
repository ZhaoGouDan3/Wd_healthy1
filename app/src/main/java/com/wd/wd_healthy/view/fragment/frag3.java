package com.wd.wd_healthy.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

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
import com.wd.wd_healthy.view.activity.AnimActivity;
import com.wd.wd_healthy.view.activity.HomeActivity;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.VideoViewModel;

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
public class frag3 extends BaseFragment<VideoViewModel, Frag3Binding> {
    private boolean isvis=false;
    @Override
    public int initlayout() {
        return R.layout.frag3;
    }

    @Override
    public void initData() {

        viewModel.getKslivedata().observe(this,this);
        binding.dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isvis){
                    EventBus.getDefault().post("yi");
                    up();
//                    Animation animation2 = AnimationUtils.loadAnimation(AnimActivity.this,R.anim.down);
//                    down.startAnimation(animation2);
//                    animation2.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            down.setVisibility(View.GONE);
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
                }else{
                    EventBus.getDefault().post("er");
                    down();
//                    Animation animation2 = new TranslateAnimation(0,0,100,0);
//                    animation2.setDuration(2000);
//                    down.startAnimation(animation2);
//
//                    animation2.setAnimationListener(new Animation.AnimationListener() {
//                        @Override
//                        public void onAnimationStart(Animation animation) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animation animation) {
//                            down.setVisibility(View.VISIBLE);
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animation animation) {
//
//                        }
//                    });
                }
                isvis=!isvis;
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
    public void anim1(String up){
        Toast.makeText(getContext(), up, Toast.LENGTH_SHORT).show();
        if(up.equals("shou")){
            up();
            isvis=!isvis;
        }
    }
    public void up(){

        Animation animation1 = AnimationUtils.loadAnimation(getContext(),R.anim.up);
        binding.vdtab.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.vdtab.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void down(){

        Animation animation1 =new TranslateAnimation(0,0,-100,0);
        animation1.setDuration(2000);
        binding.vdtab.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.vdtab.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
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
