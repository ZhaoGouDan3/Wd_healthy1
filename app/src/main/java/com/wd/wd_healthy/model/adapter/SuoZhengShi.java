package com.wd.wd_healthy.model.adapter;

import android.content.Context;


import com.wd.wd_healthy.R;
import com.wd.wd_healthy.model.bean.ShouSouBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class SuoZhengShi extends CommonAdapter<ShouSouBean.ResultBean.DiseaseSearchVoListBean> {

    public SuoZhengShi(Context context, int layoutId, List<ShouSouBean.ResultBean.DiseaseSearchVoListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ShouSouBean.ResultBean.DiseaseSearchVoListBean diseaseSearchVoListBean, int position) {
        holder.setText(R.id.zhengbu_wen,diseaseSearchVoListBean.getDiseaseName());
    }
}
