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
import com.wd.wd_healthy.databinding.SicklistitemBinding;
import com.wd.wd_healthy.model.bean.ColSickBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.adapter</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class SickAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ColSickBean.ResultBean> list;
    private Context context;

    public SickAdapter(List<ColSickBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SicklistitemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.sicklistitem,null,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        SicklistitemBinding binding= (SicklistitemBinding) viewHolder.binding;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
        binding.sickTitle.setText(list.get(position).getTitle());
        binding.sickScnum.setText("收藏  "+list.get(position).getCollectionNum());
        binding.sickAdvice.setText("建议  "+list.get(position).getCommentNum());
        binding.sickTime.setText(sdf.format(list.get(position).getCreateTime()));
        binding.sickMess.setText(list.get(position).getDisease());
        binding.sickClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onclick!=null){
                    onclick.onClick(list.get(position).getSickCircleId(),position);
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
    public interface Onclick{
        void onClick(int sickCircleId,int position);
    }
    private Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }
}
