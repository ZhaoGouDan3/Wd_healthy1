package com.wd.wd_healthy.model.adapter;

import android.content.Context;


import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.bean.ShouSouBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class SuoYaoShi extends CommonAdapter<ShouSouBean.ResultBean.DrugsSearchVoListBean> {

    public SuoYaoShi(Context context, int layoutId, List<ShouSouBean.ResultBean.DrugsSearchVoListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ShouSouBean.ResultBean.DrugsSearchVoListBean drugsSearchVoListBean, int position) {
        holder.setText(R.id.yaobu_wen,drugsSearchVoListBean.getDrugsName());
    }
}
