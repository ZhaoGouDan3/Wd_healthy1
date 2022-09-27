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
import com.wd.wd_healthy.databinding.Frag1itemBinding;
import com.wd.wd_healthy.model.bean.KsBean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class Frag1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<KsBean.ResultBean> list;
    private Context context;

    public Frag1Adapter(List<KsBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Frag1itemBinding itemBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.frag1item,null,false);
        return  new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Frag1itemBinding binding= (Frag1itemBinding) viewHolder.binding;
        Glide.with(binding.frag1ItemImage).load(list.get(position).getPic()).into(binding.frag1ItemImage);
        binding.frag1ItemName.setText(list.get(position).getDepartmentName());
        if(onclickListener!=null){
            binding.frag1ItemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickListener.onClick(position);
                }
            });
            binding.frag1ItemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public ViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    public interface OnclickListener{
        void onClick(int id);
    }
    private OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }
}
