package com.wd.wd_healthy.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.GzitemBinding;
import com.wd.wd_healthy.model.bean.GzBean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/17
 */
public class GzAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<GzBean.ResultBean> list;
    private Context context;

    public GzAdapter(List<GzBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GzitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.gzitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        GzitemBinding binding= (GzitemBinding) viewHolder.binding;
        binding.gzName.setText(list.get(position).getName());
        binding.gzJob.setText(list.get(position).getJobTitle());
        binding.gzKs.setText(list.get(position).getInauguralHospital()+"/"+list.get(position).getDepartmentName());
        binding.gzHp.setText("好评率  "+list.get(position).getPraise());
        binding.gzNum.setText("服务患者数  "+list.get(position).getPraiseNum());
        Glide.with(context).load(list.get(position).getImagePic()).into(binding.gzImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
