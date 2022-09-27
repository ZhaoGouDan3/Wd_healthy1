package com.wd.wd_healthy.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ByqfragBinding;
import com.wd.wd_healthy.model.adapter.ByqAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.ByqBean;
import com.wd.wd_healthy.view.activity.ByqDetailActivity;
import com.wd.wd_healthy.viewModel.ByqFragViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/20
 */
public class ByqFragment extends BaseFragment<ByqFragViewModel, ByqfragBinding> {
    private int dpid;
    private int page=1;
    private List<ByqBean.ResultBean> list=new ArrayList<>();
    private ByqAdapter byqAdapter;

    public ByqFragment(int dpid) {
        this.dpid = dpid;
    }



    @Override
    public int initlayout() {
        return R.layout.byqfrag;
    }

    @Override
    public void initData() {
        viewModel.getLiveData(dpid,page).observe(this,this);
        binding.smart.setEnableRefresh(true);
        binding.smart.setEnableLoadMore(true);
        binding.smart.setOnRefreshLoadMoreListener(new com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull com.scwang.smartrefresh.layout.api.RefreshLayout refreshLayout) {
                page++;
                init();
                binding.smart.finishLoadMore(1000);
            }

            @Override
            public void onRefresh(@NonNull com.scwang.smartrefresh.layout.api.RefreshLayout refreshLayout) {
                page=1;
                init();
                binding.smart.finishRefresh(1000);

            }
        });
        binding.byqRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                 if(dy<-10){
                    EventBus.getDefault().post("down");
                }else if(dy>10){
                     EventBus.getDefault().post("up");
                 }
            }
        });

    }



    public interface ICallBack{
        void iCallBack(String mess);
    }
    private ICallBack iCallBack;

    public void setiCallBack(ICallBack iCallBack) {
        this.iCallBack = iCallBack;
    }

    private void init(){
        viewModel.getLiveData(dpid,page).observe(this,this);

    }
    @Override
    public void onChanged(Object o) {
        if(o instanceof ByqBean){
            ByqBean bean= (ByqBean) o;
            if(bean.getStatus().equals("0000")){
                if(page==1){
                    list.clear();
                }

                list.addAll(bean.getResult());
                if(byqAdapter==null){
                    byqAdapter = new ByqAdapter(list, getActivity());
                    binding.byqRv.setAdapter(byqAdapter);
                    binding.byqRv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

                }else{
                    byqAdapter.notifyDataSetChanged();
                }



                byqAdapter.setOnclick(new ByqAdapter.Onclick() {
                    @Override
                    public void onClick(int sickId,int amount) {
                        startActivity(new Intent(getContext(), ByqDetailActivity.class).putExtra("sickId",sickId).putExtra("amount",amount));
                    }
                });


            }
        }
    }
}
