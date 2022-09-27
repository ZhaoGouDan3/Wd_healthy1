package com.wd.wd_healthy.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.ActivityByqDetailBinding;
import com.wd.wd_healthy.model.adapter.DpAdapter;
import com.wd.wd_healthy.model.base.BaseActivity;
import com.wd.wd_healthy.model.bean.ByqDetailBean;
import com.wd.wd_healthy.model.bean.QuanPingLieBean;
import com.wd.wd_healthy.model.bean.SendEmailBean;
import com.wd.wd_healthy.model.util.SpUtils;
import com.wd.wd_healthy.viewModel.ByqDetailViewModel;
import com.wd.wd_healthy.viewModel.KongViewModel;

import java.text.SimpleDateFormat;

public class ByqDetailActivity extends BaseActivity<ByqDetailViewModel, ActivityByqDetailBinding>{
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
    private RecyclerView dprv;
    private int sickId=0;
    @Override
    public int initlayout() {
        return R.layout.activity_byq_detail;
    }

    @Override
    public void initData() {
        if(SpUtils.getBoolean("iknow")){
            binding.iknow1.setVisibility(View.GONE);
        }else{
            binding.iknow1.setVisibility(View.VISIBLE);
        }
        binding.iknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.iknow1.setVisibility(View.GONE);
                SpUtils.putBoolean("iknow",true);
            }
        });

        viewModel.getLiveData(getIntent().getIntExtra("sickId",0)).observe(this,this);
        if(getIntent().getIntExtra("amount",0)==0){
            binding.amount.setVisibility(View.GONE);
            binding.amount2.setVisibility(View.GONE);
            binding.amount1.setVisibility(View.GONE);
        }else{
            binding.amount.setVisibility(View.VISIBLE);
            binding.amount2.setVisibility(View.VISIBLE);
            binding.amount1.setVisibility(View.VISIBLE);
            binding.amount.setText(getIntent().getIntExtra("amount",0)+"H");
        }


        binding.pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= LayoutInflater.from(ByqDetailActivity.this).inflate(R.layout.activity_detail_pl,null);
                dprv=view.findViewById(R.id.dprv);
                viewModel.getLiveData3(sickId,1,5).observe(ByqDetailActivity.this,ByqDetailActivity.this);
                ImageView close=view.findViewById(R.id.close);
                ImageView send=view.findViewById(R.id.send);
                EditText pled=view.findViewById(R.id.pled);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.getLiveData5(sickId,pled.getText().toString()).observe(ByqDetailActivity.this,ByqDetailActivity.this);
                    }
                });

                PopupWindow popupWindow = new PopupWindow();
                popupWindow.setContentView(view);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(view,0,0,0);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public void onChanged(Object o) {
        if(o instanceof ByqDetailBean){
            ByqDetailBean bean= (ByqDetailBean) o;
            if(bean.getStatus().equals("0000")){
                sickId=bean.getResult().getSickCircleId();
                binding.bName.setText(bean.getResult().getAdoptNickName());
                binding.bBz.setText(bean.getResult().getDisease());
                binding.bKs.setText(bean.getResult().getDepartment());
                binding.bDetail.setText(bean.getResult().getDetail());
                binding.bZljl.setText(bean.getResult().getTreatmentHospital()+"\t\t\t\t\t\t\t\t\t\t"+sdf.format(bean.getResult().getTreatmentStartTime())+"-"+sdf.format(bean.getResult().getTreatmentEndTime())+"\n\n"+bean.getResult().getTreatmentProcess());
                if(bean.getResult().getCollectionFlag()==1){
                    binding.scnow.setImageResource(R.drawable.common_button_collection_small_s);
                }else{
                    binding.scnow.setImageResource(R.drawable.common_button_collection_small_n);
                }
                binding.scnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(bean.getResult().getCollectionFlag()==1){
                            viewModel.getLiveData2(bean.getResult().getSickCircleId()).observe(ByqDetailActivity.this,ByqDetailActivity.this);
                            binding.scnow.setImageResource(R.drawable.common_button_collection_small_n);
                            bean.getResult().setCollectionFlag(2);

                        }else{
                            viewModel.getLiveData1(bean.getResult().getSickCircleId()).observe(ByqDetailActivity.this,ByqDetailActivity.this);
                            binding.scnow.setImageResource(R.drawable.common_button_collection_small_s);
                            bean.getResult().setCollectionFlag(1);
                        }
                    }
                });
                binding.scnum.setText(bean.getResult().getCollectionNum()+"");
                binding.plnum.setText(bean.getResult().getCommentNum()+"");
                Glide.with(this).load(bean.getResult().getPicture()).into(binding.bAbimg);
            }
        }else if(o instanceof SendEmailBean){
            SendEmailBean bean1= (SendEmailBean) o;
            Toast.makeText(ByqDetailActivity.this,bean1.getMessage(), Toast.LENGTH_SHORT).show();
            if(bean1.getMessage().equals("评论成功")){
                viewModel.getLiveData3(sickId,1,5).observe(ByqDetailActivity.this,ByqDetailActivity.this);
            }

        }else if(o instanceof QuanPingLieBean){
            QuanPingLieBean bean= (QuanPingLieBean) o;
            if(bean.getStatus().equals("0000")){
                DpAdapter dpAdapter = new DpAdapter(bean.getResult(), ByqDetailActivity.this);
                dprv.setAdapter(dpAdapter);
                dprv.setLayoutManager(new LinearLayoutManager(ByqDetailActivity.this));
                dpAdapter.setOnClickListener(new DpAdapter.OnClickListener() {
                    @Override
                    public void onClick(int commentId,int flag) {
                        viewModel.getLiveData4(commentId, flag).observe(ByqDetailActivity.this,ByqDetailActivity.this);
                    }
                });
            }
        }
    }
}