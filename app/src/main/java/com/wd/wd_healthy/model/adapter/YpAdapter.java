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
import com.wd.wd_healthy.databinding.YpitemBinding;
import com.wd.wd_healthy.model.bean.YpMessBean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/13
 */
public class YpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<YpMessBean.ResultBean> list;
    private Context context;

    public YpAdapter(List<YpMessBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YpitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.ypitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        YpitemBinding binding= (YpitemBinding) viewHolder.binding;
        binding.ypName.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getPicture()).into(binding.ypImg);
        if((position+1)%3!=0){
            binding.ypImg.setPadding(0,0,8,0);
            binding.ypName.setPadding(0,0,8,0);
        }
        if(position>2){
            binding.ypImg.setPadding(0,20,0,0);
        }
        binding.ypImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onclickListener!=null){
                    onclickListener.onClick(list.get(position).getId(),list.get(position).getName());
                }
            }
        });
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
    public interface OnclickListener{
        void onClick(int id,String name);
    }
    private BzAdpater.OnclickListener onclickListener;

    public void setOnclickListener(BzAdpater.OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }
}
