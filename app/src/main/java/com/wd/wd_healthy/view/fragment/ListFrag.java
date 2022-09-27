package com.wd.wd_healthy.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ListfragBinding;
import com.wd.wd_healthy.model.adapter.DocAdapter;
import com.wd.wd_healthy.model.base.BaseFragment;
import com.wd.wd_healthy.model.bean.DocListBean;
import com.wd.wd_healthy.model.bean.ZxBean;
import com.wd.wd_healthy.model.bean.ZxNowBean;
import com.wd.wd_healthy.view.activity.ChatActivity;
import com.wd.wd_healthy.view.activity.DocDetailActivity;
import com.wd.wd_healthy.viewModel.KongViewModel;
import com.wd.wd_healthy.viewModel.ListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.view.fragment</p>
 *
 * @author 赵某某
 * @date 2022/9/13
 */
public class ListFrag extends BaseFragment<ListViewModel, ListfragBinding> {
    private int deptId;
    private int condition=1;
    private int pos=0;
    private int docId;
    public ListFrag(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public int initlayout() {
        return R.layout.listfrag;
    }

    @Override
    public void initData() {
        binding.pxtab.addTab(binding.pxtab.newTab().setText("综合"));
        binding.pxtab.addTab(binding.pxtab.newTab().setText("好评"));
        binding.pxtab.addTab(binding.pxtab.newTab().setText("咨询数"));
        binding.pxtab.addTab(binding.pxtab.newTab().setText("价格"));
        binding.pxtab.getTabAt(0).select();
        data();
        binding.pxtab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                condition=tab.getPosition()+1;
                data();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void data(){
        viewModel.getLiveData(deptId,condition,1,5).observe(this,this);
    }
    public void data2(int docId){
        viewModel.getLiveData1(docId).observe(this,this);
    }
    @Override
    public void onChanged(Object o) {
        if(o instanceof DocListBean){
            DocListBean bean= (DocListBean) o;
            Glide.with(getContext()).load(bean.getResult().get(0).getImagePic()).into(binding.docImg);
            binding.docName.setText(bean.getResult().get(0).getDoctorName());
            binding.docJob.setText(bean.getResult().get(0).getJobTitle());
            binding.docHos.setText(bean.getResult().get(0).getInauguralHospital());
            binding.docHp.setText("好评率  "+bean.getResult().get(0).getPraise());
            binding.docNum.setText("服务患者数  "+bean.getResult().get(0).getServerNum()+"");
            docId=bean.getResult().get(0).getDoctorId();
            DocAdapter docAdapter = new DocAdapter(bean.getResult(), getContext());
            binding.docRv.setAdapter(docAdapter);
            binding.docRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
            docAdapter.setOnclickListener(new DocAdapter.OnclickListener() {
                @Override
                public void onClick(int p) {
                    Glide.with(getContext()).load(bean.getResult().get(p).getImagePic()).into(binding.docImg);
                    binding.docName.setText(bean.getResult().get(p).getDoctorName());
                    binding.docJob.setText(bean.getResult().get(p).getJobTitle());
                    binding.docHos.setText(bean.getResult().get(p).getInauguralHospital());
                    binding.docHp.setText("好评率  "+bean.getResult().get(p).getPraise());
                    binding.docNum.setText("服务患者数  "+bean.getResult().get(p).getServerNum()+"");
                    docId=bean.getResult().get(p).getDoctorId();
                    pos=p;
                }
            });
            binding.docDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DocDetailActivity.class);
                    intent.putExtra("id",bean.getResult().get(pos).getDoctorId());
                    startActivity(intent);
                }
            });
            binding.zxNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data2(docId);
                }
            });
        }else if(o instanceof ZxNowBean){
            ZxNowBean bean= (ZxNowBean) o;
            Toast.makeText(getContext(),bean.getMessage(), Toast.LENGTH_SHORT).show();
            if(bean.getStatus().equals("0000")){
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        }
    }
}
