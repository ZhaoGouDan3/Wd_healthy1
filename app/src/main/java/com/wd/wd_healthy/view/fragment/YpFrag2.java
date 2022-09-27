package com.wd.wd_healthy.view.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.BzBinding;
import com.wd.wd_healthy.databinding.BzfragBinding;
import com.wd.wd_healthy.databinding.YpBinding;
import com.wd.wd_healthy.databinding.YpfragBinding;
import com.wd.wd_healthy.model.adapter.BzAdpater;
import com.wd.wd_healthy.model.adapter.YpAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.YpMessBean;
import com.wd.wd_healthy.view.activity.BzDetailActivity;
import com.wd.wd_healthy.view.activity.YpDetailActivity;
import com.wd.wd_healthy.viewModel.BzViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.YpFragViewModel;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class YpFrag2 extends BaseFragment<YpFragViewModel, BzfragBinding> {
    private int id;

    public YpFrag2(int id) {
        this.id = id;
    }

    @Override
    public int initlayout() {
        return R.layout.bzfrag;
    }

    @Override
    public void initData() {
        viewModel.getYpMessBeanMediatorLiveData(id).observe(this,this);
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof YpMessBean){
            YpMessBean bean= (YpMessBean) o;
            YpAdapter adapter=new YpAdapter(bean.getResult(),getContext());
            binding.bzrv.setAdapter(adapter);
            binding.bzrv.setLayoutManager(new GridLayoutManager(getContext(),3));
            adapter.setOnclickListener(new BzAdpater.OnclickListener() {
                @Override
                public void onClick(int id, String name) {
                    Intent intent = new Intent(getContext(), YpDetailActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
        }
    }
}
