package com.wd.wd_healthy.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.Frag1Binding;
import com.wd.wd_healthy.model.adapter.Frag1Adapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.BannerBean;
import com.wd.wd_healthy.model.bean.KsBean;
import com.wd.wd_healthy.model.bean.TabBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.view.activity.BzAndYpActivity;
import com.wd.wd_healthy.view.activity.DoctorListActivity;
import com.wd.wd_healthy.view.activity.LoginActivity;
import com.wd.wd_healthy.view.activity.LookMoreActivity;
import com.wd.wd_healthy.view.activity.SearchActivity;
import com.wd.wd_healthy.view.activity.UserMessActivity;
import com.wd.wd_healthy.view.activity.WjxActivity;
import com.wd.wd_healthy.viewModel.Frag1ViewModel;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.im.android.api.event.MyInfoUpdatedEvent;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/11
 */
public class frag1 extends BaseFragment<Frag1ViewModel, Frag1Binding> {
    List<String> list=new ArrayList<>();
    private int plateId=1;
    private String title="健康养生";
    @Override
    public int initlayout() {
        return R.layout.frag1;
    }

    @Override
    public void initData() {
        Glide.with(getContext()).load(SpUtils.getString("tx")).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(binding.tx);
        viewModel.getBannerlive().observe(this,this);
        viewModel.getKslivedata().observe(this,this);
        viewModel.getTabliveData().observe(this,this);
        binding.bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BzAndYpActivity.class).putExtra("choose",0));
            }
        });
        binding.yp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BzAndYpActivity.class).putExtra("choose",1));
            }
        });
        binding.lookmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LookMoreActivity.class);
                intent.putExtra("id",plateId);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
        binding.tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!SpUtils.getBoolean("login")){
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    startActivityForResult(intent,1);
                }else{
                    Intent intent = new Intent(getActivity(), UserMessActivity.class);
                    startActivity(intent);
                }
            }
        });
        binding.searched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            Glide.with(getContext()).load(SpUtils.getString("tx")).into(binding.tx);
        }
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof BannerBean){
            BannerBean bean= (BannerBean) o;
            binding.xb.setData(bean.getResult(),null);
            binding.xb.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getActivity()).load(bean.getResult().get(position).getImageUrl()).into((ImageView) view);
                }
            });
            binding.xb.setPageTransformer(Transformer.Zoom);
            binding.xb.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, int position) {
                    if(position==2){
                        startActivity(new Intent(getContext(), WjxActivity.class));
                    }
                }
            });
        }else if(o instanceof KsBean){
            KsBean bean= (KsBean) o;
            Frag1Adapter adapter=new Frag1Adapter(bean.getResult(),getContext());
            binding.frag1Rv.setAdapter(adapter);
//            binding.frag1Rv.setLayoutManager(new GridLayoutManager(getContext(),4));
            RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),4){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            binding.frag1Rv.setLayoutManager(layoutManager);
            adapter.setOnclickListener(new Frag1Adapter.OnclickListener() {
                @Override
                public void onClick(int id) {
                    Intent intent = new Intent(getContext(), DoctorListActivity.class);
                    intent.putExtra("p",id);
                    startActivity(intent);
                }
            });

        }else if(o instanceof TabBean){
            TabBean tabBean= (TabBean) o;
            binding.frag1Vp.setOffscreenPageLimit(2);
            for (TabBean.ResultBean resultBean : tabBean.getResult()) {
               list.add(resultBean.getName());
            }
            List<Fragment> list1=new ArrayList<>();
            for (int i = 0; i < tabBean.getResult().size(); i++) {
                list1.add(new HomeFrag(tabBean.getResult().get(i).getId()));
            }
            binding.frag1Vp.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
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
            binding.homeTab.setupWithViewPager(binding.frag1Vp);
            binding.homeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    plateId=tabBean.getResult().get(tab.getPosition()).getId();
                    title=tabBean.getResult().get(tab.getPosition()).getName();
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
    @Override
    public void onResume() {
        super.onResume();
        binding.xb.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        binding.xb.stopAutoPlay();
    }

}
