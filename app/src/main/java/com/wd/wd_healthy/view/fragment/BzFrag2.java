package com.wd.wd_healthy.view.fragment;

import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.BzfragBinding;
import com.wd.wd_healthy.model.adapter.BzAdpater;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.BzmessageBean;
import com.wd.wd_healthy.view.activity.BzDetailActivity;
import com.wd.wd_healthy.viewModel.BzFragViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class BzFrag2 extends BaseFragment<BzFragViewModel, BzfragBinding> {
    private int bzid;

    public BzFrag2(int bzid) {
        this.bzid = bzid;
    }

    @Override
    public int initlayout() {
        return R.layout.bzfrag;
    }

    @Override
    public void initData() {
        viewModel.getBzmessageBeanMediatorLiveData(bzid).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof BzmessageBean){
            BzmessageBean bean= (BzmessageBean) o;
            BzAdpater bzAdpater = new BzAdpater(bean.getResult(), getContext());
            binding.bzrv.setAdapter(bzAdpater);
            bzAdpater.setOnclickListener(new BzAdpater.OnclickListener() {
                @Override
                public void onClick(int id, String name) {
                    Intent intent = new Intent(getContext(), BzDetailActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("title",name);
                    startActivity(intent);
                }
            });
            binding.bzrv.setLayoutManager(new GridLayoutManager(getContext(),2));

        }
    }
}
