package com.wd.wd_healthy.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ScvpBinding;
import com.wd.wd_healthy.model.adapter.ColZxAdpater;
import com.wd.wd_healthy.model.adapter.SickAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.ColSickBean;
import com.wd.wd_healthy.model.bean.ColZxBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.MyColViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class MyCollectionFragment extends BaseFragment<MyColViewModel, ScvpBinding> {
    private int id;
    private SickAdapter adapter;
    private List<ColSickBean.ResultBean> list=new ArrayList<>();
    public MyCollectionFragment(int id) {
        this.id = id;
    }

    @Override
    public int initlayout() {
        return R.layout.scvp;
    }

    @Override
    public void initData() {
        switch (id){
            case 1:
                viewModel.getLiveData().observe(this,this);
                break;
            case 2:
               viewModel.getLiveData1().observe(this,this);
                break;
            case 3:
                viewModel.getLiveData2().observe(this,this);
                break;
        }
    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof ColZxBean){
            ColZxBean bean= (ColZxBean) o;
            if(bean.getResult().size()>0){
                binding.scrv.setVisibility(View.VISIBLE);
                binding.scnone.setVisibility(View.GONE);
                ColZxAdpater adpater = new ColZxAdpater(bean.getResult(), getContext());
                binding.scrv.setAdapter(adpater);
                binding.scrv.setLayoutManager(new LinearLayoutManager(getContext()));
            }else{
                binding.scrv.setVisibility(View.GONE);
                binding.scnone.setVisibility(View.VISIBLE);
            }
        }else if(o instanceof ColSickBean){
            ColSickBean bean= (ColSickBean) o;
            list.addAll(bean.getResult());
            if(bean.getResult().size()>0){
                binding.scrv.setVisibility(View.VISIBLE);
                binding.scnone.setVisibility(View.GONE);
                adapter= new SickAdapter(bean.getResult(), getContext());
                binding.scrv.setAdapter(adapter);
                binding.scrv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter.setOnclick(new SickAdapter.Onclick() {
                    @Override
                    public void onClick(int sickCircleId,int p) {
                       delete(sickCircleId);
                       bean.getResult().remove(p);

                       adapter.notifyDataSetChanged();
                       if(bean.getResult().size()==0){
                           binding.scrv.setVisibility(View.GONE);
                           binding.scnone.setVisibility(View.VISIBLE);
                       }
                    }
                });
            }else{
                binding.scrv.setVisibility(View.GONE);
                binding.scnone.setVisibility(View.VISIBLE);
            }
        }
    }
    public void delete(int id){
        viewModel.getLiveData3(id).observe(this,this);
    }
}
