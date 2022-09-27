package com.wd.wd_healthy.view.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.HomefragBinding;
import com.wd.wd_healthy.model.adapter.Frag1Adapter;
import com.wd.wd_healthy.model.adapter.HomeFragAdpater;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.ZxBean;
import com.wd.wd_healthy.view.activity.ZbDetailActivity;
import com.wd.wd_healthy.viewModel.Frag1ViewModel;
import com.wd.wd_healthy.viewModel.HomeFragViewModel;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class HomeFrag extends BaseFragment<HomeFragViewModel, HomefragBinding> {
    private int plateId;

    public HomeFrag(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public int initlayout() {
        return R.layout.homefrag;
    }

    @Override
    public void initData() {
        viewModel.getZxliveData(plateId,1,5).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof ZxBean){
            ZxBean bean= (ZxBean) o;
            HomeFragAdpater adpater = new HomeFragAdpater(bean.getResult(), getContext());
            binding.homeRv.setAdapter(adpater);
            binding.homeRv.setLayoutManager(new LinearLayoutManager(getContext()){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            adpater.setOnclickListener(new HomeFragAdpater.OnclickListener() {
                @Override
                public void onclick(int infoid) {
                    Intent intent = new Intent(getContext(), ZbDetailActivity.class);
                    intent.putExtra("id",infoid);
                    startActivity(intent);
                }
            });
        }
    }
}
