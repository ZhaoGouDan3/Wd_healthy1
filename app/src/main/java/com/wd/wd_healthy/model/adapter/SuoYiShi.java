package com.wd.wd_healthy.model.adapter;

import android.content.Context;


import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.bean.ShouSouBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class SuoYiShi extends CommonAdapter<ShouSouBean.ResultBean.DoctorSearchVoListBean> {
    public SuoYiShi(Context context, int layoutId, List<ShouSouBean.ResultBean.DoctorSearchVoListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ShouSouBean.ResultBean.DoctorSearchVoListBean doctorSearchVoListBean, int position) {
        holder.setText(R.id.yibu_wen,doctorSearchVoListBean.getDoctorName());
    }
}
