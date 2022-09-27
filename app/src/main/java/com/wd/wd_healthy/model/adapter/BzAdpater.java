package com.wd.wd_healthy.model.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.wd_healthy.R;
import com.wd.wd_healthy.databinding.BzitemBinding;
import com.wd.wd_healthy.model.bean.BzmessageBean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/12
 */
public class BzAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<BzmessageBean.ResultBean> list;
    private Context context;

    public BzAdpater(List<BzmessageBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BzitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.bzitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        BzitemBinding binding= (BzitemBinding) viewHolder.binding;
        if(position==0||position==1){
            binding.bzitemName.setPadding(0,32,0,0);
        }
        binding.bzitemName.setText(list.get(position).getName());
        binding.bzitemName.setOnClickListener(new View.OnClickListener() {
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
    private OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }
}
